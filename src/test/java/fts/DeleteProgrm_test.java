package fts;

import healthy.com.DeleteProgram;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class DeleteProgrm_test {

     private String programtitle;
      public DeleteProgram op;

    @Given("admin is logged in to the system for deleting new fitness programs")
    public void admin_is_logged_in_to_the_system_for_deleting_new_fitness_programs() {
        op = new DeleteProgram();
    }

    @When("admin fills in {string} with {string} for deleting")
    public void admin_fills_in_with_for_deleting(String string, String string2) {
         if(string.equals("programtitle")) {
             programtitle = string2;
         }
    }

    @When("admin clicks on Delete Program")
    public void admin_clicks_on_delete_program() {
        op.deleteFitnessProgram(programtitle);
    }
    @Then("admin should see after deleting {string}")
    public void admin_should_see(String string) {
        assertEquals(string, op.getStatus());
    }



}
