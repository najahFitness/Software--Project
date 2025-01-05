package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewProgram {
//a
    // Define constants for repeated literals
    private static final String STATUS_UNACCEPTABLE = "unacceptable";
    private static final String STATUS_PROGRAM_ADDED = "Program added successfully";
    private static final String FILE_PATH = "src/test/resources/ApprovingFitnessProgram.txt";

    private String status;

    public boolean addFitnessProgram(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {

        // Validate inputs
        if (programTitle == null || programTitle.isEmpty() ||
                duration == null || duration.isEmpty() ||
                difficultyLevel == null || difficultyLevel.isEmpty() ||
                goals == null || goals.isEmpty() ||
                price == null || price.isEmpty() ||
                schedule == null || schedule.isEmpty()) {
            setStatus(STATUS_UNACCEPTABLE);
            return false;
        }

        List<String> approvingData = new ArrayList<>();
        String approvingDataLine = programTitle + ":" + duration + ":" + difficultyLevel + ":" + goals + ":" + price + ":" + schedule;
        approvingData.add(approvingDataLine);

        // Write to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine();
            }
            setStatus(STATUS_PROGRAM_ADDED);
            return true;
        } catch (IOException e) {

            setStatus(STATUS_UNACCEPTABLE);
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }

        setStatus(STATUS_UNACCEPTABLE);
        return false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
