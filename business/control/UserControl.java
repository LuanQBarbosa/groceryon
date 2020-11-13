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
        // TODO
        return null;
    }

    public User getUser(String login) {
        // TODO
        return null;
    }

    /**
     * @param login do usuario
     * @return true se existe usuario com o login, false caso contrario
     */
    public boolean deleteUser(String login) {
        // TODO
        return false;
    }
}