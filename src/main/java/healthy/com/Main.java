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

        Main mainApp = new Main();
        mainApp.displayMainMenu(scanner, console, accountManagement, programManagement, progressManagement, feedbackManagement);
    }

    private void displayMainMenu(Scanner scanner, ConsoleDisplay console,
                                 AccountManagement accountManagement, ProgramManagement programManagement,
                                 ProgressManagement progressManagement, FeedbackManagement feedbackManagement) {
        while (true) {
            console.displayMessage("Main Menu:");
            console.displayMessage("1. Account Management");
            console.displayMessage("2. Program Exploration");
            console.displayMessage("3. Progress Tracking");
            console.displayMessage("4. Feedback and Reviews");
            console.displayMessage("5. Exit");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mainChoice) {
                case 1 -> manageAccount(scanner, console, accountManagement);
                case 2 -> explorePrograms(scanner, console, programManagement);
                case 3 -> trackProgress(scanner, console, progressManagement);
                case 4 -> handleFeedback(scanner, console, feedbackManagement);
                case 5 -> {
                    console.displayMessage("Thank you for using the Fitness Management System!");
                    return;
                }
                default -> console.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void manageAccount(Scanner scanner, ConsoleDisplay console, AccountManagement accountManagement) {
        while (true) {
            console.displayMessage("Account Management Menu:");
            console.displayMessage("1. Customize Profile");
            console.displayMessage("2. View Profile Data");
            console.displayMessage("3. Clear Profile Data");
            console.displayMessage("4. Go Back");

            int accountChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (accountChoice) {
                case 1 -> {
                    console.displayMessage("Enter the field to customize (e.g., Age, Fitness Goal):");
                    String field = scanner.nextLine();
                    console.displayMessage("Enter the value for " + field + ":");
                    String value = scanner.nextLine();
                    accountManagement.customizeProfile(field, value);
                }
                case 2 -> accountManagement.viewProfileData();
                case 3 -> accountManagement.clearProfileData();
                case 4 -> {
                    console.displayMessage("Returning to Main Menu...");
                    return;
                }
                default -> console.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void explorePrograms(Scanner scanner, ConsoleDisplay console, ProgramManagement programManagement) {
        while (true) {
            programManagement.displayMenu();

            int programChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (programChoice) {
                case 1 -> {
                    console.displayMessage("Enter Difficulty Level (e.g., Beginner, Advanced):");
                    String difficulty = scanner.nextLine();
                    programManagement.filterPrograms("Difficulty Level", difficulty);
                }
                case 2 -> {
                    console.displayMessage("Enter Focus Area (e.g., Weight Loss, Muscle Building):");
                    String focusArea = scanner.nextLine();
                    programManagement.filterPrograms("Focus Area", focusArea);
                }
                case 3 -> programManagement.viewProgramSchedule();
                case 4 -> {
                    console.displayMessage("Returning to Main Menu...");
                    return;
                }
                default -> console.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void trackProgress(Scanner scanner, ConsoleDisplay console, ProgressManagement progressManagement) {
        while (true) {
            progressManagement.displayMenu();

            int progressChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (progressChoice) {
                case 1 -> {
                    console.displayMessage("Enter metric to view (e.g., Weight, BMI, Attendance):");
                    String metric = scanner.nextLine();
                    progressManagement.displayMetric(metric);
                }
                case 2 -> progressManagement.viewAchievementsAndBadges();
                case 3 -> {
                    console.displayMessage("Returning to Main Menu...");
                    return;
                }
                default -> console.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void handleFeedback(Scanner scanner, ConsoleDisplay console, FeedbackManagement feedbackManagement) {
        while (true) {
            console.displayMessage("Feedback and Reviews Menu:");
            console.displayMessage("1. Rate a Program and Trainer");
            console.displayMessage("2. View Submitted Feedback");
            console.displayMessage("3. Go Back");

            int feedbackChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (feedbackChoice) {
                case 1 -> {
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
                }
                case 2 -> feedbackManagement.displayFeedback();
                case 3 -> {
                    console.displayMessage("Returning to Main Menu...");
                    return;
                }
                default -> console.displayMessage("Invalid option. Please try again.");
            }
        }
    }
}
