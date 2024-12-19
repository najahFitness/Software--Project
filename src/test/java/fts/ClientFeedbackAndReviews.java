package fts;

import healthy.com.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ClientFeedbackAndReviews {

    private ConsoleDisplay console;
    private FeedbackManagement feedbackManagement;
    private String lastDisplayedMessage;
    private String currentMenu;

    @Given("the user has completed a program")
    public void theUserHasCompletedAProgram() {
        console = new ConsoleDisplayImpl();
        feedbackManagement = new FeedbackManagement(console);

        lastDisplayedMessage = "Program completed. Ready to provide feedback.";
        console.displayMessage(lastDisplayedMessage);
    }

    @When("the user rates the program with {string} stars in Feedback and Reviews")
    public void theUserRatesTheProgramWithStarsInFeedbackAndReviews(String programRating) {
        feedbackManagement.setProgramRating(Integer.parseInt(programRating));
        console.displayMessage("Program rated with " + programRating + " stars.");
    }

    @When("the user rates the trainer with {string} stars in Feedback and Reviews")
    public void theUserRatesTheTrainerWithStarsInFeedbackAndReviews(String trainerRating) {
        feedbackManagement.setTrainerRating(Integer.parseInt(trainerRating));
        console.displayMessage("Trainer rated with " + trainerRating + " stars.");
    }

    @When("the user provides reasons:")
    public void theUserProvidesReasons(io.cucumber.datatable.DataTable reasonsTable) {
        List<List<String>> reasons = reasonsTable.asLists(String.class);
        for (List<String> reason : reasons) {
            feedbackManagement.addReason(reason.get(0), reason.get(1));
        }
        console.displayMessage("Reasons added successfully.");
    }

    @Then("the system saves the ratings and reasons successfully in Feedback and Reviews")
    public void theSystemSavesTheRatingsAndReasonsSuccessfullyInFeedbackAndReviews() {
        feedbackManagement.saveFeedback();
        lastDisplayedMessage = "Feedback saved successfully.";
        console.displayMessage(lastDisplayedMessage);
        assertTrue("Feedback should be saved successfully.", lastDisplayedMessage.contains("successfully"));
    }

    @Given("the user is on the Feedback and Reviews menu")
    public void theUserIsOnTheFeedbackAndReviewsMenu() {
        currentMenu = "Feedback and Reviews Menu";
        console.displayMessage(currentMenu + " is now active.");
    }

    @When("the user selects {string} in Feedback and Reviews")
    public void theUserSelectsInFeedbackAndReviews(String option) {
        switch (option) {
            case "View Submitted Feedback" -> {
                feedbackManagement.displayFeedback();
                console.displayMessage("Feedback displayed successfully.");
            }
            case "Go Back" -> {
                lastDisplayedMessage = "Returning to Main Menu...";
                currentMenu = "Main Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> throw new IllegalArgumentException("Invalid option selected in Feedback and Reviews.");
        }
    }

    @Then("the system displays all feedback successfully")
    public void theSystemDisplaysAllFeedbackSuccessfully() {
        lastDisplayedMessage = "Displaying all submitted feedback...";
        console.displayMessage(lastDisplayedMessage);
        assertTrue("All feedback should be displayed.", lastDisplayedMessage.contains("submitted feedback"));
    }

    @Then("the system returns to the main menu from Feedback and Reviews")
    public void theSystemReturnsToTheMainMenuFromFeedbackAndReviews() {
        assertTrue("The user should return to the main menu.", "Main Menu".equals(currentMenu));
    }
}

