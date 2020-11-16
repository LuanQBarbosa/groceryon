package view;

import java.util.List;
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
    }

    @Override
    public void showUserForm() {
        this.scanner = new Scanner(System.in);
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
            
            option = Integer.parseInt(this.scanner.nextLine());
            callOption(option);
        } while (option != 5);

        this.scanner.close();
    }

    public void userAdd() {
        System.out.print("Login: ");
        String login = this.scanner.nextLine();

        System.out.print("Senha (numérica, entre 8 e 12 caracteres): ");
        String password = this.scanner.nextLine();

        try {
            this.controller.addUser(login, password);
        } catch (UserLoginException e) {
            System.out.println("Login inválido");
        } catch (UserPasswordException e) {
            System.out.println("Senha inválida");
        }

        System.out.println("\nUsuário cadastrado com sucesso!\n");
        System.out.print("Pressione qualquer tecla para continuar! ");
        this.scanner.nextLine();
    }

    public void listUsers() {
        List<User> users = controller.listAll();

        System.out.println();
        for (Map.Entry<String, User> entry : users.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("\nPressione qualquer tecla para continuar!");
        this.scanner.nextLine();
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
        }
    }
}
