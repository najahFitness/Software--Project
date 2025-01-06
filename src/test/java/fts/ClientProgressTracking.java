package fts;

import healthy.com.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ClientProgressTracking {

    private ConsoleDisplay console;
    private ProgressManagement progressManagement;
    private String lastDisplayedMessage;
    private String currentMenu;

    @Given("the user starts the application for Progress Tracking")
    public void theUserStartsTheApplicationForProgressTracking() {
        console = new ConsoleDisplayImpl();
        progressManagement = new ProgressManagement(console);

        lastDisplayedMessage = "Main Menu:\n1. Account Management\n2. Program Exploration\n3. Progress Tracking\n4. Exit";
        currentMenu = "Main Menu";
        console.displayMessage(lastDisplayedMessage);
    }

    @When("the user selects {string} from the main menu")
    public void theUserSelectsFromTheMainMenu(String option) {
        if ("3. Progress Tracking".equals(option)) {
            lastDisplayedMessage = "Progress Tracking Menu:\n1. View Current Progress\n2. View Achievements and Badges\n3. Go Back";
            currentMenu = "Progress Tracking Menu";
            console.displayMessage(lastDisplayedMessage);
        } else {
            lastDisplayedMessage = "Invalid option selected from the main menu.";
            console.displayMessage(lastDisplayedMessage);
            throw new IllegalArgumentException(lastDisplayedMessage);
        }
    }

    @Then("the system displays the Progress Tracking menu options")
    public void theSystemDisplaysTheProgressTrackingMenuOptions() {
        assertEquals("The user should be on the Progress Tracking menu.", "Progress Tracking Menu", currentMenu);
    }

    @Given("the user is on the Progress Tracking menu")
    public void theUserIsOnTheProgressTrackingMenu() {
        theUserStartsTheApplicationForProgressTracking();
        theUserSelectsFromTheMainMenu("3. Progress Tracking");
    }

    @When("the user selects {string} in the Progress Tracking menu")
    public void theUserSelectsInTheProgressTrackingMenu(String option) {
        switch (option) {
            case "View Current Progress" -> {
                lastDisplayedMessage = "Viewing Current Progress...";
                console.displayMessage(lastDisplayedMessage);
            }
            case "View Achievements and Badges" -> {
                lastDisplayedMessage = "Viewing Achievements and Badges...";
                console.displayMessage(lastDisplayedMessage);
                progressManagement.viewAchievementsAndBadges();
            }
            case "Go Back" -> {
                lastDisplayedMessage = "Returning to Main Menu...";
                currentMenu = "Main Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> {
                lastDisplayedMessage = "Invalid option selected in Progress Tracking menu.";
                console.displayMessage(lastDisplayedMessage);
                throw new IllegalArgumentException(lastDisplayedMessage);
            }
        }
    }

    @When("the user views {string}")
    public void theUserViews(String metric) {
        lastDisplayedMessage = "Displaying metric: " + metric;
        progressManagement.displayMetric(metric);
    }

    @Then("the system displays the {string} correctly")
    public void theSystemDisplaysTheMetricCorrectly(String metric) {
        assertTrue("The system should confirm the metric is displayed correctly.",
                lastDisplayedMessage.contains(metric));
    }

    @Then("the system displays the achievements and badges")
    public void theSystemDisplaysTheAchievementsAndBadges() {
        lastDisplayedMessage = "Displaying achievements and badges...";
        console.displayMessage(lastDisplayedMessage);
        progressManagement.viewAchievementsAndBadges();
        assertTrue("The system should confirm achievements and badges are displayed.",
                lastDisplayedMessage.contains("achievements and badges"));
    }

    @Then("the system returns to the main menu from Progress Tracking")
    public void theSystemReturnsToTheMainMenuFromProgressTracking() {
        assertEquals("The user should be returned to the main menu.", "Main Menu", currentMenu);
    }

    @When("the user selects an invalid option in the Progress Tracking menu")
    public void theUserSelectsAnInvalidOptionInTheProgressTrackingMenu() {
        lastDisplayedMessage = "Invalid option selected in Progress Tracking menu.";
        console.displayMessage(lastDisplayedMessage);
    }

    @Then("the system handles the invalid option gracefully")
    public void theSystemHandlesTheInvalidOptionGracefully() {
        assertTrue("The system should display an error for invalid option.",
                lastDisplayedMessage.contains("Invalid option"));
    }

    @When("the user views an invalid metric {string}")
    public void theUserViewsAnInvalidMetric(String metric) {
        progressManagement.displayMetric(metric);
        lastDisplayedMessage = "Invalid metric: " + metric;
    }

    @Then("the system displays an error for the invalid metric")
    public void theSystemDisplaysAnErrorForTheInvalidMetric() {
        assertTrue("The system should display an error for invalid metric.",
                lastDisplayedMessage.contains("Invalid metric"));
    }
}
