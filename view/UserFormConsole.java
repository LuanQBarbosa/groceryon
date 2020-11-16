package view;

import java.util.List;
import java.util.Scanner;

import business.control.UserControl;
import business.model.User;
import util.InfraException;
import util.UserLoginException;
import util.UserPasswordException;

public class UserFormConsole implements UserForm {
    private final UserControl controller;
    private Scanner scanner;

    public UserFormConsole(UserControl controller) {
        this.controller = controller;
    }

    @Override
    public void showUserForm() {
        this.scanner = new Scanner(System.in);
        String input;
        int option;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();  
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("5 - Encerrar operações");
            System.out.println();
            
            System.out.print("Digite a opção desejada: ");
            input = this.scanner.nextLine();

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                option = 0;
            }
            
            callOption(option);
        } while (option != 5);

        this.scanner.close();
    }

    public void userAdd() {
        System.out.print("\nLogin (sem números, até 20 caracteres): ");
        String login = this.scanner.nextLine();

        System.out.print("Senha (numérica, entre 8 e 12 caracteres): ");
        String password = this.scanner.nextLine();

        try {
            this.controller.addUser(login, password);
            System.out.println("\nUsuário cadastrado com sucesso!\n");
            
        } catch (UserLoginException e) {
            System.out.println(e.getMessage());
        } catch (UserPasswordException e) {
            System.out.println(e.getMessage());
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nPressione enter para retornar ao menu principal! ");
        this.scanner.nextLine();
    }

    public void listUsers() {
        List<User> users = controller.listAll();

        System.out.println();
        for (User user : users) {
            System.out.println(user.getLogin());
        }

        System.out.print("\nPressione enter para continuar!");
        this.scanner.nextLine();
    }

    public void getUser() {
        System.out.print("\nLogin: ");
        User user = controller.getUser(this.scanner.nextLine());

        if (user != null) {
            System.out.println("\nUsuário encontrado!\n");
            System.out.println("-> " + user.getLogin());
        } else {
            System.out.println("\nNão há nenhum usuário no sistema com este login.");
        }

        System.out.print("\nPressione enter para continuar!");
        this.scanner.nextLine();
    }

    public void deleteUser() {
        System.out.print("\nLogin: ");

        User user = null;
        try {
            user = controller.deleteUser(this.scanner.nextLine());
        } catch (InfraException e) {
            System.out.println(e.getMessage());
        }

        if (user != null) {
            System.out.println("\nUsuário " + user.getLogin() + " deletado com sucesso.");
        } else {
            System.out.println("\nNão há nenhum usuário cadastrado com este login no sistema.");
        }

        System.out.print("\nPressione enter para continuar!");
        this.scanner.nextLine();
    }

    public void callOption(int opt) {
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
            
            case 5:
                break;
            
            default:
                System.out.println("\nOpção inválida");
                System.out.print("Pressione enter para continuar!");
                this.scanner.nextLine();
                break;
        }
    }
}
