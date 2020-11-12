package view;

import business.control.UserControl;

public class UserFormConsole implements UserForm {
    private UserControl controller;

    public UserFormConsole(UserControl controller) {
        this.controller = controller;
    }

    @Override
    public void showUserForm() {
        while (true) {
            // TODO MOSTRA OPCOES;
            break;
        }
    }
}
