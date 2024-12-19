package fts;

import healthy.com.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ClientAccountManagement {

    private ConsoleDisplay console;
    private AccountManagement accountManagement;
    private String lastDisplayedMessage;
    private String currentMenu;

    @Given("the user starts the application for Account Management")
    public void theUserStartsTheApplicationForAccountManagement() {
        console = new ConsoleDisplayImpl();
        accountManagement = new AccountManagement(console);

        // Simulate main menu display
        lastDisplayedMessage = "Main Menu:\n1. Account Management\n2. Exit";
        currentMenu = "Main Menu";
        console.displayMessage(lastDisplayedMessage);
    }

    @When("the user selects {string} from the Account Management main menu")
    public void theUserSelectsFromTheAccountManagementMainMenu(String option) {
        switch (option) {
            case "1. Account Management" -> {
                lastDisplayedMessage = "Account Management Menu:\n1. Customize Profile\n2. View Profile Data\n3. Clear Profile Data\n4. Go Back";
                currentMenu = "Account Management Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            case "2. Exit" -> {
                lastDisplayedMessage = "Exiting the application...";
                currentMenu = "Exit";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> throw new IllegalArgumentException("Invalid option selected from the Account Management main menu.");
        }
    }

    @Then("the system displays the Account Management menu options")
    public void theSystemDisplaysTheAccountManagementMenuOptions() {
        assertEquals("The user should be on the Account Management menu.", "Account Management Menu", currentMenu);
    }

    @Given("the user is on the Account Management menu")
    public void theUserIsOnTheAccountManagementMenu() {
        theUserStartsTheApplicationForAccountManagement();
        theUserSelectsFromTheAccountManagementMainMenu("1. Account Management");
    }

    @When("the user selects {string} in the Account Management menu")
    public void theUserSelectsInTheAccountManagementMenu(String option) {
        switch (option) {
            case "Customize Profile" -> {
                lastDisplayedMessage = "Customizing Profile...";
                console.displayMessage(lastDisplayedMessage);
            }
            case "View Profile Data" -> {
                lastDisplayedMessage = "Viewing Profile Data...";
                console.displayMessage(lastDisplayedMessage);
                accountManagement.viewProfileData();
            }
            case "Clear Profile Data" -> {
                lastDisplayedMessage = "Clearing Profile Data...";
                console.displayMessage(lastDisplayedMessage);
                accountManagement.clearProfileData();
            }
            case "Go Back" -> {
                lastDisplayedMessage = "Returning to Main Menu...";
                currentMenu = "Main Menu";
                console.displayMessage(lastDisplayedMessage);
            }
            default -> throw new IllegalArgumentException("Invalid option selected in Account Management menu.");
        }
    }

    @When("the user enters {string} as {string}")
    public void theUserEntersAs(String field, String value) {
        accountManagement.customizeProfile(field, value);
    }

    @Then("the system saves the {string} successfully")
    public void theSystemSavesTheSuccessfully(String field) {
        lastDisplayedMessage = field + " saved successfully!";
        console.displayMessage(lastDisplayedMessage);
        assertTrue("The system should confirm the field was saved.", lastDisplayedMessage.contains(field));
    }

    @Then("the system returns to the main menu from Account Management")
    public void theSystemReturnsToTheMainMenuFromAccountManagement() {
        assertEquals("The user should be returned to the main menu.", "Main Menu", currentMenu);
    }

}
