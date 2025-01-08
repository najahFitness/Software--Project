package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackManagement {

    private final List<String> feedbackList;
    private final String filePath;

    public FeedbackManagement() {
        this.feedbackList = new ArrayList<>();
        // تحديد المسار داخل مجلد resources في test
        this.filePath = "src/test/resources/Feedback.txt";
    }

    // Add feedback (program name, rating, review, suggestion)
    public void addFeedback(String programName, int programRating, String programReview, String suggestion) {
        String feedback = "Program: " + programName + ", Rating: " + programRating + " stars, Review: " + programReview + ", Suggestion: " + suggestion;
        feedbackList.add(feedback);
    }

    // Save feedback to file
    public String saveFeedback() {
        StringBuilder result = new StringBuilder("Feedback saved successfully.\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (String feedback : feedbackList) {
                writer.write(feedback);
                writer.newLine();
                result.append("- ").append(feedback).append("\n");
            }
            feedbackList.clear(); // تفريغ القائمة بعد الحفظ
        } catch (IOException e) {
            return "Error saving feedback: " + e.getMessage();
        }
        return result.toString();
    }

    // Read all feedback from file
    public String readFeedbackFromFile() {
        StringBuilder fileContents = new StringBuilder("=== All Feedback ===\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Error reading feedback file: " + e.getMessage();
        }
        return fileContents.toString();
    }

    // Display all feedback
    public String displayAllFeedback() {
        StringBuilder result = new StringBuilder("Displaying all feedback:\n");
        if (feedbackList.isEmpty()) {
            return "No feedback submitted yet.";
        }
        for (String feedback : feedbackList) {
            result.append("- ").append(feedback).append("\n");
        }
        return result.toString();
    }
}
