package fts;

import healthy.com.Chating;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;


public class Chating_test {
    private String messageContent;
    private String discussionComment;
    private String feedback;
    private String progressReport;
    private String confirmationMessage;
    public Chating newChat;
    @Given("the admin is logged into the system to interact with clients")
    public void the_admin_is_logged_into_the_system_to_interact_with_clients() {
        newChat = new Chating();
    }
    @When("the admin sends a message to the client {string} with {string} for chating")
    public void the_admin_sends_a_message_to_the_client_with_for_chating(String string, String string2) {
        setField(string,string2);
    }
    @When("the admin posts a discussion forum comment {string} with {string}  for chating")
    public void the_admin_posts_a_discussion_forum_comment_with_for_chating(String string, String string2) {
        setField(string, string2);
    }



    @When("the admin provides feedback {string}  with {string}  for chating")
    public void the_admin_provides_feedback_with_for_chating(String string, String string2) {
        setField(string,string2);
    }
    @When("the admin prepares a progress report {string} with {string}  for chating")
    public void the_admin_prepares_a_progress_report_with_for_chating(String string, String string2) {
        setField(string,string2);
    }



    @When("the admin sends the progress report to the client")
    public void the_admin_sends_the_progress_report_to_the_client() {
        newChat.addClientMessage(messageContent,discussionComment,feedback,progressReport);
    }

    @Then("the client should receive  {string}  for chating")
    public void the_client_should_receive_for_chating(String string) {
        assertEquals(string, newChat.getStatus());
    }




    private void setField(String field, String value) {
        switch (field) {
            case "messageContent":
                messageContent = value;
                break;
            case "discussionComment":
                discussionComment = value;
                break;
            case "feedback":
                feedback = value;
                break;
            case "progressReport":
                progressReport = value;
                break;
            case "confirmationMessage":
                confirmationMessage = value;
                break;

        }
    }
}