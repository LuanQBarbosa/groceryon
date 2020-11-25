package util;

public class IncorrectDateFormatException extends Exception {

    private static final long serialVersionUID = 1L;

    public IncorrectDateFormatException(String msg) {
        super(msg);
    }

    public IncorrectDateFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
