package fts;

import healthy.com.ClientInteraction;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class Notification_test {

    private ClientInteraction clientInteraction;
    private String notificationMessage;

    @Given("the admin is logged into the system to notify clients about updates")
    public void the_admin_is_logged_into_the_system_to_notify_clients_about_updates() {
        clientInteraction = new ClientInteraction();
    }

    @When("the admin notifies the client about the rescheduling of the lesson {string} to {string}")
    public void the_admin_notifies_the_client_about_the_rescheduling_of_the_lesson_to(String lessonName, String newTime) {
        notificationMessage = "The lesson " + lessonName + " has been rescheduled to " + newTime + ".";
    }

    @When("the admin informs the client about a special discount or offer {string}")
    public void the_admin_informs_the_client_about_a_special_discount_or_offer(String discountOffer) {
        notificationMessage += " Special offer: " + discountOffer + ".";
    }

    @Then("the client should receive {string} confirming the publication was successful")
    public void the_client_should_receive_confirming_the_publication_was_successful(String expectedMessage) {

        clientInteraction.setStatus(notificationMessage);

        assertEquals(expectedMessage, clientInteraction.getStatus());
    }
}