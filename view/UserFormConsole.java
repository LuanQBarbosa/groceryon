package view;

import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import business.control.UserControl;
import business.model.User;
import util.IncorrectDateFormatException;
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

    private void addUser() {
        boolean added = false;
        do {
            System.out.print("\nLogin (sem números, até 20 caracteres): ");
            String login = this.scanner.nextLine();

            System.out.print("Senha (entre 8 e 12 caracteres): ");
            String password = this.scanner.nextLine();

            System.out.print("Data Nascimento (dd/mm/yyyy): ");
            String birthday = this.scanner.nextLine();

            try {
                this.controller.addUser(login, password, birthday);
                System.out.println("\nUsuário cadastrado com sucesso!\n");
                added = true;
            } catch (UserLoginException | UserPasswordException | InfraException | IncorrectDateFormatException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("\nPressione enter para continuar! ");
            this.scanner.nextLine();
        } while(!added);
    }

    private void listUsers() {
        int option = 0;
        do {
            System.out.println("1 - Ordernado por login - crescente");
            System.out.println("2 - Ordenado por data de nascimento - decrescente");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            String input = this.scanner.nextLine();

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opção invalida!");
            }
        } while(option == 0);

        SortedSet<User> users = null;
        switch (option) {
            case 1 -> users = controller.listUsersByLogin();
            case 2 -> users = controller.listUsersByBirthday();
            default -> throw new IllegalStateException();
        }

        System.out.println();
        for (User u : users) {
            System.out.println(u.getLogin() + " " + u.getBirthday());
        }

        System.out.print("\nPressione enter para continuar!");
        this.scanner.nextLine();
    }

    private void getUser() {
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

    private void deleteUser() {
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

    private void callOption(int opt) {
        switch (opt) {
            case 1:
                addUser();
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
