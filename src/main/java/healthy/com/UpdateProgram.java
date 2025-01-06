package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateProgram {

    private static final String STATUS_UPDATE_FAILED = "Update failed";
    private static final String STATUS_UPDATE_SUCCESS = "Program updated successfully";
    private static final String FILE_PATH = "src/test/resources/ApprovingFitnessProgram.txt";

    private String status;

    public boolean updateProgram(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {
        if (programTitle.isEmpty()) {
            setStatus(STATUS_UPDATE_FAILED);
            return false;
        }

        try {
            List<String> updatedLines = readAndUpdateFile(programTitle, duration, difficultyLevel, goals, price, schedule);
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

    private List<String> readAndUpdateFile(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        boolean programFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] programDetails = line.split(":");
                if (programDetails.length == 6) {
                    if (programDetails[0].equals(programTitle)) {
                        programFound = true;
                        updatedLines.add(updateLine(programDetails, programTitle, duration, difficultyLevel, goals, price, schedule));
                    } else {
                        updatedLines.add(line);
                    }
                }
            }
        }

        return programFound ? updatedLines : null;
    }

    private String updateLine(String[] programDetails, String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {
        String updatedDuration = duration.isEmpty() ? programDetails[1] : duration;
        String updatedDifficultyLevel = difficultyLevel.isEmpty() ? programDetails[2] : difficultyLevel;
        String updatedGoals = goals.isEmpty() ? programDetails[3] : goals;
        String updatedPrice = price.isEmpty() ? programDetails[4] : price;
        String updatedSchedule = schedule.isEmpty() ? programDetails[5] : schedule;

        return programTitle + ":" + updatedDuration + ":" + updatedDifficultyLevel + ":" + updatedGoals + ":" + updatedPrice + ":" + updatedSchedule;
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
