package healthy.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleDisplay console = new ConsoleDisplayImpl();
        AccountManagement accountManagement = new AccountManagement(console);
        ProgramManagement programManagement = new ProgramManagement(console);
        ProgressManagement progressManagement = new ProgressManagement(console);
        FeedbackManagement feedbackManagement = new FeedbackManagement(console);

        while (true) {
            console.displayMessage("Main Menu:");
            console.displayMessage("1. Account Management");
            console.displayMessage("2. Program Exploration");
            console.displayMessage("3. Progress Tracking");
            console.displayMessage("4. Feedback and Reviews");
            console.displayMessage("5. Exit");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (mainChoice == 1) {
                // Account Management Menu
                while (true) {
                    console.displayMessage("Account Management Menu:");
                    console.displayMessage("1. Customize Profile");
                    console.displayMessage("2. View Profile Data");
                    console.displayMessage("3. Clear Profile Data");
                    console.displayMessage("4. Go Back");

                    int accountChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (accountChoice == 1) {
                        console.displayMessage("Enter the field to customize (e.g., Age, Fitness Goal):");
                        String field = scanner.nextLine();
                        console.displayMessage("Enter the value for " + field + ":");
                        String value = scanner.nextLine();
                        accountManagement.customizeProfile(field, value);
                    } else if (accountChoice == 2) {
                        accountManagement.viewProfileData();
                    } else if (accountChoice == 3) {
                        accountManagement.clearProfileData();
                    } else if (accountChoice == 4) {
                        console.displayMessage("Returning to Main Menu...");
                        break;
                    } else {
                        console.displayMessage("Invalid option. Please try again.");
                    }
                }
            } else if (mainChoice == 2) {
                // Program Exploration Menu
                while (true) {
                    programManagement.displayMenu();

                    int programChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (programChoice == 1) {
                        console.displayMessage("Enter Difficulty Level (e.g., Beginner, Advanced):");
                        String difficulty = scanner.nextLine();
                        programManagement.filterPrograms("Difficulty Level", difficulty);
                    } else if (programChoice == 2) {
                        console.displayMessage("Enter Focus Area (e.g., Weight Loss, Muscle Building):");
                        String focusArea = scanner.nextLine();
                        programManagement.filterPrograms("Focus Area", focusArea);
                    } else if (programChoice == 3) {
                        programManagement.viewProgramSchedule();
                    } else if (programChoice == 4) {
                        console.displayMessage("Returning to Main Menu...");
                        break;
                    } else {
                        console.displayMessage("Invalid option. Please try again.");
                    }
                }
            } else if (mainChoice == 3) {
                // Progress Tracking Menu
                while (true) {
                    progressManagement.displayMenu();

                    int progressChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (progressChoice == 1) {
                        console.displayMessage("Enter metric to view (e.g., Weight, BMI, Attendance):");
                        String metric = scanner.nextLine();
                        progressManagement.displayMetric(metric);
                    } else if (progressChoice == 2) {
                        progressManagement.viewAchievementsAndBadges();
                    } else if (progressChoice == 3) {
                        console.displayMessage("Returning to Main Menu...");
                        break;
                    } else {
                        console.displayMessage("Invalid option. Please try again.");
                    }
                }
            } else if (mainChoice == 4) {
                // Feedback and Reviews Menu
                while (true) {
                    console.displayMessage("Feedback and Reviews Menu:");
                    console.displayMessage("1. Rate a Program and Trainer");
                    console.displayMessage("2. View Submitted Feedback");
                    console.displayMessage("3. Go Back");

                    int feedbackChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (feedbackChoice == 1) {
                        console.displayMessage("Enter Program Rating (1 to 5 stars):");
                        int programRating = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        feedbackManagement.setProgramRating(programRating);

                        console.displayMessage("Enter Trainer Rating (1 to 5 stars):");
                        int trainerRating = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        feedbackManagement.setTrainerRating(trainerRating);

                        console.displayMessage("Provide Feedback Reasons:");
                        console.displayMessage("Enter Reason for Program:");
                        String programReason = scanner.nextLine();
                        feedbackManagement.addReason("Program", programReason);

                        console.displayMessage("Enter Reason for Trainer:");
                        String trainerReason = scanner.nextLine();
                        feedbackManagement.addReason("Trainer", trainerReason);

                        feedbackManagement.saveFeedback();
                    } else if (feedbackChoice == 2) {
                        feedbackManagement.displayFeedback();
                    } else if (feedbackChoice == 3) {
                        console.displayMessage("Returning to Main Menu...");
                        break;
                    } else {
                        console.displayMessage("Invalid option. Please try again.");
                    }
                }
            } else if (mainChoice == 5) {
                console.displayMessage("Thank you for using the Fitness Management System!");
                break;
            } else {
                console.displayMessage("Invalid option. Please try again.");
            }
        }
    }
}
