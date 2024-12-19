package fts;

import healthy.com.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ClientProgramExplorationAndEnrollment {

    private ConsoleDisplay console;
    private ProgramManagement programManagement;
    private String lastDisplayedMessage;
    private String currentMenu;

    @Given("the user starts the application for Program Exploration")
    public void theUserStartsTheApplicationForProgramExploration() {
        console = new ConsoleDisplayImpl();
        programManagement = new ProgramManagement(console);

        // Simulate main menu display
        lastDisplayedMessage = "Main Menu:\n1. Account Management\n2. Program Exploration\n3. Exit";
        currentMenu = "Main Menu";
        console.displayMessage(lastDisplayedMessage);
    }

    @When("the user selects {string} from the Program Exploration main menu")
    public void theUserSelectsFromTheProgramExplorationMainMenu(String option) {
        switch (option) {
            case "2. Program Exploration" -> {
                lastDisplayedMessage = "Program Exploration Menu:\n1. Filter Programs by Difficulty Level\n2. Filter Programs by Focus Area\n3. View Program Schedule\n4. Go Back";
                currentMenu = "Program Exploration Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            case "3. Exit" -> {
                lastDisplayedMessage = "Exiting the application...";
                currentMenu = "Exit";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> throw new IllegalArgumentException("Invalid option selected from the Program Exploration main menu.");
        }
    }

    @Then("the system displays the Program Exploration menu options")
    public void theSystemDisplaysTheProgramExplorationMenuOptions() {
        assertEquals("The user should be on the Program Exploration menu.", "Program Exploration Menu", currentMenu);
    }

    @Given("the user is on the Program Exploration menu")
    public void theUserIsOnTheProgramExplorationMenu() {
        theUserStartsTheApplicationForProgramExploration();
        theUserSelectsFromTheProgramExplorationMainMenu("2. Program Exploration");
    }

    @When("the user selects {string} in the Program Exploration menu")
    public void theUserSelectsInTheProgramExplorationMenu(String option) {
        switch (option) {
            case "Filter Programs by Difficulty Level" -> {
                lastDisplayedMessage = "Filtering by Difficulty Level...";
                console.displayMessage(lastDisplayedMessage);
                programManagement.filterPrograms("Difficulty Level", "Beginner");
            }
            case "Filter Programs by Focus Area" -> {
                lastDisplayedMessage = "Filtering by Focus Area...";
                console.displayMessage(lastDisplayedMessage);
                programManagement.filterPrograms("Focus Area", "Weight Loss");
            }
            case "View Program Schedule" -> {
                lastDisplayedMessage = "Viewing Program Schedule...";
                console.displayMessage(lastDisplayedMessage);
                programManagement.viewProgramSchedule();
            }
            case "Go Back" -> {
                lastDisplayedMessage = "Returning to Main Menu...";
                currentMenu = "Main Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> throw new IllegalArgumentException("Invalid option selected in Program Exploration menu.");
        }
    }

    @Then("the system returns to the main menu from Program Exploration")
    public void theSystemReturnsToTheMainMenuFromProgramExploration() {
        assertEquals("The user should be returned to the main menu.", "Main Menu", currentMenu);
    }

}
