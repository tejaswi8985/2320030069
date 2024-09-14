package project;
import java.io.*;
import java.util.*;


public class UserManager {
    private String fileName;
    private Map<String, User> users = new HashMap<>();

    public UserManager(String fileName) {
        this.fileName = fileName;
        loadUsers();
    }

    public UserManager() {
        this("users.txt");
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, new User(username, password));
        saveUsers();
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean recoverPassword(String username, String newPassword) {
        User user = users.get(username);
        if (user != null) {
            user.setPassword(newPassword);
            saveUsers();
            return true;
        }
        return false;
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}

