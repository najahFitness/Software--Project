package fts;

import healthy.com.updateFromAdmin;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;


public class update {
    private String regnum;
    private String password;
    private String name;
    private String role;
    private String phonenumber;

    public updateFromAdmin op;

    @Given("admin is logged in to the system for updating")
    public void admin_is_logged_in_to_the_system_for_updating() {
       op = new updateFromAdmin();
    }

    @When("admin fills in {string} with {string} for update")
    public void admin_fills_in_with_for_update(String string, String string2) {

        if(string.equals("registernumber")) {
            regnum = string2;
        }
        if(string.equals("name")) {
            name = string2;
        }
        if(string.equals("password")) {
            password = string2;
        }
        if(string.equals("phonenumber")) {
            phonenumber = string2;
        }
        if(string.equals("role")) {
            role = string2;
        }


   }

   @When("admin clicks on {string}")
   public void admin_clicks_on(String string) {
        op.updating(regnum, name, password, phonenumber, role);
  }

@Then("admin should see {string} for current status")
public void admin_should_see_for_current_status(String string) {
    assertEquals(string,op.getStatus());
}



}



