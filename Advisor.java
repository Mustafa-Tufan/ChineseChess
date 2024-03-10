/* Mustafa Tufan
 * Vezir sınıfı
 * 
 * Vezir yalnızca sarayın içinde çapraz hareket eder
 * Diğer durumlar hatalıdır
 */
public class Advisor extends Item{
	
	double points = 2;
	String pozition;
	int pozRow;
	int pozCol;
	
	public Advisor(String color, String pozition, int pozRow, int pozCol){
		super(color,pozition,pozRow,pozCol);
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if (super.inPalace(color, rowT, colT)) {
			if (colF == colT + 1 && rowF == rowT + 1)
				return true;
			else if (colF == colT - 1 && rowF == rowT + 1)
				return true;
			else if (colF == colT + 1 && rowF == rowT - 1)
				return true;
			else if (colF == colT - 1 && rowF == rowT - 1)
				return true;
			else return false;
		}
		else return false;
	}
}
