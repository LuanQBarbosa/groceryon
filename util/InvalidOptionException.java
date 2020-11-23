package util;

public class InvalidOptionException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public InvalidOptionException(String msg) {
        super(msg);
    }

    public InvalidOptionException(String msg, Throwable cause){
        super(msg, cause);
    }
}
