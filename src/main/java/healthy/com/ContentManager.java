package healthy.com;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {

    private List<String> approvedContent;
    private List<String> rejectedContent;
    private List<String> pendingContent; // قائمة للمراجعات المعلقة
    private List<String> userFeedback;

    public ContentManager() {
        approvedContent = new ArrayList<>();
        rejectedContent = new ArrayList<>();
        pendingContent = new ArrayList<>(); // قائمة المراجعات المعلقة
        userFeedback = new ArrayList<>();
    }

    // إضافة المراجعات المرسلة من FeedbackManagement كـ Pending Content
    public void addPendingContent(String feedback) {
        pendingContent.add(feedback);
    }

    public String reviewContent(String title, String action) {
        if (action.equalsIgnoreCase("approve")) {
            approvedContent.add(title);
            pendingContent.remove(title); // إزالة من المعلقة
            return "The content titled '" + title + "' has been approved successfully.";
        } else if (action.equalsIgnoreCase("reject")) {
            rejectedContent.add(title);
            pendingContent.remove(title); // إزالة من المعلقة
            return "The content titled '" + title + "' has been rejected successfully.";
        } else {
            return "Invalid action for the content titled '" + title + "'.";
        }
    }

    public String handleFeedback(String feedbackTitle) {
        userFeedback.add(feedbackTitle);
        return "Feedback or complaint titled '" + feedbackTitle + "' has been handled successfully.";
    }

    public List<String> getPendingContent() {
        return pendingContent;
    }

    public List<String> getApprovedContent() {
        return approvedContent;
    }

    public List<String> getRejectedContent() {
        return rejectedContent;
    }

    public List<String> getUserFeedback() {
        return userFeedback;
    }
}
