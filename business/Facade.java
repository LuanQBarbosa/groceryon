package business;

import java.util.SortedSet;

import business.control.ProductControl;
import business.control.ShoppingListControl;
import business.control.UserControl;
import business.control.UserValidator;
import business.model.Date;
import business.model.Product;
import business.model.User;
import infra.ProductDao;
import infra.ProductFileDao;
import infra.UserDao;
import infra.UserFileDao;
import util.IncorrectDateFormatException;
import util.InfraException;
import util.InvalidOptionException;
import util.ProductNameException;
import util.UserLoginException;
import util.UserPasswordException;

// ** Facade Design Pattern implementation **
public class Facade {
    private UserControl userController;
    private ProductControl productController;
    private ShoppingListControl shoppingListController;
    private static Facade instance = null;

    private Facade() {
        UserDao userDao = new UserFileDao("users.ser");
        UserValidator userValidator = new UserValidator();
        UserControl userController = null;

        ProductDao productDao = new ProductFileDao("products.ser");
        ProductControl productController = null;
        try {
            userController = new UserControl(userDao, userValidator);
            productController = new ProductControl(productDao);
            shoppingListController = new ShoppingListControl();
        } catch(InfraException e) {
            System.out.println("Houve um erro ao iniciar a aplicação.");
            System.exit(1);
        }

        this.userController = userController;
        this.productController = productController;
    }

    // ** Singleton Design Pattern implementation **
    public static Facade getInstance() {
        if(instance == null) {
            instance = new Facade();
        }

        return instance;
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

    public void createNewProduct(String name, String description, String imgLink) throws ProductNameException, InfraException {
        productController.addProduct(name, description, imgLink);
    }

    public void updateExistingProduct(String name, String description, String imgLink) {
        Product product = productController.getProduct(name);
        product.setDescription(description);
        product.setImgLink(imgLink);
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
