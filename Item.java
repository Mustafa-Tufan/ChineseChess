import java.io.Serializable;

public class Item extends AbstractItem implements Serializable{
	
	String color;
	String pozition = "";
	int pozRow;
	int pozCol;
	double points;
	
	public Item(String color, String pozition, int pozRow, int pozCol) {
		this.color = color;
		this.pozition = pozition;
		this.pozRow = pozRow;
		this.pozCol = pozCol;
	}	
	
	public boolean moveable(int rowF, int colF, int rowT, int colT, Item[][] boardOfPieces) {
		return true;
	}
	
	public boolean inBorders(int rowT, int colT) {
		if (rowT <= 9 && rowT >= 0 && colT <= 8 && colT >= 0)
			return true;
		return false;
	}
	
	public boolean inPalace(String color, int rowT, int colT) {
		this.color = color;
		if (color.equals("red"))
			if (rowT >= 6 && rowT <= 8 && colT >= 3 && colT <= 5)
				return true;
			else return false;
		else
			if (rowT >= 0 && rowT <= 2 && colT >= 3 && colT <= 5)
				return true;
			else return false;
	}
}