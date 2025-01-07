package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SinUp_FromAdmin {
    private String status;
    private static final String SIGNUP_FILE = "src/test/resources/Signup.txt";
    private static final String INFORMATION_FILE = "src/test/resources/Informations.txt";

    public boolean isSinUP(String name, String role, String phonenumber) {
        if (isEmpty(name) || isEmpty(role) || isEmpty(phonenumber)) {
            setStatus("Invalid name or phonenumber");
            return false;
        }

        // تخزين البيانات الأساسية في ملف Signup.txt
        saveToSignupFile(name, role, phonenumber);

        // إنشاء رقم تسجيل وكلمة مرور
        String registrationNumber = generateRegistrationNumber(role);
        String password = generatePassword();

        // تخزين رقم التسجيل وكلمة المرور في ملف Informations.txt
        saveToInformationFile(registrationNumber, password);

        if (role.equalsIgnoreCase("Client")) {
            setStatus("Client added successfully");
        } else if (role.equalsIgnoreCase("Instructor")) {
            setStatus("Instructor added successfully");
        }
        return true;
    }

    private void saveToSignupFile(String name, String role, String phonenumber) {
        String dataLine = name + ":" + role + ":" + phonenumber;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SIGNUP_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to Signup file: " + e.getMessage());
        }
    }

    private void saveToInformationFile(String registrationNumber, String password) {
        String dataLine = registrationNumber + ":" + password;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFORMATION_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to Informations file: " + e.getMessage());
        }
    }

    private String generateRegistrationNumber(String role) {
        Random random = new Random();
        String prefix = role.equalsIgnoreCase("Client") ? "C" : "I";
        int randomNumber = 1000 + random.nextInt(9000); // 4 أرقام عشوائية
        return prefix + randomNumber;
    }

    private String generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) { // كلمة مرور مكونة من 8 أحرف
            password.append(chars.charAt(random.nextInt(chars.length())));
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
