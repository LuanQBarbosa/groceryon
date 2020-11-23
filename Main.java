import business.Facade;
import business.control.ProductControl;
import business.control.UserControl;
import business.control.UserValidator;
import business.model.Date;
import infra.ProductDao;
import infra.ProductFileDao;
import infra.UserDao;
import infra.UserFileDao;
import util.InfraException;
import util.InvalidOptionException;
import util.UserLoginException;
import view.Form;
import view.FormConsole;

public class Main {
    public static void main(String[] args) throws InvalidOptionException, UserLoginException {
        UserDao userDao = new UserFileDao("users.ser");
        UserValidator userValidator = new UserValidator();
        UserControl userController = null;

        ProductDao productDao = new ProductFileDao("products.ser");
        ProductControl productController = null;
        try {
            userController = new UserControl(userDao, userValidator);
            productController = new ProductControl(productDao);
        } catch(InfraException e) {
            System.out.println("Houve um erro ao iniciar a aplicação.");
            System.exit(1);
        }

        Facade facade = new Facade(userController, productController);

        Form form = new FormConsole(facade);

        form.showForm();
    }
}
