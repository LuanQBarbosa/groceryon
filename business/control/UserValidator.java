package business.control;

import business.model.User;
import util.UserLoginException;
import util.UserPasswordException;

public class UserValidator {

    public void validateUser(User user) throws UserLoginException, UserPasswordException {
        this.validateLogin(user.getLogin());
        this.validatePassword(user.getPassword());
    }

    public void validateLogin(String login) throws UserLoginException {
        if (login.length() > 20)
            throw new UserLoginException("Login deve ter no maximo 20 caracteres!");

        if (login.isBlank())
            throw new UserLoginException("Login não pode ser vazio!");

        if (login.matches(".*\\d.*"))
            throw new UserLoginException("Login não pode ter números!");
    }

    public void validatePassword(String password) throws UserPasswordException {
        if (password.length() > 12)
            throw new UserPasswordException("Senha deve ter no maximo 12 caracteres!");

        if (password.length() < 8)
            throw new UserPasswordException("Senha deve ter no minimo 8 caracteres!");

        if(!password.matches(".*[a-zA-Z]+.*"))
            throw new UserPasswordException("Senha deve conter ao menos 1 letra!");

        if(!password.matches("(\\D*\\d){2,}"))
            throw new UserPasswordException("Senha deve conter ao menos 2 numeros!");
    }
}
