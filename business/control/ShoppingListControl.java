package business.control;

import business.model.Product;
import business.model.ShoppingList;
import business.model.User;
import util.ShoppingListException;

public class ShoppingListControl {

    public void addProduct(User user, Product product) {
        user.getShoppingList().addProduct(product);
    }

    public void removeProduct(User user, Product product) {
        user.getShoppingList().removeProduct(product);
    }

    public void addShoppingListToUser(ShoppingList shoppingList, User user) throws ShoppingListException {
        if(user.getShoppingList() != null) {
            throw new ShoppingListException("This user alredy has a shopping list");
        }
        user.setShoppingList(shoppingList);
    }

    public void removeShoppingListFromUser(User user) {
        user.setShoppingList(null);
    }
  
}
