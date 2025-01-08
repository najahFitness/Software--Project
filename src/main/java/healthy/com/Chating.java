package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chating {

    private static final String UNACCEPTABLE = "unacceptable"; // Define constant for reuse
    private static final String CHAT_FILE = "src/test/resources/Chat.txt"; // Define constant for file path
    private String status;

    public boolean addClientMessage(String messageContent, String discussionComment, String feedback, String progressReport) {

        if (isEmpty(messageContent) || isEmpty(discussionComment) || isEmpty(feedback) || isEmpty(progressReport)) {
            setStatus(UNACCEPTABLE);
            return false;
        }

        List<String> clientData = new ArrayList<>();
        String clientDataLine = messageContent + ":" + discussionComment + ":" + feedback + ":" + progressReport;
        clientData.add(clientDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CHAT_FILE, true))) {
            for (String updatedLine : clientData) {
                bw.write(updatedLine);
                bw.newLine();
            }
            setStatus("The client has been notified successfully");
            return true;
        } catch (IOException e) {
            setStatus(UNACCEPTABLE);
            System.err.println("Error writing to file: " + e.getMessage());
        }

        setStatus(UNACCEPTABLE);
        return false;
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
