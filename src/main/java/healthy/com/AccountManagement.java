package healthy.com;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {
    private ConsoleDisplay console;
    private Map<String, String> profileData = new HashMap<>();

    public AccountManagement(ConsoleDisplay console) {
        this.console = console;
        loadProfileData();
    }

    public void customizeProfile(String field, String value) {
        console.displayMessage("Customizing " + field + "...");
        profileData.put(field, value);
        saveProfileData();
        console.displayMessage(field + " set to: " + value);
    }

    public void viewProfileData() {
        console.displayMessage("Profile Data:");
        if (profileData.isEmpty()) {
            console.displayMessage("No data available.");
        } else {
            profileData.forEach((field, value) -> console.displayMessage(field + ": " + value));
        }
    }

    public void clearProfileData() {
        console.displayMessage("Clearing all profile data...");
        profileData.clear();
        saveProfileData();
        console.displayMessage("Profile data cleared successfully.");
    }

    private void loadProfileData() {
        try (Scanner fileScanner = new Scanner(new File("profile_data.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(": ");
                if (parts.length == 2) {
                    profileData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            console.displayMessage("Error loading profile data: " + e.getMessage());
        }
    }

    private void saveProfileData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("profile_data.txt"))) {
            profileData.forEach((field, value) -> writer.println(field + ": " + value));
        } catch (IOException e) {
            console.displayMessage("Error saving profile data: " + e.getMessage());
        }
    }
}