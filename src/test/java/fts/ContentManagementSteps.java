package fts;

import healthy.com.ContentManager;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class ContentManagementSteps {

    private ContentManager contentManager;
    private String result;
    private String contentTitle;

    @Given("the admin is logged into the content management system")
    public void the_admin_is_logged_into_the_content_management_system() {
        contentManager = new ContentManager();
        System.out.println("Admin logged into the content management system.");
    }

    @When("the admin reviews a shared article titled {string}")
    public void the_admin_reviews_a_shared_article_titled(String contentTitle) {
        this.contentTitle = contentTitle;
        System.out.println("Admin is reviewing the article titled: " + contentTitle);
    }

    @When("the admin decides to {string} the content")
    public void the_admin_decides_to_the_content(String action) {
        result = contentManager.reviewContent(contentTitle, action);
        System.out.println("Admin decided to " + action + " the content.");
    }

    @Then("the system should confirm that the content is {string}")
    public void the_system_should_confirm_that_the_content_is(String expectedResult) {
        assertEquals("The content titled '" + contentTitle + "' has been " + expectedResult + ".", result);
        System.out.println("The system confirmed: " + expectedResult);
    }

    @Then("the admin should be able to handle user feedback or complaints titled {string}")
    public void the_admin_should_be_able_to_handle_user_feedback_or_complaints_titled(String feedbackTitle) {
        String feedbackResult = contentManager.handleFeedback(feedbackTitle);
        System.out.println("Feedback/Complaint titled '" + feedbackTitle + "': " + feedbackResult);
    }
}