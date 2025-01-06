package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class updateFromAdmin {

    private static final String STATUS_UPDATE_FAILED = "Update failed";
    private static final String STATUS_UPDATE_SUCCESS = "Update successful";
    private static final String FILE_PATH = "src/test/resources/Informations.txt";

    private String status;

    public boolean updating(String reg, String name, String password, String phonenumber, String role) {
        if (reg.isEmpty()) {
            setStatus(STATUS_UPDATE_FAILED);
            return false;
        }

        try {
            List<String> updatedLines = readAndUpdateFile(reg, name, password, phonenumber, role);
            if (updatedLines != null) {
                writeToFile(updatedLines);
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

    private List<String> readAndUpdateFile(String reg, String name, String password, String phonenumber, String role) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        boolean regFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 5) {
                    if (credentials[0].equals(reg)) {
                        regFound = true;
                        updatedLines.add(updateLine(credentials, reg, name, password, phonenumber, role));
                    } else {
                        updatedLines.add(line);
                    }
                }
            }
        }

        return regFound ? updatedLines : null;
    }

    private String updateLine(String[] credentials, String reg, String name, String password, String phonenumber, String role) {
        String updatedPassword = password.isEmpty() ? credentials[1] : password;
        String updatedName = name.isEmpty() ? credentials[2] : name;
        String updatedRole = role.isEmpty() ? credentials[3] : role;
        String updatedPhoneNumber = phonenumber.isEmpty() ? credentials[4] : phonenumber;

        return reg + ":" + updatedName + ":" + updatedPassword + ":" + updatedPhoneNumber + ":" + updatedRole;
    }

    private void writeToFile(List<String> updatedLines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
