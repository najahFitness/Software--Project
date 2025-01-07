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
        feedbackManagement.addFeedback("Test Program", Integer.parseInt(programRating), "No review yet.");
        lastDisplayedMessage = "Program rated with " + programRating + " stars.";
        System.out.println(lastDisplayedMessage);
    }

    @When("the user submits a review: {string}")
    public void theUserSubmitsAReview(String programReview) {
        feedbackManagement.addFeedback("Test Program", 0, programReview);
        lastDisplayedMessage = "Review submitted: " + programReview;
        System.out.println(lastDisplayedMessage);
    }

    @When("the user provides an improvement suggestion: {string}")
    public void theUserProvidesAnImprovementSuggestion(String suggestion) {
        feedbackManagement.addSuggestion("Test Program", suggestion);
        lastDisplayedMessage = "Suggestion submitted: " + suggestion;
        System.out.println(lastDisplayedMessage);
    }

    @Then("the system saves the rating, review, and suggestion successfully")
    public void theSystemSavesTheRatingReviewAndSuggestionSuccessfully() {
        lastDisplayedMessage = feedbackManagement.saveFeedbackAndSuggestions();
        System.out.println(lastDisplayedMessage);
        assertTrue("Feedback and suggestions should be saved successfully.",
                lastDisplayedMessage.contains("Feedback and Suggestions saved successfully."));
    }
}
