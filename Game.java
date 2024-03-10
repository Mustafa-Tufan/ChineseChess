import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game extends AbstractGame{
	
	String turn = "red";
	String notTurn = "black";
	int moveCount = 0;
	boolean check = false;
	
	public Game(String player_one, String player_two) {
		Board tahta = new Board();
		tahta.createAndFillBoard();
		this.setBoard(tahta);
		Player p1 = new Player(player_one);
		Player p2 = new Player(player_two);
		setRed(p1);
		setBlack(p2);
	}
	
	public void setPoints() {
		getRed().puan = getBoard().calculatePoints("black");
		getBlack().puan = getBoard().calculatePoints("red");
	}
	
	public void turn() {
		if (moveCount % 2 == 0) {
			turn = "red";
			notTurn = "black";
		}
		else {
			turn = "black";
			notTurn = "red";
		}
	}
	
	@Override
	void play(String from, String to) {
		turn();
		int[] pozitionF = new int[2];
		int[] pozitionT = new int[2];
		
		pozitionF = locationTranslator(from);
		pozitionT = locationTranslator(to);
		
		int rowF = pozitionF[0];
		int colF = pozitionF[1];
		int rowT = pozitionT[0];
		int colT = pozitionT[1];
		
		if(rowT <= 9 && rowT >= 0 && colT <= 8 && colT >= 0 && rowF <= 9 && rowF >= 0 && colF <= 8 && colF >= 0) {
			// Tahta sınırları içerisinde mi?
			if (this.getBoard().boardOfPieces[rowF][colF] != null && turn.equals(this.getBoard().boardOfPieces[rowF][colF].color)) {
				// Kendi taşını mı hareket ettirmeye çalışıyor?
				if (this.getBoard().boardOfPieces[rowF][colF].moveable(rowF,colF,rowT,colT,getBoard().boardOfPieces)) {
					// Oraya gidebilir mi?
					if (this.getBoard().boardOfPieces[rowT][colT] != null && this.getBoard().boardOfPieces[rowF][colF].color == this.getBoard().boardOfPieces[rowT][colT].color) {
						// Kendi taşını mı yemeye çalışıyor?
						System.out.println("hatali hareket");
						return;
					}
					
					else {
						//Asıl olay burda başlıyo
						if (check == false) {
							// Şah çekilmediyse
							this.getBoard().makeMoveO(rowF,colF,rowT,colT,to);
							if (this.getBoard().isCheck(notTurn) == true && this.getBoard().face2face()) {
								this.getBoard().revokeMoveO(rowF, colF, rowT, colT, from, to);
								System.out.println("hatali hareket");
								return;
							}
							else {
								this.getBoard().makeMoveS(from,to);
								this.getBoard().boardOfPieces[rowT][colT].pozRow = rowT;
								this.getBoard().boardOfPieces[rowT][colT].pozCol = colT;
								if (this.getBoard().isCheck(turn) == true)
									check = true;
								else
									check = false;
							}
						}
						else {
						// Şah çekildiyse
							this.getBoard().makeMoveO(rowF, colF, rowT, colT, to);
							// Hipotetik hamle
							
							if (this.getBoard().isCheck(turn) == true && this.getBoard().face2face()) {
							// Şah çekildiği halde farklı bir hamle yapmaya çalışıyor ise
								this.getBoard().revokeMoveO(rowF, colF, rowT, colT, from, to);
								System.out.println("hatali hareket");
								return;
							}
							
							else {
							// Şahı korumaya/kaçmaya çalışıyor ise
								this.getBoard().makeMoveS(from,to);
								this.getBoard().boardOfPieces[rowT][colT].pozRow = rowT;
								this.getBoard().boardOfPieces[rowT][colT].pozCol = colT;
								if (this.getBoard().isCheck(notTurn) == true)
									check = true;
								else
									check = false;
							}
						}
					}
				
					setPoints();
			
					if (this.getBoard().isCheck(turn) && this.getBoard().mate(turn, notTurn) == true) {
						Player winner;
						Player loser;
						if (turn.equals("red")) {
							winner = getRed();
							loser = getBlack();
						}
						else {
							winner = getBlack();
							loser = getRed();
						}
						System.out.println("ŞAH MAT! " + winner.name + "  oyunu kazandı."
						+ winner.name + "'in puanı: " + winner.puan  
								+ " ," + loser.name + "'nin puanı: " + loser.puan);
						
						System.exit(0);
					}
					
					moveCount++;
				}
				else {
					System.out.println("hatali hareket");
					return;
				}
						
			}
			else {
				System.out.println("hatali hareket");
				return;
			}
		}
		else {
			System.out.println("hatali hareket");
			return;
		}
	}

	@Override
	void save_text(String address) {
		PrintWriter OS  = null;
		try {
			OS = new PrintWriter(new FileOutputStream(address));
			 
			// Aşama 1, String Tahtayı yazdır
			for (String a : this.getBoard().boardOfAll)
				OS.println(a);
			
			// Aşama 2, bütün taşları item 2d tahtasındaki bilgileriyle beraber yazdır
			for (int i = 0; i < this.getBoard().items.length; i++) {
				OS.println(this.getBoard().items[i].color);
				OS.println(this.getBoard().items[i].pozition);
				OS.println(this.getBoard().items[i].pozRow);
				OS.println(this.getBoard().items[i].pozCol);
			}
			
			// Aşama 3, turn
			OS.println(moveCount);
			
			// Aşama 4, oyuncular
			OS.println(getRed().name);
			OS.println(getRed().puan);
			OS.println(getBlack().name);
			OS.println(getBlack().puan);
			
			OS.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Dosya bulunamadı");
			System.exit(0);
		}
	}

	@Override
	void load_text(String address) {
		Scanner IS = null;
		try {
			IS = new Scanner(new FileInputStream(address));
			
			int count = 0;
			while (count < 21)
				this.getBoard().boardOfAll[count] = IS.nextLine();
			
			for (int i = 0; i < 32; i++) {
				this.getBoard().items[i].color = IS.nextLine();
				this.getBoard().items[i].pozition = IS.nextLine();
				this.getBoard().items[i].pozRow = Integer.parseInt(IS.nextLine());
				this.getBoard().items[i].pozCol = Integer.parseInt(IS.nextLine());
			}
			
			moveCount = Integer.parseInt(IS.nextLine());
			
			getRed().name = IS.nextLine();
			getRed().puan = Float.parseFloat(IS.nextLine());
			getBlack().name = IS.nextLine();
			getBlack().puan = Float.parseFloat(IS.nextLine());
			
			IS.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Dosya bulunamadı veya okunamıyor");
			System.exit(0);
		}
	}

	@Override
	void save_binary(String address) {
		try {
			ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(address));
			
			OOS.writeObject(this.getBoard().boardOfAll);
			OOS.writeObject(this.getBoard().items);
			OOS.writeInt(moveCount);
			OOS.writeObject(getRed());
			OOS.writeObject(getBlack());
			
			OOS.close();
		}
		catch (IOException e) {
			System.out.println("hata");
			System.exit(0);
		}
	}
	
	@Override
	void load_binary(String address) {
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(address));
			
			this.getBoard().boardOfAll = (String[]) OIS.readObject();
			this.getBoard().items = (Item[]) OIS.readObject();
			moveCount = OIS.readInt();
			setRed((Player) OIS.readObject());
			setBlack((Player) OIS.readObject());
			
			OIS.close();
		}
		catch (IOException | ClassNotFoundException e){
			System.out.println("hata");
			System.exit(0);
		}
	}
	
	public int[] locationTranslator(String location) {
		int[] poz = new int[2];
		String temp = location.substring(0,1);
		switch (temp) {
		case "a":
			poz[0] = 9;
			break;
		case "b":
			poz[0] = 8;
			break;
		case "c":
			poz[0] = 7;
			break;
		case "d":
			poz[0] = 6;
			break;
		case "e":
			poz[0] = 5;
			break;
		case "f":
			poz[0] = 4;
			break;
		case "g":
			poz[0] = 3;
			break;
		case "h":
			poz[0] = 2;
			break;
		case "i":
			poz[0] = 1;
			break;
		case "j":
			poz[0] = 0;
			break;
		default:
			System.out.println("hatali hareket");
		}
		
		int temp1 = Integer.parseInt(location.substring(1,2));
		switch (temp1) {
		case 1:
			poz[1] = 0;
			break;
		case 2:
			poz[1] = 1;
			break;
		case 3:
			poz[1] = 2;
			break;
		case 4:
			poz[1] = 3;
			break;
		case 5:
			poz[1] = 4;
			break;
		case 6:
			poz[1] = 5;
			break;
		case 7:
			poz[1] = 6;
			break;
		case 8:
			poz[1] = 7;
			break;
		case 9:
			poz[1] = 8;
			break;
		default:
			System.out.println("hatali hareket");
		}
		return poz;
	}
}