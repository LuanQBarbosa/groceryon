package business.control;

import business.model.Date;
import business.model.User;
import business.model.UserBirthdayComparator;
import infra.UserDao;
import util.IncorrectDateFormatException;
import util.InfraException;
import util.UserLoginException;
import util.UserPasswordException;

import java.util.*;

public class UserControl {
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final Map<String, User> users;

    public UserControl(UserDao userDao, UserValidator userValidator) throws InfraException {
        this.userDao = userDao;
        this.userValidator = userValidator;
        users = userDao.loadUsers();
    }

    public void addUser(String login, String password, Date birthday) throws UserLoginException, UserPasswordException, InfraException, IncorrectDateFormatException {
        if(users.containsKey(login))
            throw new UserLoginException("Login já cadastrado!");

        User user = new User(login, password, birthday);
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

    public SortedSet<User> listUsersByLogin() {
        return new TreeSet<>(users.values());
    }

    public SortedSet<User> listUsersByBirthday() {
        SortedSet<User> usersSet = new TreeSet<>(new UserBirthdayComparator());
        usersSet.addAll(users.values());
        return usersSet;
    }
}
