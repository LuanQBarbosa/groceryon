package business.control;

import business.model.User;
import infra.UserDao;

import java.util.Map;
import java.util.TreeMap;

public class UserControl {
    private UserDao userDao;
    private Map<String, User> users;

    public UserControl(UserDao userDao) {
        this.userDao = userDao;
        users = new TreeMap<String, User>();
    }

    public void addUser(String login, String password) {
        // TODO
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