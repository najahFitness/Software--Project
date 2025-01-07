package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccountManagement {

    private static final String FILE_PATH = "src/test/resources/ClientProfiles.txt";

    public String createProfile(int age, int weight, int height, String fitnessGoals, String dietaryPreferences) {
        // Validate inputs
        if (age <= 0 || weight <= 0 || height <= 0 || fitnessGoals == null || fitnessGoals.isEmpty()) {
            return "Profile creation failed: Invalid inputs";
        }

        String profileData = "Age: " + age + ", Weight: " + weight + "kg, Height: " + height + "cm, Fitness Goals: " + fitnessGoals +
                ", Dietary Preferences: " + (dietaryPreferences.isEmpty() ? "None" : dietaryPreferences);

        // Save to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(profileData);
            writer.newLine();
        } catch (IOException e) {
            return "Profile creation failed: Unable to save";
        }

        return "Profile created successfully";
    }
}
