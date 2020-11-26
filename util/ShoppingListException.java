package util;

public class ShoppingListException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public ShoppingListException(String msg) {
        super(msg);
    }

    public ShoppingListException(String msg, Throwable cause){
        super(msg, cause);
    }
}
