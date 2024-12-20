package fts;

import healthy.com.SubscriptionManager;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class SubscriptionManagementSteps {

    private SubscriptionManager subscriptionManager;
    private String username;
    private String result;

    @Given("the admin is logged into the subscription management system")
    public void the_admin_is_logged_into_the_subscription_management_system() {
        subscriptionManager = new SubscriptionManager();
        System.out.println("Admin logged into the subscription management system.");
    }

    @When("the admin views the current subscription plan for {string} with username {string}")
    public void the_admin_views_the_current_subscription_plan_for_with_username(String userType, String username) {
        this.username = username;
        String currentPlan = subscriptionManager.viewSubscription(userType, username);
        System.out.println("Current subscription plan for " + userType + " with username " + username + ": " + currentPlan);
    }

    @When("the admin changes the subscription plan to {string}")
    public void the_admin_changes_the_subscription_plan_to(String newPlan) {
        result = subscriptionManager.updateSubscription(username, newPlan);
        System.out.println("Subscription plan changed to: " + newPlan);
    }

    @Then("the system should confirm that the subscription plan for {string} is updated to {string}")
    public void the_system_should_confirm_that_the_subscription_plan_for_is_updated_to(String username, String expectedPlan) {
        assertEquals("The subscription plan for " + username + " has been updated to " + expectedPlan + ".", result);
        System.out.println("The system confirmed: Subscription plan for " + username + " is updated to " + expectedPlan + ".");
    }
}
