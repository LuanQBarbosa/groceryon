package business;

import java.util.SortedSet;
import java.util.TreeSet;

import business.control.ProductControl;
import business.control.UserControl;
import business.model.Date;
import business.model.User;
import util.IncorrectDateFormatException;
import util.InfraException;
import util.InvalidOptionException;
import util.UserLoginException;
import util.UserPasswordException;

public class Facade {
    private UserControl userController;
    private ProductControl productController;

    public Facade(UserControl userController, ProductControl producController) {
        this.userController = userController;
        this.productController = producController;
    }

    public void userSignUp(String login, String password, String birthday) throws IncorrectDateFormatException, UserLoginException, UserPasswordException, InfraException {
        Date birthdayDate = Date.fromString(birthday);

        userController.addUser(login, password, birthdayDate);
    }

    public User userLogin(String login, String password) throws UserLoginException {
        User user = userController.getUser(login);
        if(user == null) {
            throw new UserLoginException("User with informed login does not exist");
        } else if(!user.getPassword().equals(password)) {
            throw new UserLoginException("Password does not match");
        }

        return user;
    }

    public SortedSet<User> listUsersBy(String option) throws InvalidOptionException {
        SortedSet<User> users = null;
        if(option.equals("login")) {
            users = userController.listUsersByLogin();
        } else if(option.equals("birthday")) {
            users = userController.listUsersByBirthday();
        } else {
            throw new InvalidOptionException("Valid options: login or birthday");
        }

        return users;
    }

    public User deleteUser(String login) throws InfraException {
        return userController.deleteUser(login);
    }
}
