package healthy.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class user {
    private String status;
    private static final String CREDENTIALS_FILE = "src/test/resources/Informations.txt";

    public boolean login(String username, String password) {
        if (isEmpty(username) || isEmpty(password)) {
            setStatus("Invalid username or password");
            return false;
        }

        Map<String, String> credentials = loadCredentials();
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            setStatus("Valid username and password");
            return true;
        }

        setStatus("Invalid username or password");
        return false;
    }

    private Map<String, String> loadCredentials() {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    credentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
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
