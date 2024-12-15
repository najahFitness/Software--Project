package healthy.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SinUp_FromAdmin {
    private String status;

    public boolean isSinUP(String name, String role, String phonenumber) {
        if (name.isEmpty() || role.isEmpty() || phonenumber.isEmpty()) {
            setStatus("Invalid name or phonenumber");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/Informations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 5) {

                    if (credentials[2].equals(name) && credentials[4].equals(phonenumber)) {

                        if (credentials[3].equals("Client")) {
                            setStatus("Client added successfully");
                            return true;
                        } else if (credentials[3].equals("Instructor")) {
                            setStatus("Instructor added successfully");
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            setStatus("Invalid name or phonenumber");
            e.printStackTrace();
        }


        setStatus("Invalid name or phonenumber");
        return false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
