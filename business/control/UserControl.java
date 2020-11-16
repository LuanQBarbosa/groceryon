package business.control;

import business.model.User;
import infra.UserDao;
import util.UserLoginException;
import util.UserPasswordException;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class UserControl {
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final Map<String, User> users;

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

    public List<User> listAll() {
        return new ArrayList<User>(users.values());
    }

    public User getUser(String login) {
        return users.get(login);
    }

    public User deleteUser(String login) {
        return users.remove(login);
    }
}
