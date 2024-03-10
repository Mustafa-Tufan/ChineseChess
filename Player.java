import java.io.Serializable;

public class Player implements Serializable{
	
	float puan; // her taş yedikçe oyuncunun puanı taşın puanına göre artar.
	public String name;
	
	public Player(String name){
		this.name = name;
	}
}
