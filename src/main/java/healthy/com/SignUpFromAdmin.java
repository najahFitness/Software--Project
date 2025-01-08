package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SignUpFromAdmin { // Updated class name to match the test file and conventions
    private String status;
    private static final String SIGNUP_FILE = "src/test/resources/Signup.txt";
    private static final String INFORMATION_FILE = "src/test/resources/Informations.txt";

    // Shared Random instance
    private static final Random RANDOM_GENERATOR = new Random();

    public boolean isSinUP(String name, String role, String phonenumber) {
        if (isEmpty(name) || isEmpty(role) || isEmpty(phonenumber)) {
            setStatus("Invalid name or phonenumber");
            return false;
        }

        saveToSignupFile(name, role, phonenumber);

        String registrationNumber = generateRegistrationNumber(role);
        String password = generatePassword();

        saveToInformationFile(registrationNumber, password);

        if (role.equalsIgnoreCase("Client")) {
            setStatus("Client added successfully");
        } else if (role.equalsIgnoreCase("Instructor")) {
            setStatus("Instructor added successfully");
        } else {
            setStatus("Unknown role");
            return false;
        }

        return true;
    }

    private void saveToSignupFile(String name, String role, String phonenumber) {
        String dataLine = name + ":" + role + ":" + phonenumber;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SIGNUP_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            setStatus("Error saving to Signup file");
        }
    }

    private void saveToInformationFile(String registrationNumber, String password) {
        String dataLine = registrationNumber + ":" + password;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFORMATION_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            setStatus("Error saving to Informations file");
        }
    }

    private String generateRegistrationNumber(String role) {
        String prefix = role.equalsIgnoreCase("Client") ? "C" : "I";
        int randomNumber = 1000 + RANDOM_GENERATOR.nextInt(9000);
        return prefix + randomNumber;
    }

    private String generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            password.append(chars.charAt(RANDOM_GENERATOR.nextInt(chars.length())));
        }
        return password.toString();
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
