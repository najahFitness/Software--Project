package fts;

import healthy.com.Chating;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chating_test {

    private Chating chat;
    private String messageContent;
    private String discussionComment;
    private String feedback;
    private String progressReport;

    @Given("the admin is logged into the system to interact with clients")
    public void the_admin_is_logged_into_the_system_to_interact_with_clients() {
        chat = new Chating(); // Create a new instance of the Chating class
    }

    @When("the admin sends a message to the client 'messageContent' with {string} for chating")
    public void the_admin_sends_a_message_to_the_client_with_for_chating(String message) {
        messageContent = message; // Store the message content
    }

    @When("the admin posts a discussion forum comment 'discussionComment' with {string} for chating")
    public void the_admin_posts_a_discussion_forum_comment_with_for_chating(String comment) {
        discussionComment = comment; // Store the discussion comment
    }

    @When("the admin provides feedback 'feedback' with {string} for chating")
    public void the_admin_provides_feedback_with_for_chating(String feedbackMessage) {
        feedback = feedbackMessage; // Store the feedback message
    }

    @When("the admin prepares a progress report 'progressReport' with {string} for chating")
    public void the_admin_prepares_a_progress_report_with_for_chating(String report) {
        progressReport = report; // Store the progress report
    }

    @When("the admin sends the progress report to the client")
    public void the_admin_sends_the_progress_report_to_the_client() {
        boolean result = chat.addClientMessage(messageContent, discussionComment, feedback, progressReport);
        assertEquals(true, result, "The message should be sent successfully");
    }

    @Then("the client should receive {string} for chating")
    public void the_client_should_receive_for_chating(String expectedStatus) {
        assertEquals(expectedStatus, chat.getStatus(), "The client should receive the correct status");
    }
}
