package healthy.com;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionManager {

    private Map<String, String> clientSubscriptions;
    private Map<String, String> instructorSubscriptions;

    public SubscriptionManager() {
        clientSubscriptions = new HashMap<>();
        instructorSubscriptions = new HashMap<>();


        clientSubscriptions.put("john_doe", "Basic");
        clientSubscriptions.put("emma_client", "Standard");

        instructorSubscriptions.put("jane_instructor", "Premium");
        instructorSubscriptions.put("mark_instructor", "Basic");
    }

    public String viewSubscription(String userType, String username) {
        if (userType.equalsIgnoreCase("Client")) {
            return clientSubscriptions.getOrDefault(username, "No subscription found.");
        } else if (userType.equalsIgnoreCase("Instructor")) {
            return instructorSubscriptions.getOrDefault(username, "No subscription found.");
        }
        return "Invalid user type.";
    }

    public String updateSubscription(String username, String newPlan) {
        if (clientSubscriptions.containsKey(username)) {
            clientSubscriptions.put(username, newPlan);
            return "The subscription plan for " + username + " has been updated to " + newPlan + ".";
        } else if (instructorSubscriptions.containsKey(username)) {
            instructorSubscriptions.put(username, newPlan);
            return "The subscription plan for " + username + " has been updated to " + newPlan + ".";
        }
        return "Username not found.";
    }
}
