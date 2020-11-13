import business.control.UserControl;
import business.control.UserValidator;
import infra.UserDao;
import infra.UserFileDao;
import view.UserForm;
import view.UserFormConsole;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserFileDao("users.ser");
        UserValidator userValidator = new UserValidator();
        UserControl controller = new UserControl(userDao, userValidator);
        UserForm userForm = new UserFormConsole(controller);

        userForm.showUserForm();

        // Persistency tests
        // try {
        //     controller.addUser("testdois@test.com", "test3123456");

        //     for (String keys : controller.users.keySet()) {
        //         System.out.println(keys);
        //     }
        // } catch(Exception e) {
        //     e.printStackTrace();
        //     System.out.println(e.getLocalizedMessage());
        // }
    }
}
