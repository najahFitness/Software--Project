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


    private static final Random RANDOM_GENERATOR = new Random();

    public boolean addInstructor(String name, String phoneNumber, String yearsOfExperience, String jobDescription) {
        if (isNullOrEmpty(name) || isNullOrEmpty(phoneNumber) ||
                isNullOrEmpty(yearsOfExperience) || isNullOrEmpty(jobDescription)) {
            setStatus("unacceptable");
            return false;
        }

        List<String> approvingData = new ArrayList<>();
        String approvingDataLine = name + ":" + phoneNumber + ":" + yearsOfExperience + ":" + jobDescription;
        approvingData.add(approvingDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PROGRAMS_FILE, true))) {
            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine();
            }

            String registrationNumber = generateRegistrationNumber();
            String password = generatePassword();

            saveToInformationFile(registrationNumber, password);
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
        String prefix = "I";
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

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
