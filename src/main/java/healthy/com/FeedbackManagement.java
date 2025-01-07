package healthy.com;

import java.util.ArrayList;
import java.util.List;

public class FeedbackManagement {

    private final List<String> feedbackList;
    private final List<String> suggestionsList;

    public FeedbackManagement() {
        this.feedbackList = new ArrayList<>();
        this.suggestionsList = new ArrayList<>();
    }

    // Add rating and review
    public void addFeedback(String programName, int programRating, String programReview) {
        String feedback = "Program: " + programName + ", Rating: " + programRating + " stars, Review: " + programReview;
        feedbackList.add(feedback);
    }

    // Add improvement suggestion
    public void addSuggestion(String programName, String suggestion) {
        String fullSuggestion = "Program: " + programName + ", Suggestion: " + suggestion;
        suggestionsList.add(fullSuggestion);
    }

    // Save feedback and suggestions
    public String saveFeedbackAndSuggestions() {
        StringBuilder result = new StringBuilder("Feedback and Suggestions saved successfully.\n");
        result.append("Feedback:\n");
        for (String feedback : feedbackList) {
            result.append("- ").append(feedback).append("\n");
        }
        result.append("Suggestions:\n");
        for (String suggestion : suggestionsList) {
            result.append("- ").append(suggestion).append("\n");
        }
        return result.toString();
    }

    // Display all feedback and suggestions
    public String displayAllFeedback() {
        StringBuilder result = new StringBuilder("Displaying all feedback and suggestions:\n");
        if (feedbackList.isEmpty() && suggestionsList.isEmpty()) {
            return "No feedback or suggestions submitted yet.";
        }
        if (!feedbackList.isEmpty()) {
            result.append("Feedback:\n");
            for (String feedback : feedbackList) {
                result.append("- ").append(feedback).append("\n");
            }
        }
        if (!suggestionsList.isEmpty()) {
            result.append("Suggestions:\n");
            for (String suggestion : suggestionsList) {
                result.append("- ").append(suggestion).append("\n");
            }
        }
        return result.toString();
    }
}
