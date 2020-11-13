package util;

public class UserPasswordException extends Exception {

    private static final long serialVersionUID = 7593392345965670097L;
    
    public UserPasswordException(String msg) {
        super(msg);
    }

    public UserPasswordException(String msg, Throwable cause){
        super(msg, cause);
    }
}
