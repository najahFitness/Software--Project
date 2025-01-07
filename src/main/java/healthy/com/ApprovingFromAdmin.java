package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApprovingFromAdmin {
    private String status;
    private static final String PROGRAMS_FILE = "src/test/resources/programs.txt";
    private static final String INFORMATION_FILE = "src/test/resources/Informations.txt";
    private static final String SIGNUP_FILE = "src/test/resources/Signup.txt";

    public boolean addInstructor(String name, String phoneNumber, String yearsOfExperience, String jobDescription) {

        if (name == null || name.isEmpty() ||
                phoneNumber == null || phoneNumber.isEmpty() ||
                yearsOfExperience == null || yearsOfExperience.isEmpty() ||
                jobDescription == null || jobDescription.isEmpty()) {
            setStatus("unacceptable");
            return false;
        }

        // تخزين البيانات في ملف programs.txt
        List<String> approvingData = new ArrayList<>();
        String approvingDataLine = name + ":" + phoneNumber + ":" + yearsOfExperience + ":" + jobDescription;
        approvingData.add(approvingDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PROGRAMS_FILE, true))) {
            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine();
            }

            // إنشاء Registration Number وكلمة مرور
            String registrationNumber = generateRegistrationNumber();
            String password = generatePassword();

            // تخزين Registration Number وكلمة المرور في ملف Informations.txt
            saveToInformationFile(registrationNumber, password);

            // تخزين البيانات في ملف Signup.txt
            saveToSignupFile(name, "Instructor", phoneNumber);

            setStatus("Accepted");
            return true;
        } catch (IOException e) {
            setStatus("unacceptable");
            e.printStackTrace();
        }

        setStatus("unacceptable");
        return false;
    }

    private String generateRegistrationNumber() {
        Random random = new Random();
        String prefix = "I"; // المدرب يبدأ بحرف I
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

    private void saveToInformationFile(String registrationNumber, String password) throws IOException {
        String dataLine = registrationNumber + ":" + password;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFORMATION_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        }
    }

    private void saveToSignupFile(String name, String role, String phoneNumber) throws IOException {
        String dataLine = name + ":" + role + ":" + phoneNumber;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SIGNUP_FILE, true))) {
            writer.write(dataLine);
            writer.newLine();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
