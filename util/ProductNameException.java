package util;

public class ProductNameException extends Exception {

    private static final long serialVersionUID = 5661012298960005779L;

    public ProductNameException(String msg) {
        super(msg);
    }

    public ProductNameException(String msg, Throwable cause){
        super(msg, cause);
    }
}
