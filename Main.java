import business.control.UserControl;
import business.control.UserValidator;
import infra.UserDao;
import infra.UserFileDao;
import util.InfraException;
import view.UserForm;
import view.UserFormConsole;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserFileDao("users.ser");
        UserValidator userValidator = new UserValidator();
        UserControl controller = null;
        try {
            controller = new UserControl(userDao, userValidator);
        } catch(InfraException e) {
            System.out.println("Houve um erro ao iniciar a aplicação.");
        }
        UserForm userForm = new UserFormConsole(controller);

        userForm.showUserForm();
    }
}
