package util;

public class InfraException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public InfraException(String msg) {
        super(msg);
    }

    public InfraException(String msg, Throwable cause){
        super(msg, cause);
    }
}
