package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApprovingFromAdmin {
    private String status;


    public boolean addInstructor(String name, String phoneNumber, String yearsOfExperience, String jobDescription) {

        if (name == null || name.isEmpty() ||
                phoneNumber == null || phoneNumber.isEmpty() ||
                yearsOfExperience == null || yearsOfExperience.isEmpty() ||
                jobDescription == null || jobDescription.isEmpty()) {
            setStatus("unacceptable");
            return false;
        }

        List<String> approvingData = new ArrayList<>();
        String approvingDataLine = name + ":" + phoneNumber + ":" + yearsOfExperience + ":" + jobDescription;
        approvingData.add(approvingDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/programs.txt", true))) {

            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine();
            }
            setStatus("Accepted");
            return true;
        } catch (IOException e) {

            setStatus("unacceptable");
            e.printStackTrace();
        }

        setStatus("unacceptable");
        return false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
