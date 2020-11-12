import business.control.UserControl;
import infra.UserDao;
import infra.UserFileDao;
import view.UserForm;
import view.UserFormConsole;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserFileDao();
        UserControl controller = new UserControl(userDao);
        UserForm userForm = new UserFormConsole(controller);

        userForm.showUserForm();
    }
}
