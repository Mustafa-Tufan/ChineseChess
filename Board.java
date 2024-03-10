import java.io.Serializable;

public class Board extends AbstractBoard implements Serializable{
	
	String[] boardOfAll;
	Item[][] boardOfPieces;
	
	public Board(){
		
	}
	
	public void print(){
		for (String s : this.boardOfAll){
		        System.out.println(s);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void createAndFillBoard(){
		boardOfPieces = new Item[10][9];
		
		General generalR = new General("red", "a5",9,4);
		General generalB = new General("black", "j5",0,4);
		Advisor advisorR1 = new Advisor("red", "a4",9,3);
		Advisor advisorR2 = new Advisor("red", "a6",9,5);
		Advisor advisorB1 = new Advisor("black", "j4",0,3);
		Advisor advisorB2 = new Advisor("black", "j6",0,5);
		Chariot chariotR1 = new Chariot("red", "a1",9,0);
		Chariot chariotR2 = new Chariot("red", "a9",9,8);
		Chariot chariotB1 = new Chariot("black", "j1",0,0);
		Chariot chariotB2 = new Chariot("black", "j9",0,8);
		Cannon cannonR1 = new Cannon("red", "c2",7,1);
		Cannon cannonR2 = new Cannon("red", "c8",7,7);
		Cannon cannonB1 = new Cannon("black", "h2",2,1);
		Cannon cannonB2 = new Cannon("black", "h8",2,7);
		Horse horseR1 = new Horse("red", "a2",9,1);
		Horse horseR2 = new Horse("red", "a8",9,7);
		Horse horseB1 = new Horse("black", "j2",0,1);
		Horse horseB2 = new Horse("black", "j8",0,7);
		Elephant elephantR1 = new Elephant("red", "a3",9,2);
		Elephant elephantR2 = new Elephant("red", "a7",9,6);
		Elephant elephantB1 = new Elephant("black", "j3",0,2);
		Elephant elephantB2 = new Elephant("black", "j7",0,6);
		Soldier soldierR1 = new Soldier("red", "d1",6,0);
		Soldier soldierR2 = new Soldier("red", "d3",6,2);
		Soldier soldierR3 = new Soldier("red", "d5",6,4);
		Soldier soldierR4 = new Soldier("red", "d7",6,6);
		Soldier soldierR5 = new Soldier("red", "d9",6,8);
		Soldier soldierB1 = new Soldier("black", "g1",3,0);
		Soldier soldierB2 = new Soldier("black", "g3",3,2);
		Soldier soldierB3 = new Soldier("black", "g5",3,4);
		Soldier soldierB4 = new Soldier("black", "g7",3,6);
		Soldier soldierB5 = new Soldier("black", "g9",3,8);
		
		this.boardOfPieces[0][0] = chariotB1;
		this.boardOfPieces[0][1] = horseB1;
		this.boardOfPieces[0][2] = elephantB1;
		this.boardOfPieces[0][3] = advisorB1;
		this.boardOfPieces[0][4] = generalB;
		this.boardOfPieces[0][5] = advisorB2;
		this.boardOfPieces[0][6] = elephantB2;
		this.boardOfPieces[0][7] = horseB2;
		this.boardOfPieces[0][8] = chariotB2;
		this.boardOfPieces[2][1] = cannonB1;
		this.boardOfPieces[2][7] = cannonB2;
		this.boardOfPieces[3][0] = soldierB1;
		this.boardOfPieces[3][2] = soldierB2;
		this.boardOfPieces[3][4] = soldierB3;
		this.boardOfPieces[3][6] = soldierB4;
		this.boardOfPieces[3][8] = soldierB5;
		this.boardOfPieces[6][0] = soldierR1;
		this.boardOfPieces[6][2] = soldierR2;
		this.boardOfPieces[6][4] = soldierR3;
		this.boardOfPieces[6][6] = soldierR4;
		this.boardOfPieces[6][8] = soldierR5;
		this.boardOfPieces[7][1] = cannonR1;
		this.boardOfPieces[7][7] = cannonR2;
		this.boardOfPieces[9][0] = chariotR1;
		this.boardOfPieces[9][1] = horseR1;
		this.boardOfPieces[9][2] = elephantR1;
		this.boardOfPieces[9][3] = advisorR1;
		this.boardOfPieces[9][4] = generalR;
		this.boardOfPieces[9][5] = advisorR2;
		this.boardOfPieces[9][6] = elephantR2;
		this.boardOfPieces[9][7] = horseR2;
		this.boardOfPieces[9][8] = chariotR2;
		
		Item[] items = new Item[]{generalR,generalB,
				advisorR1,advisorR2,advisorB1,advisorB2,
				chariotR1,chariotR2,chariotB1,chariotB2,
				cannonR1,cannonR2,cannonB1,cannonB2,
				horseR1,horseR2,horseB1,horseB2,
				elephantR1,elephantR2,elephantB1,elephantB2,
				soldierR1,soldierR2,soldierR3,soldierR4,soldierR5,
				soldierB1,soldierB2,soldierB3,soldierB4,soldierB5};
		setItems(items);
		
		String layer1 = "j\tK--A--F--V--S--V--F--A--K";
		String layer2 = " \t|  |  |  |\\ | /|  |  |  |";
		String layer3 = "i\t-------------------------";
		String layer4 = " \t|  |  |  |/ | \\|  |  |  |";
		String layer5 = "h\t---T-----------------T---";
		String layer6 = " \t|  |  |  |  |  |  |  |  |";
		String layer7 = "g\tE-----E-----E-----E-----E";
		String layer8 = " \t|  |  |  |  |  |  |  |  |";
		String layer9 = "f\t-------------------------";
		String layer10 = " \t|                       |";
		String layer11 = "e\t-------------------------";
		String layer12 = " \t|  |  |  |  |  |  |  |  |";
		String layer13 = "d\te-----e-----e-----e-----e";
		String layer14 = " \t|  |  |  |  |  |  |  |  |";
		String layer15 = "c\t---t-----------------t---";
		String layer16 = " \t|  |  |  |\\ | /|  |  |  |";
		String layer17 = "b\t-------------------------";
		String layer18 = " \t|  |  |  |/ | \\|  |  |  |";
		String layer19 = "a\tk--a--f--v--s--v--f--a--k";
		String layer20 = "                            ";
		String layer21 = " \t1--2--3--4--5--6--7--8--9";
		
		boardOfAll = new String[21];
		
		boardOfAll[0] = layer1;
		boardOfAll[1] = layer2;
		boardOfAll[2] = layer3;
		boardOfAll[3] = layer4;
		boardOfAll[4] = layer5;
		boardOfAll[5] = layer6;
		boardOfAll[6] = layer7;
		boardOfAll[7] = layer8;
		boardOfAll[8] = layer9;
		boardOfAll[9] = layer10;
		boardOfAll[10] = layer11;
		boardOfAll[11] = layer12;
		boardOfAll[12] = layer13;
		boardOfAll[13] = layer14;
		boardOfAll[14] = layer15;
		boardOfAll[15] = layer16;
		boardOfAll[16] = layer17;
		boardOfAll[17] = layer18;
		boardOfAll[18] = layer19;
		boardOfAll[19] = layer20;
		boardOfAll[20] = layer21;
	}
	
	public Item temp;
	
	public void makeMoveO(int rowF, int colF, int rowT, int colT, String to) {
		
		if (this.boardOfPieces[rowT][colT] != null) {
			this.boardOfPieces[rowT][colT].pozition = "xx";
			temp = this.boardOfPieces[rowT][colT];
		}
		else
			temp = null;
		this.boardOfPieces[rowT][colT] = this.boardOfPieces[rowF][colF];
		this.boardOfPieces[rowF][colF] = null;
		this.boardOfPieces[rowT][colT].pozition = to;
		
	}
	
	public void revokeMoveO(int rowF, int colF, int rowT, int colT, String from, String to) {
		if (temp != null) {
			this.boardOfPieces[rowF][colF] = this.boardOfPieces[rowT][colT];
			this.boardOfPieces[rowT][colT] = temp;
			this.boardOfPieces[rowF][colF].pozition = from;
			this.boardOfPieces[rowT][colT].pozition = to;
			temp = null;
		}
		else {
			this.boardOfPieces[rowF][colF] = this.boardOfPieces[rowT][colT];
			this.boardOfPieces[rowT][colT] = null;
			this.boardOfPieces[rowF][colF].pozition = from;
		}
	}
	
	public void makeMoveS(String from, String to) {
		int rowF = 0;
		int colF = 0;
		int rowT = 0;
		int colT = 0;
		String fHarf = from.substring(0,1);
		switch (fHarf) {
		case "a":
			rowF = 18;
			break;
		case "b":
			rowF = 16;
			break;
		case "c":
			rowF = 14;
			break;
		case "d":
			rowF = 12;
			break;
		case "e":
			rowF = 10;
			break;
		case "f":
			rowF = 8;
			break;
		case "g":
			rowF = 6;
			break;
		case "h":
			rowF = 4;
			break;
		case "i":
			rowF = 2;
			break;
		case "j":
			rowF = 0;
			break;
		default:
			System.out.println("hatali hareket");
		}
		
		int fSayi = Integer.parseInt(from.substring(1,2));
		switch (fSayi) {
		case 1:
			colF = 2;
			break;
		case 2:
			colF = 5;
			break;
		case 3:
			colF = 8;
			break;
		case 4:
			colF = 11;
			break;
		case 5:
			colF = 14;
			break;
		case 6:
			colF = 17;
			break;
		case 7:
			colF = 20;
			break;
		case 8:
			colF = 23;
			break;
		case 9:
			colF = 26;
			break;
		default:
			System.out.println("hatali hareket");
		}
		
		String tHarf = to.substring(0,1);
		switch (tHarf) {
		case "a":
			rowT = 18;
			break;
		case "b":
			rowT = 16;
			break;
		case "c":
			rowT = 14;
			break;
		case "d":
			rowT = 12;
			break;
		case "e":
			rowT = 10;
			break;
		case "f":
			rowT = 8;
			break;
		case "g":
			rowT = 6;
			break;
		case "h":
			rowT = 4;
			break;
		case "i":
			rowT = 2;
			break;
		case "j":
			rowT = 0;
			break;
		default:
			System.out.println("hatali hareket");
		}
		
		int tSayi = Integer.parseInt(to.substring(1,2));
		switch (tSayi) {
		case 1:
			colT = 2;
			break;
		case 2:
			colT = 5;
			break;
		case 3:
			colT = 8;
			break;
		case 4:
			colT = 11;
			break;
		case 5:
			colT = 14;
			break;
		case 6:
			colT = 17;
			break;
		case 7:
			colT = 20;
			break;
		case 8:
			colT = 23;
			break;
		case 9:
			colT = 26;
			break;
		default:
			System.out.println("hatali hareket");
		}
		boardOfAll[rowT] = boardOfAll[rowT].substring(0,colT) + boardOfAll[rowF].substring(colF,colF + 1) + boardOfAll[rowT].substring(colT + 1);
		boardOfAll[rowF] = boardOfAll[rowF].substring(0,colF) + "-" + boardOfAll[rowF].substring(colF + 1);
	}
	
	// Sıraya göre çalışan bir tehdit algılama metodu
	// Eğer sıra kimdeyse, o kişinin taşlarının rakip generali tehdit edip etmediğine bakar
	
	public boolean isCheck(String turn) {
		if (turn.equals("red")) {
			for (int i = 0; i<items.length; i++) {
				if (!items[i].pozition.equals("xx") && items[i].color.equals("red")) {
					if (items[i].moveable(items[i].pozRow, items[i].pozCol, items[1].pozRow, items[1].pozCol, boardOfPieces) == true) {
						return true;
					}
				}
			}
			return false;	
		}
		else {
			for (int i = 0; i<items.length; i++) {
				if (!items[i].pozition.equals("xx") && items[i].color.equals("black")) {
					if (items[i].moveable(items[i].pozRow, items[i].pozCol, items[0].pozRow, items[0].pozCol, boardOfPieces) == true)
						return true;
				}
			}
			return false;	
		}
	}
	
	public boolean face2face() {
		int rowRG = items[0].pozRow;
		int colRG = items[0].pozCol;
		int rowBG = items[1].pozRow;
		int colBG = items[1].pozRow;
		if (colRG != colBG)
			return false;
		else {
			for(int i  = 0; i < items.length;  i++) {
				if (!items[i].pozition.equals("xx") && items[i].pozCol == colRG) {
					if (items[i].pozRow < rowRG && items[i].pozRow > rowBG)
						return false;
				}
			}
			return true;
		}
	}
	public Item temporary;
	
	public void makeMoveO(int rowF, int colF, int rowT, int colT) {
		
		if (this.boardOfPieces[rowT][colT] != null)
			temporary = this.boardOfPieces[rowT][colT];
		else
			temporary = null;
		this.boardOfPieces[rowT][colT] = this.boardOfPieces[rowF][colF];
		this.boardOfPieces[rowF][colF] = null;
	}
	
	public void revokeMoveO(int rowF, int colF, int rowT, int colT) {
		if (temporary != null) {
			this.boardOfPieces[rowF][colF] = this.boardOfPieces[rowT][colT];
			this.boardOfPieces[rowT][colT] = temporary;
			temporary = null;
		}
		else {
			this.boardOfPieces[rowF][colF] = this.boardOfPieces[rowT][colT];
			this.boardOfPieces[rowT][colT] = null;
		}
	}
	// O kişinin mat edip etmediğine bakars
	// Rakibin saldırı altında olduğunu varsayacağız
	public boolean mate(String turn, String notTurn) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].color.equals(notTurn) && ! items[i].pozition.equals("xx")) {
				for (int m = 0; m < 10; m++) {
					for (int n = 0; n < 9; n++) {
						if (items[i].moveable(items[i].pozRow, items[i].pozCol, m, n, boardOfPieces)) {
							if (!(boardOfPieces[m][n] != null && items[i].color.equals(boardOfPieces[m][n].color))) {
								makeMoveO(items[i].pozRow, items[i].pozCol, m, n);
								if (isCheck(turn) == false) {
									revokeMoveO(items[i].pozRow, items[i].pozCol, m, n);
									return false;
								}
								else {
									revokeMoveO(items[i].pozRow, items[i].pozCol, m, n);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public float calculatePoints(String renk) {
		int totalPoints = 0;
		for(int i = 0; i < items.length; i++) {
			if (items[i].pozition.equals("xx") && items[i].color.equals(renk))
				totalPoints += items[i].points;
		}
		return totalPoints;
	}
}