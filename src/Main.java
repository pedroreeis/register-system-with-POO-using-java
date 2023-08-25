import Controllers.UserController;
import Models.UserModel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar usuário");
            System.out.println("2. Procurar usuário");
            System.out.println("3. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    System.out.println("Digite o id do usuário a ser procurado:");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    searchUser(searchId);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void createUser(Scanner scanner) {
        System.out.println("Digite o primeiro nome:");
        String firstName = scanner.nextLine();

        System.out.println("Digite o último nome:");
        String lastName = scanner.nextLine();

        System.out.println("Digite a idade:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        processUser(firstName, lastName, age, cpf);
    }

    public static void searchUser(int id) {
        UserModel user = new UserController().getUser(id);

        if(user != null) {
            System.out.println("Usuário encontrado com sucesso:");
            System.out.println("Id: " + user.getId());
            System.out.println("Nome: " + user.getFirstname() + " " + user.getLastname());
            System.out.println("Idade: " + user.getAge());
            System.out.println("CPF: " + user.getCpf());
            System.out.println("Às: " + user.getTimestamp());
        }else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void processUser(String firstName, String lastName, int age, String cpf) {

        UserModel user = new UserController().createUser(firstName, lastName, age, cpf);

        System.out.println("Usuário criado com sucesso:");
        System.out.println("Id: " + user.getId());
        System.out.println("Nome: " + user.getFirstname() + " " + user.getLastname());
        System.out.println("Idade: " + user.getAge());
        System.out.println("CPF: " + user.getCpf());
        System.out.println("Às: " + user.getTimestamp());
    }
}