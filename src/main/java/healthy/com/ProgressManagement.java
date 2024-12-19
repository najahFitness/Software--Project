package healthy.com;

import java.util.ArrayList;
import java.util.List;

public class ProgressManagement {
    private ConsoleDisplay console;

    public ProgressManagement(ConsoleDisplay console) {
        this.console = console;
    }

    public void displayMenu() {
        console.displayMessage("Progress Tracking Menu:");
        console.displayMessage("1. View Current Progress");
        console.displayMessage("2. View Achievements and Badges");
        console.displayMessage("3. Go Back");
    }

    public void viewAchievementsAndBadges() {
        List<String> achievements = new ArrayList<>();
        achievements.add("Completed 10 Sessions Badge");
        achievements.add("Lost 5 Kg Badge");
        achievements.add("Consistent Attendance Award");

        console.displayMessage("Achievements and Badges:");
        for (String achievement : achievements) {
            console.displayMessage("- " + achievement);
        }
    }

    public void displayMetric(String metric) {
        switch (metric) {
            case "Weight" -> console.displayMessage("Weight: 70kg");
            case "BMI" -> console.displayMessage("BMI: 22.5");
            case "Attendance" -> console.displayMessage("Attendance: 15/20 sessions completed");
            default -> console.displayMessage("Invalid metric: " + metric);
        }
    }
}

