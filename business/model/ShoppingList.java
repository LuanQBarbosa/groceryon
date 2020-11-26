package business.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ShoppingList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Composition relation between ShoppingList and Product entities
	private List<Product> shoppingList;
	private int listID;
	private User owner;

	public ShoppingList(User owner) {
		this.listID = generateID();
		this.shoppingList = new LinkedList<Product>();
		this.owner = owner;
	}

	private int generateID() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}

	public void addProduct(Product product) {
		shoppingList.add(product);
	}

	public void removeProduct(Product product) {
		shoppingList.remove(product);
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Product> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(List<Product> shoppingList) {
		this.shoppingList = shoppingList;
	}

	public int getListID() {
		return listID;
	}

}
