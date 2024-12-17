package fts;

import healthy.com.AddNewProgram;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;


public class AddnNewprogram_test {
    private String programtitle;
    private String duration;
    private String difficultylevel;
    private String goals;
    private String price;
    private String schedule;
    public AddNewProgram newProgram;


    @Given("admin is logged in to the system for adding new fitness programs")
    public void admin_is_logged_in_to_the_system_for_adding_new_fitness_programs() {
        newProgram = new AddNewProgram();

    }

    @When("admin fills in {string} with {string} for addition")
    public void admin_fills_in_with_for_addition(String string, String string2) {
        setField(string,string2);
    }

    @When("admin sets {string} to {string} for group sessions addition")
    public void admin_sets_to_for_group_sessions_addition(String string, String string2) {
        setField(string,string2);
    }

    @When("admin clicks on Add Program")
    public void admin_clicks_on_add_program() {
       newProgram.addFitnessProgram(programtitle, duration, difficultylevel, goals, price, schedule);
    }

    @Then("admin should see {string}")
    public void admin_should_see(String string) {
        assertEquals(string, newProgram.getStatus());
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
