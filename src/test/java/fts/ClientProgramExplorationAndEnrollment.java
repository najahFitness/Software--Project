package fts;

import healthy.com.ProgramManagement;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientProgramExplorationAndEnrollment {

    private ProgramManagement programManagement;
    private String difficultyLevel;
    private String focusArea;
    private String programTitle;
    private String confirmationMessage;

    @Given("the client is logged into the system to explore programs")
    public void the_client_is_logged_into_the_system_to_explore_programs() {
        programManagement = new ProgramManagement();
    }

    @When("the client browses programs by difficulty level {string}")
    public void the_client_browses_programs_by_difficulty_level(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        programManagement.filterProgramsByDifficulty(difficultyLevel);
    }

    @When("the client browses programs by focus area {string}")
    public void the_client_browses_programs_by_focus_area(String focusArea) {
        this.focusArea = focusArea;
        programManagement.filterProgramsByFocusArea(focusArea);
    }

    @When("the client selects a program titled {string} for enrollment")
    public void the_client_selects_a_program_titled_for_enrollment(String programTitle) {
        this.programTitle = programTitle;
        confirmationMessage = programManagement.enrollInProgram(programTitle);
    }

    @When("the client confirms the enrollment")
    public void the_client_confirms_the_enrollment() {
        confirmationMessage = programManagement.confirmEnrollment(programTitle);
    }

    @Then("the system should confirm {string} for the enrollment")
    public void the_system_should_confirm_for_the_enrollment(String expectedMessage) {
        assertEquals(expectedMessage, confirmationMessage, "The enrollment confirmation should match.");
    }
}
