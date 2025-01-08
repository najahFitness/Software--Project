package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddNewProgram {

    private static final String STATUS_UNACCEPTABLE = "unacceptable";
    private static final String STATUS_PROGRAM_ADDED = "Program added successfully";
    private static final String FILE_PATH = "src/test/resources/ApprovingFitnessProgram.txt";


    private static final Logger logger = Logger.getLogger(AddNewProgram.class.getName());

    private String status;

    public boolean addFitnessProgram(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {


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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine();
            }
            setStatus(STATUS_PROGRAM_ADDED);
            return true;
        } catch (IOException e) {

            setStatus(STATUS_UNACCEPTABLE);
            // Replacing System.err with Logger
            logger.log(Level.SEVERE, "Error writing to file: {0}", e.getMessage());
            logger.log(Level.SEVERE, "Stack Trace:", e);
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
