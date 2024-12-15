package healthy.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class user {
    private String status;
    public boolean login(String username, String password) {
        if(username.isEmpty() || password.isEmpty()) {
            setStatus("Invalid username or password");
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/Informations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 2) {
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        setStatus("Valid username and password");
                        return true;  // Credentials match
                    }
                }
            }
        } catch (IOException e) {
            setStatus("Invalid username or password");
            e.printStackTrace();
        }
        setStatus("Invalid username or password");
        return false;  // Credentials do not match
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
