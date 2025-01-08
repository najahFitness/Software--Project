package fts;

import healthy.com.SignUpFromAdmin;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class SInUp_fromAdmin {
    private String name;
    private String role;
    private String phonenumber;
    private SignUpFromAdmin op;

    @Given("admin is logged in to the system")
    public void admin_is_logged_in_to_the_system() {
        op = new SignUpFromAdmin(); // إنشاء كائن من الفئة SignUpFromAdmin
    }

    @When("admin fills in {string} with {string} for the client or instructor")
    public void admin_fills_in_with_for_the_client_or_instructor(String field, String value) {
        switch (field) {
            case "name" -> name = value;
            case "role" -> role = value;
            case "phonenumber" -> phonenumber = value;
        }
    }

    @When("admin clicks on Add to create the new role")
    public void admin_clicks_on_add_to_create_the_new_role() {
        op.isSinUP(name, role, phonenumber); // استدعاء الدالة الرئيسية
    }

    @Then("admin should see a confirmation message {string} for the new role")
    public void admin_should_see_a_confirmation_message_for_the_new_role(String expectedMessage) {
        assertEquals(expectedMessage, op.getStatus());
    }
}
