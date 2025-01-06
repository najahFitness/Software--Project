package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chating {

    private String status;

    public boolean addClientMessage(String messageContent, String discussionComment, String feedback, String progressReport) {

        if (messageContent == null || messageContent.isEmpty() ||
                discussionComment == null || discussionComment.isEmpty() ||
                feedback == null || feedback.isEmpty() ||
                progressReport == null || progressReport.isEmpty()) {
            setStatus("unacceptable");
            return false;
        }

        List<String> clientData = new ArrayList<>();
        String clientDataLine = messageContent + ":" + discussionComment + ":" + feedback + ":" + progressReport;
        clientData.add(clientDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/Chat.txt", true))) {
            for (String updatedLine : clientData) {
                bw.write(updatedLine);
                bw.newLine();
            }
            setStatus("The client has been notified successfully");
            return true;
        } catch (IOException e) {
            setStatus("unacceptable");
            System.err.println("Error writing to file: " + e.getMessage());
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
