package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class updateFromAdmin {
    private String status;

    public boolean updating(String reg, String name, String password, String phonenumber, String role) {
        if (reg.isEmpty()) {
            setStatus("Update failed");
            return false;
        }

        List<String> updatedLines = new ArrayList<>();
        boolean regFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/Informations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 5) {
                    // Check if registernumber matches
                    if (credentials[0].equals(reg)) {
                        regFound = true;

                        // If the fields are empty, retain the old values

                        String updatedPassword = password.isEmpty() ? credentials[1] : password;
                        String updatedName = name.isEmpty() ? credentials[2] : name;
                        String updatedRole = role.isEmpty() ? credentials[3] : role;
                        String updatedPhoneNumber = phonenumber.isEmpty() ? credentials[4] : phonenumber;

                        // Create the updated line with new or old values
                        String updatedLine = reg + ":" + updatedName + ":" + updatedPassword + ":" + updatedPhoneNumber + ":" + updatedRole;
                        updatedLines.add(updatedLine);  // Add the updated line
                    } else {
                        updatedLines.add(line);  // Add the line unchanged if reg doesn't match
                    }
                }
            }

            if (regFound) {
                // Write the updated lines back to the file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/Informations.txt"))) {
                    for (String updatedLine : updatedLines) {
                        bw.write(updatedLine);
                        bw.newLine();
                    }
                }
                setStatus("Update successful");
                return true;
            } else {
                setStatus("Update failed");  // registernumber not found
            }

        } catch (IOException e) {
            setStatus("Update failed");
            e.printStackTrace();
        }

        return false;  // registernumber not found or file error
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
