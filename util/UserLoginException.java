package util;

public class UserLoginException extends Exception {

    private static final long serialVersionUID = 5661012298960005779L;

    public UserLoginException(String msg) {
        super(msg);
    }

    public UserLoginException(String msg, Throwable cause){
        super(msg, cause);
    }
}
