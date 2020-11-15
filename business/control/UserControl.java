package business.control;

import business.model.User;
import infra.UserDao;
import util.UserLoginException;
import util.UserPasswordException;

import java.util.Map;

public class UserControl {
    private UserDao userDao;
    private UserValidator userValidator;
    private Map<String, User> users;

    public UserControl(UserDao userDao, UserValidator userValidator) {
        this.userDao = userDao;
        this.userValidator = userValidator;
        users = userDao.loadUsers();
    }

    public void addUser(String login, String password) throws UserLoginException, UserPasswordException {
        User user = new User(login, password);
        this.userValidator.validateUser(user);
        users.put(login, user);
        userDao.saveUsers(users);
    }

    public Map<String, User> listAll() {
        return users;
    }

    public User getUser(String login) {
        return users.get(login);
    }

    public void deleteUser(String login) {
        users.remove(login);
    }
}
