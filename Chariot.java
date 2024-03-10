public class Chariot extends Item {
	
	double points = 9;
	String pozition;
	int pozRow;
	int pozCol;
	
	public Chariot(String color, String pozition, int pozRow, int pozCol) {
		super(color,pozition,pozRow,pozCol);
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if(super.inBorders(rowT, colT)) {
			if (rowF == rowT && colF < colT) {
				for (int i = colF + 1; i <colT; i++) {
					if (boardOfPieces[rowF][i] != null)
						return false;
				}
				return true;
			}
			else if (rowF == rowT && colF > colT) {
				for (int i = colT + 1; i <colF; i++) {
					if (boardOfPieces[rowF][i] != null)
						return false;
				}
				return true;
			}
			else if (colF == colT && rowF < rowT) {
				for (int i = rowF + 1; i <rowT; i++) {
					if (boardOfPieces[i][colF] != null)
						return false;
				}
				return true;
			}
			else if (colF == colT && rowF > rowT) {
				for (int i = rowT + 1; i <rowF; i++) {
					if (boardOfPieces[i][colF] != null)
						return false;
				}
				return true;
			}
			else return false;
		}
		else return false;
	}
}