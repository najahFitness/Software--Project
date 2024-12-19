package fts;

import healthy.com.UpdateProgram;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class UdatingProgram_test {

    private String programtitle;
    private String duration;
    private String difficultylevel;
    private String goals;
    private String price;
    private String schedule;
    public UpdateProgram op;



    @Given("admin is logged in to the system for updating new fitness programs")
    public void admin_is_logged_in_to_the_system_for_updating_new_fitness_programs() {
       op = new UpdateProgram();
    }

    @When("admin fills in {string} with {string} for updating")
    public void admin_fills_in_with_for_updating(String string, String string2) {
        setField(string,string2);
    }

    @When("admin sets {string} to {string} for group sessions updating")
    public void admin_sets_to_for_group_sessions_updating(String string, String string2) {
        setField(string,string2);
    }

    @When("admin clicks on Update Program")
    public void admin_clicks_on_update_program() {
          op.updateProgram(programtitle, duration, difficultylevel, goals, price, schedule);
    }

    @Then("admin should see {string} for update opration")
    public void admin_should_see_for_update_opration(String string) {
        assertEquals(string, op.getStatus());
    }
    private void setField(String field, String value) {
        switch (field) {
            case "programtitle":
                programtitle = value;
                break;
            case "duration":
                duration = value;
                break;
            case "difficultylevel":
                difficultylevel = value;
                break;
            case "goals":
                goals = value;
                break;
            case "price":
                price = value;
                break;
            case "schedule":
                schedule = value;
                break;
        }
    }



}
