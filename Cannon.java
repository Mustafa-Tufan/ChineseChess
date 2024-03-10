public class Cannon extends Item{
	
	double points = 4.5;
	String pozition;
	int pozRow;
	int pozCol;
	
	public Cannon(String color, String pozition, int pozRow, int pozCol) {
		super(color,pozition,pozRow,pozCol);
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if(super.inBorders(rowT, colT)) {
			if (rowF == rowT && colF < colT) {
				int count = 0;
				for (int i = colF + 1; i <colT; i++) {
					if (boardOfPieces[rowF][i] != null)
						count++;
				}
				if (count == 1)
					return true;
				else if (count == 0)
					if (boardOfPieces[rowT][colT] == null)
						return true;
					else return false;
				else return false;
			}
			else if (rowF == rowT && colF > colT) {
				int count = 1;
				for (int i = colT + 1; i <colF; i++) {
					if (boardOfPieces[rowF][i] != null)
						return false;
				}
				if (count == 1)
					return true;
				else if (count == 0)
					if (boardOfPieces[rowT][colT] == null)
						return true;
					else return false;
				else return false;
			}
			else if (colF == colT && rowF < rowT) {
				int count = 1;
				for (int i = rowF + 1; i <rowT; i++) {
					if (boardOfPieces[i][colF] != null)
						return false;
				}
				if (count <= 1)
					return true;
				else return false;
			}
			else if (colF == colT && rowF > rowT) {
				int count = 1;
				for (int i = rowT + 1; i <rowF; i++) {
					if (boardOfPieces[i][colF] != null)
						return false;
				}
				if (count <= 1)
					return true;
				else return false;
			}
			else return false;
		}
		else return false;
	}
}
