package business.control;

import business.model.User;
import util.UserLoginException;
import util.UserPasswordException;

public class UserValidator {
    public UserValidator(){}

    public void validateUser(User user) throws UserLoginException, UserPasswordException {
        this.LoginValidation(user.getLogin());
        this.PasswordValidation(user.getPassword());
    }

    public void LoginValidation(String login) throws UserLoginException {
        if (login.length() == 0 | login.length() > 20 | login.matches(".*\\d.*")) throw new UserLoginException("\n**Invalid login**");
    }

    public void PasswordValidation(String password) throws UserPasswordException {
        if (password.length() < 8 | password.length() > 12 |  !password.matches("(\\D*\\d){2,}")) throw new UserPasswordException("\n**Invalid password**");
    }
}
