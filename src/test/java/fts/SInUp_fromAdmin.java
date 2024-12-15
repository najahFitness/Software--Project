package fts;

import healthy.com.SinUp_FromAdmin;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class SInUp_fromAdmin {
    private String name;
    private String role;
    private String phonenumber;
    public SinUp_FromAdmin op;

    @Given("admin is logged in to the system")
    public void admin_is_logged_in_to_the_system() {
        op = new SinUp_FromAdmin();
    }

    @When("admin fills in {string} with {string} with  for the client or instructor")
    public void admin_fills_in_with_with_for_the_client_or_instructor(String string, String string2) {
         if (string.equals("name")) {
             name = string2;
         }
         if (string.equals("role")) {
             role = string2;
         }
         if (string.equals("phonenumber")) {
             phonenumber = string2;
         }
    }
    @When("admin fills in {string} with {string} for the client or instructor")
    public void adminFillsInWithForTheClientOrInstructor(String string, String string2) {
        if (string.equals("name")) {
            name = string2;
        }
        if (string.equals("role")) {
            role = string2;
        }
        if (string.equals("phonenumber")) {
            phonenumber = string2;
        }
    }
    @When("admin fills in {string} with {string}  for the client or instructor")
    public void admin_FillsInWithForTheClientOrInstructor(String string, String string2) {
        if (string.equals("name")) {
            name = string2;
        }
        if (string.equals("role")) {
            role = string2;
        }
        if (string.equals("phonenumber")) {
            phonenumber = string2;
        }
    }



    @When("admin clicks on Add to create the new role")
    public void admin_clicks_on_add_to_create_the_new_role() {
        op.isSinUP(name, role, phonenumber);
    }

    @Then("admin should see a confirmation message {string} for the new  role")
    public void admin_should_see_a_confirmation_message_for_the_new_role(String string) {
        assertEquals(string,op.getStatus());
    }


}
