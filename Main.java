import business.control.UserControl;
import business.control.UserValidator;
import infra.UserDao;
import infra.UserFileDao;
import view.UserForm;
import view.UserFormConsole;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserFileDao();
        UserValidator userValidator = new UserValidator();
        UserControl controller = new UserControl(userDao, userValidator);
        UserForm userForm = new UserFormConsole(controller);

        userForm.showUserForm();
    }
}
