package healthy.com;

import java.util.ArrayList;
import java.util.List;

public class FeedbackManagement {
    private ConsoleDisplay console;
    private int programRating;
    private int trainerRating;
    private final List<String> feedbackReasons = new ArrayList<>();

    public FeedbackManagement(ConsoleDisplay console) {
        this.console = console;
    }

    // Set program rating
    public void setProgramRating(int rating) {
        this.programRating = rating;
        console.displayMessage("Program rated with " + rating + " stars.");
    }

    // Set trainer rating
    public void setTrainerRating(int rating) {
        this.trainerRating = rating;
        console.displayMessage("Trainer rated with " + rating + " stars.");
    }

    // Add reasons for feedback
    public void addReason(String aspect, String reason) {
        feedbackReasons.add(aspect + ": " + reason);
        console.displayMessage("Added reason for " + aspect + ": " + reason);
    }

    // Save feedback
    public void saveFeedback() {
        console.displayMessage("Saving feedback...");
        console.displayMessage("Program Rating: " + programRating + " stars");
        console.displayMessage("Trainer Rating: " + trainerRating + " stars");
        console.displayMessage("Feedback Reasons:");
        for (String reason : feedbackReasons) {
            console.displayMessage("- " + reason);
        }
        console.displayMessage("Feedback saved successfully!");
    }

    // Display all feedback
    public void displayFeedback() {
        console.displayMessage("Displaying all feedback...");
        console.displayMessage("Program Rating: " + programRating + " stars");
        console.displayMessage("Trainer Rating: " + trainerRating + " stars");
        console.displayMessage("Feedback Reasons:");
        for (String reason : feedbackReasons) {
            console.displayMessage("- " + reason);
        }
    }
}
