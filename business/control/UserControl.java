package business.control;

import business.model.User;
import infra.UserDao;

import java.util.Map;
import java.util.TreeMap;

public class UserControl {
    private UserDao userDao;
    private UserValidator userValidator;
    private Map<String, User> users;

    public UserControl(UserDao userDao, UserValidator userValidator) {
        this.userDao = userDao;
        this.userValidator = userValidator;
        users = new TreeMap<String, User>();
    }

    public void addUser(String login, String password) throws Exception {  
        try {
            User user = new User(login, password);
            this.userValidator.ValidateUser(user);
            users.put(login, user);
        } catch (Exception e) {
            throw e;
        }
        
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