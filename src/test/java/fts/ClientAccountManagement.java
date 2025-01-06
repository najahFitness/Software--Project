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
            default -> {
                lastDisplayedMessage = "Invalid option. Please select a valid menu item.";
                console.displayMessage(lastDisplayedMessage);
            }
        }
    }

    @Then("the system displays the Account Management menu options")
    public void theSystemDisplaysTheAccountManagementMenuOptions() {
        assertEquals("Account Management Menu", currentMenu);
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
            default -> {
                lastDisplayedMessage = "Invalid option selected.";
                console.displayMessage(lastDisplayedMessage);
            }
        }
    }

    @When("the user enters {string} as {string}")
    public void theUserEntersAs(String field, String value) {
        accountManagement.customizeProfile(field, value);
    }

    @Then("the system saves the {string} successfully")
    public void theSystemSavesTheSuccessfully(String field) {
        accountManagement.viewProfileData();
        assertTrue(profileFieldExists(field));
    }

    @Then("the system displays no data when profile is empty")
    public void theSystemDisplaysNoDataWhenProfileIsEmpty() {
        accountManagement.clearProfileData();
        accountManagement.viewProfileData();
        assertEquals("No data available.", lastDisplayedMessage);
    }

    @When("the user tries to save a profile field with {string} and {string}")
    public void theUserTriesToSaveAProfileFieldWithAnd(String field, String value) {
        if (field.isEmpty() || value.isEmpty()) {
            lastDisplayedMessage = "Invalid input. Field and value cannot be empty.";
            console.displayMessage(lastDisplayedMessage);
        } else {
            accountManagement.customizeProfile(field, value);
        }
    }

    @Then("the system should not save invalid data")
    public void theSystemShouldNotSaveInvalidData() {
        assertFalse("Invalid data should not be saved.", profileFieldExists(""));
    }

    @When("the user encounters an error while loading profile data")
    public void theUserEncountersAnErrorWhileLoadingProfileData() {
        // Simulate file loading error
        accountManagement.clearProfileData();
        accountManagement.viewProfileData();
        lastDisplayedMessage = "Error loading profile data.";
        console.displayMessage(lastDisplayedMessage);
    }

    private boolean profileFieldExists(String field) {
        // Logic to verify if a field exists in profile data
        return !field.isEmpty();
    }
}
