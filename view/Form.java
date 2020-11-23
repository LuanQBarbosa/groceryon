package view;

import util.InvalidOptionException;
import util.UserLoginException;

public interface Form {
    void showForm() throws InvalidOptionException, UserLoginException;
}
