package healthy.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SinUp_FromAdmin {
    private String status;
    private static final String DATA_FILE = "src/test/resources/Informations.txt";

    public boolean isSinUP(String name, String role, String phonenumber) {
        if (isEmpty(name) || isEmpty(role) || isEmpty(phonenumber)) {
            setStatus("Invalid name or phonenumber");
            return false;
        }

        Map<String, String[]> userData = loadUserData();
        for (String[] credentials : userData.values()) {
            if (credentials.length == 5 && credentials[2].equals(name) && credentials[4].equals(phonenumber)) {
                if (credentials[3].equals("Client")) {
                    setStatus("Client added successfully");
                    return true;
                } else if (credentials[3].equals("Instructor")) {
                    setStatus("Instructor added successfully");
                    return true;
                }
            }
        }

        setStatus("Invalid name or phonenumber");
        return false;
    }

    private Map<String, String[]> loadUserData() {
        Map<String, String[]> userData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 5) {
                    userData.put(credentials[0], credentials);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userData;
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
