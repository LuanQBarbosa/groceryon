import business.Facade;
import util.InvalidOptionException;
import util.UserLoginException;
import view.Form;
import view.FormConsole;

public class Main {
    public static void main(String[] args) throws InvalidOptionException, UserLoginException {
        Facade facade = Facade.getInstance();

        Form form = new FormConsole(facade);

        form.showForm();
    }
}
