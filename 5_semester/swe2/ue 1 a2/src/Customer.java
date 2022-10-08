import java.util.ArrayList;

public class Customer {
	ArrayList<Notebook> order = new ArrayList<>();
	
	public Customer() {}
	
	public void addNotebook(Notebook notebook) {
		order.add(notebook);
	}
	
	public void removeNotebook(Notebook notebook) {
		order.remove(notebook);
	}

	public ArrayList<Notebook> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Notebook> order) {
		this.order = order;
	}
}
