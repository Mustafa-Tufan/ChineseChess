public class Soldier extends Item{
	
	double points = 1;
	String pozition;
	boolean buffed;
	int pozRow;
	int pozCol;
	
	public Soldier(String color, String pozition, int pozRow, int pozCol){
		super(color,pozition,pozRow,pozCol);
		buffed = false;
	}
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		if (super.inBorders(rowT, colT))
			if (buffed == false) {
				if (rowF == 5 && rowT == 4 && boardOfPieces[rowF][colF].color.equals("red")) {
					buffed = true;
					return true;
				}
				else if (rowF == 4 && rowT == 5 && boardOfPieces[rowF][colF].color.equals("black")) {
					buffed = true;
					return true;
				}
				else if(color.equals("red") && rowT == rowF - 1)
					return true;
				else if(color.equals("black") && rowT == rowF + 1)
					return true;
				else
					return false;
			}
			else {
				if (color.equals("red"))
					if(rowT == rowF - 1 || colT == colF - 1 || colT == colF + 1)
						return true;
					else return false;
				else 
					if(rowT == rowF + 1 || colT == colF - 1 || colT == colF + 1)
						return true;
					else return false;
			}
		return false;
	}
}
