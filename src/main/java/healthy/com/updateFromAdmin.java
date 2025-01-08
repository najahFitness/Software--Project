package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class updateFromAdmin {

    private static final String STATUS_UPDATE_FAILED = "Update failed";
    private static final String STATUS_UPDATE_SUCCESS = "Update successful";
    private static final String USER_NOT_FOUND = "This user not found";
    private static final String INFORMATION_FILE = "src/test/resources/Informations.txt";
    private static final String SIGNUP_FILE = "src/test/resources/Signup.txt";

    private String status;

    public boolean updating(String reg, String name, String password, String phonenumber, String role) {
        if (isEmpty(reg)) {
            setStatus(STATUS_UPDATE_FAILED);
            return false;
        }

        try {
            if (!isUserExist(reg)) {
                setStatus(USER_NOT_FOUND);
                return false;
            }


            List<String> updatedSignupLines = processSignupFileAndUpdate(reg, name, phonenumber, role);


            if (!updatedSignupLines.isEmpty()) {
                writeToFile(SIGNUP_FILE, updatedSignupLines);
                setStatus(STATUS_UPDATE_SUCCESS);
                return true;
            } else {
                setStatus(STATUS_UPDATE_FAILED);
            }
        } catch (IOException e) {
            setStatus(STATUS_UPDATE_FAILED);
            e.printStackTrace();
        }

        return false;
    }

    private boolean isUserExist(String reg) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(INFORMATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(reg + ":")) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> processSignupFileAndUpdate(String reg, String name, String phonenumber, String role) throws IOException {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(SIGNUP_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                updatedLines.add(processSignupLine(line, reg, name, phonenumber, role));
            }
        }

        return updatedLines;
    }

    private String processSignupLine(String line, String reg, String name, String phonenumber, String role) {
        String[] credentials = line.split(":");
        if (credentials.length != 3 || !credentials[0].equals(reg)) {
            return line;
        }

        return reg + ":" +
                (isEmpty(phonenumber) ? credentials[2] : phonenumber) + ":" +
                (isEmpty(role) ? credentials[1] : role);
    }

    private void writeToFile(String filePath, List<String> updatedLines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        }
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
