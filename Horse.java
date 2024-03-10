public class Horse extends Item{
	
	double points = 4;
	String pozition;
	int pozRow;
	int pozCol;
	
	public Horse(String color, String pozition, int pozRow, int pozCol) {
		super(color,pozition,pozRow,pozCol);
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if (super.inBorders(rowT, colT)) {
			if (rowF == rowT - 2 && colF == colT - 1) {
				if(rowF - 1 >= 0 && boardOfPieces[rowF - 1][colF] == null)
					return true;
				else return false; 
			}
			else if (rowF == rowT - 2 && colF == colT + 1) {
				if(rowF - 1 >= 0 && boardOfPieces[rowF - 1][colF] == null)
					return true;
				else return false; 
			}
			else if(rowF == rowT + 2 && colF == colT - 1) {
				if(rowF + 1 <= 9 && boardOfPieces[rowF + 1][colF] == null)
					return true;
				else return false; 
			}
			else if(rowF == rowT + 2 && colF == colT + 1) {
				if(rowF + 1 <= 9 && boardOfPieces[rowF + 1][colF] == null)
					return true;
				else return false; 
			}
			else if(colF == colT - 2 && colF == colT - 1) {
				if(colF - 1 >= 0 && boardOfPieces[rowF][colF - 1] == null)
					return true;
				else return false; 
			}
			else if(colF == colT - 2 && colF == colT + 1) {
				if(colF - 1 >= 0 && boardOfPieces[rowF][colF - 1] == null)
					return true;
				else return false; 
			}
			else if(colF == colT + 2 && colF == colT - 1) {
				if(colF - 1 <= 8 && boardOfPieces[rowF][colF + 1] == null)
					return true;
				else return false; 
			}
			else if(colF == colT + 2 && colF == colT + 1) {
				if(colF - 1 <= 8 && boardOfPieces[rowF][colF - 1] == null)
					return true;
				else return false; 
			}
			else return false;
		}
		else return false;
	}
}