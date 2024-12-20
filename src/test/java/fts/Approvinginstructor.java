package fts;

import healthy.com.ApprovingFromAdmin;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class Approvinginstructor {
    private String name;
    private String phoneNumber;
    private String jobDescription;
    private String yearsOfExperience;

    public ApprovingFromAdmin op;

    @Given("Admin is on the registration requests page")
    public void admin_is_on_the_registration_requests_page() {
        op = new ApprovingFromAdmin();
    }

    @When("admin views the registration request for {string} with {string} with registration details")
    public void admin_views_the_registration_request_for_with_with_registration_details(String field, String value) {
        setField(field, value);
    }

    @When("admin checks the registration details for {string} with {string}")
    public void admin_checks_the_registration_details_for_with(String field, String value) {
        setField(field, value);
    }

    @When("admin verifies {string} has valid number of years of experience with {string}")
    public void admin_verifies_has_valid_number_of_years_of_experience_with(String field, String value) {
        setField(field, value);
    }

    @When("admin reads the job description for {string} with description {string}")
    public void admin_reads_the_job_description_for_with_description(String field, String value) {
        setField(field, value);
    }

    @When("admin clicks on approve for login")
    public void admin_clicks_on_approve_for_login() {
        op.addInstructor(name, phoneNumber, yearsOfExperience, jobDescription);
    }





    @Then("user should see {string} for Appproving")
    public void user_should_see_for_appproving(String expectedStatus) {
        assertEquals(expectedStatus, op.getStatus());
    }

    private void setField(String field, String value) {
        switch (field) {
            case "name":
                name = value;
                break;
            case "phone_number":
                phoneNumber = value;
                break;
            case "years_of_experience":
                yearsOfExperience = value;
                break;
            case "job_description":
                jobDescription = value;
                break;
        }
    }
}
