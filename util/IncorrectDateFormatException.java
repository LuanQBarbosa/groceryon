package util;

public class IncorrectDateFormatException extends Exception {
    public IncorrectDateFormatException(String msg) {
        super(msg);
    }

    public IncorrectDateFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
