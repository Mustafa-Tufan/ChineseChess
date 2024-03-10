public class Elephant extends Item {
	
	double points = 2;
	String pozition;
	int pozRow;
	int pozCol;
	
	public Elephant(String color, String pozition, int pozRow, int pozCol){
		super(color,pozition,pozRow,pozCol);
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if (super.inBorders(rowT, colT)) {
			if (boardOfPieces[rowF][colF].color.equals("red")) {
				if (rowT >= 5) {
					if (rowF == rowT + 2 && colF == colF + 2) {
						if (boardOfPieces[rowF + 1][colF + 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT + 2 && colF == colF - 2) {
						if (boardOfPieces[rowF + 1][colF - 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT - 2 && colF == colF - 2) {
						if (boardOfPieces[rowF - 1][colF - 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT - 2 && colF == colF + 2) {
						if (boardOfPieces[rowF - 1][colF + 1] == null)
							return true;
						else return false;
					}
					else return false;
				}
				else return false;
			}
			else {
				if (rowT <= 4) {
					if (rowF == rowT + 2 && colF == colF + 2) {
						if (boardOfPieces[rowF + 1][colF + 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT + 2 && colF == colF - 2) {
						if (boardOfPieces[rowF + 1][colF - 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT - 2 && colF == colF - 2) {
						if (boardOfPieces[rowF - 1][colF - 1] == null)
							return true;
						else return false;
					}
					else if (rowF == rowT - 2 && colF == colF + 2) {
						if (boardOfPieces[rowF - 1][colF + 1] == null)
							return true;
						else return false;
					}
					else return false;
				}
				else return false;
			}
		}
		else return false;
	}
}
