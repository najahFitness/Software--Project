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
        if (isEmpty(reg)) {
            setStatus(STATUS_UPDATE_FAILED);
            return false;
        }

        try {
            List<String> updatedLines = processFileAndUpdate(reg, name, password, phonenumber, role);
            if (!updatedLines.isEmpty()) {
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

    private List<String> processFileAndUpdate(String reg, String name, String password, String phonenumber, String role) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        boolean regFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                updatedLines.add(processLine(line, reg, name, password, phonenumber, role));
                if (line.startsWith(reg + ":")) regFound = true;
            }
        }

        return regFound ? updatedLines : new ArrayList<>();
    }

    private String processLine(String line, String reg, String name, String password, String phonenumber, String role) {
        String[] credentials = line.split(":");
        if (credentials.length != 5 || !credentials[0].equals(reg)) {
            return line;
        }

        return reg + ":" +
                (isEmpty(name) ? credentials[2] : name) + ":" +
                (isEmpty(password) ? credentials[1] : password) + ":" +
                (isEmpty(phonenumber) ? credentials[4] : phonenumber) + ":" +
                (isEmpty(role) ? credentials[3] : role);
    }

    private void writeToFile(List<String> updatedLines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
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
