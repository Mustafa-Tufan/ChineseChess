public abstract class AbstractBoard implements BoardInterface{
	
	Item[] items;

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
}