package fts;

import healthy.com.AccountManagement;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientAccountManagement {

    private AccountManagement accountManagement;
    private int age;
    private int weight;
    private int height;
    private String fitnessGoals;
    private String dietaryPreferences;
    private String confirmationMessage;

    @Given("the client is logged into the system to manage their account")
    public void the_client_is_logged_into_the_system_to_manage_their_account() {
        accountManagement = new AccountManagement();
    }

    @When("the client enters personal details with {int}, {int}, and {int}")
    public void the_client_enters_personal_details_with_and(int age, int weight, int height) {
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @When("the client specifies fitness goals as {string}")
    public void the_client_specifies_fitness_goals_as(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    @When("the client specifies dietary preferences or restrictions as {string}")
    public void the_client_specifies_dietary_preferences_or_restrictions_as(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    @When("the client saves their profile")
    public void the_client_saves_their_profile() {
        confirmationMessage = accountManagement.createProfile(age, weight, height, fitnessGoals, dietaryPreferences);
    }

    @Then("the system should confirm {string} for the profile creation")
    public void the_system_should_confirm_for_the_profile_creation(String expectedMessage) {
        assertEquals(expectedMessage, confirmationMessage, "The profile creation confirmation should match.");
    }
}
