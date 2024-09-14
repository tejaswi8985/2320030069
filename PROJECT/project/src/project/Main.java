package project;

import java.util.Scanner;

public class Main {
    private static UserManager userManager = new UserManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Recover Password");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleRegister();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    handlePasswordRecovery();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void handleRegister() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManager.registerUser(username, password)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private static void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManager.loginUser(username, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void handlePasswordRecovery() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        if (userManager.recoverPassword(username, newPassword)) {
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Username not found.");
        }
    }
}
