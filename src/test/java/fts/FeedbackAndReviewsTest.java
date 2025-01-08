package fts;

import healthy.com.FeedbackManagement;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

public class FeedbackAndReviewsTest {

    private FeedbackManagement feedbackManagement;
    private String lastDisplayedMessage;

    @Given("the user has completed the program {string}")
    public void theUserHasCompletedTheProgram(String programName) {
        feedbackManagement = new FeedbackManagement();
        lastDisplayedMessage = "Program " + programName + " completed. Ready to provide feedback.";
        System.out.println(lastDisplayedMessage);
    }

    @When("the user rates the program with {string} stars")
    public void theUserRatesTheProgramWithStars(String programRating) {
        feedbackManagement.addFeedback("Yoga for Beginners", Integer.parseInt(programRating), "No review yet.", "No suggestion yet.");
        lastDisplayedMessage = "Program rated with " + programRating + " stars.";
        System.out.println(lastDisplayedMessage);
    }

    @When("the user submits a review: {string}")
    public void theUserSubmitsAReview(String programReview) {
        feedbackManagement.addFeedback("Yoga for Beginners", 0, programReview, "No suggestion yet.");
        lastDisplayedMessage = "Review submitted: " + programReview;
        System.out.println(lastDisplayedMessage);
    }

    @When("the user provides an improvement suggestion: {string}")
    public void theUserProvidesAnImprovementSuggestion(String suggestion) {
        feedbackManagement.addFeedback("Yoga for Beginners", 0, "No review yet.", suggestion);
        lastDisplayedMessage = "Suggestion submitted: " + suggestion;
        System.out.println(lastDisplayedMessage);
    }

    @Then("the system saves the rating, review, and suggestion successfully")
    public void theSystemSavesTheRatingReviewAndSuggestionSuccessfully() {
        lastDisplayedMessage = feedbackManagement.saveFeedback();
        System.out.println(lastDisplayedMessage);
        assertTrue("Feedback and suggestions should be saved successfully.",
                lastDisplayedMessage.contains("Feedback saved successfully."));
    }
}
