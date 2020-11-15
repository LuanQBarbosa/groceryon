package view;

import java.util.Map;
import java.util.Scanner;

import business.control.UserControl;
import business.model.User;
import util.UserLoginException;
import util.UserPasswordException;

public class UserFormConsole implements UserForm {
    private UserControl controller;
    private Scanner scanner;

    public UserFormConsole(UserControl controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showUserForm() {
        System.out.println("1 - Adicionar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Buscar usuário");
        System.out.println("4 - Deletar usuário");
        System.out.println("5 - Encerrar operações");
        System.out.println();

        getOption();
    }

    public void userAdd() {
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Senha: ");
        String password = scanner.nextLine();

        try {
            this.controller.addUser(login, password);
        } catch (UserLoginException e) {
            System.out.println("Login inválido");
        } catch (UserPasswordException e) {
            System.out.println("Senha inválida");
        }
    }

    public void listUsers() {
        Map<String, User> users = controller.listAll();

        for (Map.Entry<String, User> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void getUser() {
        System.out.print("Login: ");
        User user = controller.getUser(this.scanner.nextLine());

        if (user != null) {
            System.out.println("Usuário encontrado.");
            return;
        }

        System.out.println("Não há nenhum usuário no sistema com este login.");
    }

    public void deleteUser() {
        System.out.print("Login: ");
        User user = controller.deleteUser(this.scanner.nextLine());

        if (user != null) {
            System.out.println("Usuário deletado com sucesso.");
            return;
        }

        System.out.println("Não foi possível deletar o usuário.");
    }

    public void getOption() {
        System.out.print("Digite sua opção: ");
        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                userAdd();
                break;

            case 2:
                listUsers();
                break;

            case 3:
                getUser();
                break;

            case 4:
                deleteUser();
                break;
        }
    }
}
