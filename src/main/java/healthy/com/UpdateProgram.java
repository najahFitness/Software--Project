package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateProgram {
    private String status;

    public boolean updateProgram(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {
        if (programTitle.isEmpty()) {
            setStatus("Update failed");
            return false;
        }

        List<String> updatedLines = new ArrayList<>();
        boolean programFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/ApprovingFitnessProgram.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] programDetails = line.split(":");
                if (programDetails.length == 6) {
                    if (programDetails[0].equals(programTitle)) {
                        programFound = true;

                        String updatedDuration = duration.isEmpty() ? programDetails[1] : duration;
                        String updatedDifficultyLevel = difficultyLevel.isEmpty() ? programDetails[2] : difficultyLevel;
                        String updatedGoals = goals.isEmpty() ? programDetails[3] : goals;
                        String updatedPrice = price.isEmpty() ? programDetails[4] : price;
                        String updatedSchedule = schedule.isEmpty() ? programDetails[5] : schedule;

                        String updatedLine = programTitle + ":" + updatedDuration + ":" + updatedDifficultyLevel + ":" + updatedGoals + ":" + updatedPrice + ":" + updatedSchedule;
                        updatedLines.add(updatedLine);
                    } else {
                        updatedLines.add(line);
                    }
                }
            }

            if (programFound) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/ApprovingFitnessProgram.txt"))) {
                    for (String updatedLine : updatedLines) {
                        bw.write(updatedLine);
                        bw.newLine();
                    }
                }
                setStatus("Program updated successfully");
                return true;
            } else {
                setStatus("Update failed");
            }

        } catch (IOException e) {
            setStatus("Update failed");
            e.printStackTrace();
        }

        return false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
