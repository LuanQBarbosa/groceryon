package business.control;

import business.model.User;
import infra.UserDao;
import util.InfraException;
import util.UserLoginException;
import util.UserPasswordException;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class UserControl {
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final Map<String, User> users;

    public UserControl(UserDao userDao, UserValidator userValidator) throws InfraException {
        this.userDao = userDao;
        this.userValidator = userValidator;
        users = userDao.loadUsers();
    }

    public void addUser(String login, String password) throws UserLoginException, UserPasswordException, InfraException {
        User user = new User(login, password);
        this.userValidator.validateUser(user);
        users.put(login, user);
        userDao.saveUsers(users);
    }

    public List<User> listAll() {
        return new ArrayList<>(users.values());
    }

    public User getUser(String login) {
        return users.get(login);
    }

    public User deleteUser(String login) throws InfraException {
        User user = users.remove(login);
        if (user != null) { // evita chamada pesada, se users nao foi modificado
            userDao.saveUsers(users);
        }
        return user;
    }
}
