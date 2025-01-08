package healthy.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // استدعاء الكلاسات الجاهزة
        user userLogin = new user();
        SinUp_FromAdmin signUp = new SinUp_FromAdmin();
        updateFromAdmin updater = new updateFromAdmin();
        ApprovingFromAdmin approver = new ApprovingFromAdmin();
        ProgramMonitor programMonitor = new ProgramMonitor();
        ContentManager contentManager = new ContentManager();
        AddNewProgram addNewProgram = new AddNewProgram();




        System.out.println("========== Login System ==========");

        // تسجيل الدخول
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        // استدعاء دالة تسجيل الدخول
        boolean loginSuccessful = userLogin.login(username, password);

        if (loginSuccessful) {
            if (username.startsWith("A")) {
                System.out.println("Login successful! Welcome Admin.");
                displayAdminMenu(scanner, signUp, updater, approver, programMonitor, contentManager);
            }else if (username.startsWith("I")) {
                System.out.println("Login successful! Welcome Instructor.");
                displayInstructorMenu(scanner, addNewProgram);
            }  else if (username.startsWith("I")) {
                System.out.println("Login successful! Welcome Instructor.");
                // لاحقًا سنضيف منيو المدرب
            } else {
                System.out.println("Login successful! Welcome User.");
            }
        } else {
            System.out.println("Login failed! " + userLogin.getStatus());
        }
    }

    // عرض قائمة الأدمن
    private static void displayAdminMenu(Scanner scanner, SinUp_FromAdmin signUp, updateFromAdmin updater,
                                         ApprovingFromAdmin approver, ProgramMonitor programMonitor, ContentManager contentManager) {
        while (true) {
            System.out.println("========== Admin Menu ==========");
            System.out.println("1. Add New Instructor or Client");
            System.out.println("2. Update Existing User");
            System.out.println("3. Approve New Instructor");
            System.out.println("4. View Program Statistics");
            System.out.println("5. Generate Program Report");
            System.out.println("6. Track Program Status");
            System.out.println("7. Manage Feedback and Suggestions");
            System.out.println("8. Manage Subscription Plans");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");


            int choice = Integer.parseInt(scanner.nextLine());


            FeedbackManagement feedbackManagement = new FeedbackManagement();
            SubscriptionManager subscriptionManager = new SubscriptionManager();
            switch (choice) {
                case 1 -> {
                    System.out.println("=== Add New Instructor or Client ===");
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Role (Client/Instructor): ");
                    String role = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    boolean isAdded = signUp.isSinUP(name, role, phoneNumber);

                    System.out.println(isAdded ? "Operation Successful: " + signUp.getStatus()
                            : "Operation Failed: " + signUp.getStatus());
                }
                case 2 -> {
                    System.out.println("=== Update Existing User ===");
                    System.out.print("Enter Registration Number: ");
                    String regNumber = scanner.nextLine();

                    System.out.print("Enter New Name (or press Enter to keep current): ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Phone Number (or press Enter to keep current): ");
                    String newPhoneNumber = scanner.nextLine();

                    System.out.print("Enter New Role (Client/Instructor or press Enter to keep current): ");
                    String newRole = scanner.nextLine();

                    boolean isUpdated = updater.updating(regNumber, newName, null, newPhoneNumber, newRole);

                    System.out.println(isUpdated ? "Update Successful: " + updater.getStatus()
                            : "Update Failed: " + updater.getStatus());
                }
                case 3 -> {
                    System.out.println("=== Approve New Instructor ===");
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter Years of Experience: ");
                    String yearsOfExperience = scanner.nextLine();

                    System.out.print("Enter Job Description: ");
                    String jobDescription = scanner.nextLine();

                    boolean isApproved = approver.addInstructor(name, phoneNumber, yearsOfExperience, jobDescription);

                    System.out.println(isApproved ? "Operation Successful: " + approver.getStatus()
                            : "Operation Failed: " + approver.getStatus());
                }
                case 4 -> {
                    System.out.println("=== View Program Statistics ===");
                    System.out.print("Enter Program Name: ");
                    String programName = scanner.nextLine();
                    String stats = programMonitor.getProgramStatistics(programName);
                    System.out.println(stats);
                }
                case 5 -> {
                    System.out.println("=== Generate Program Report ===");
                    System.out.print("Enter Report Type (Revenue and Attendance/Client Progress): ");
                    String reportType = scanner.nextLine();
                    String report = programMonitor.generateReport(reportType);
                    System.out.println(report);
                }
                case 6 -> {
                    System.out.println("=== Track Program Status ===");
                    System.out.print("Enter Program Name: ");
                    String programName = scanner.nextLine();
                    System.out.print("Enter Program Status (Active/Completed): ");
                    String programStatus = scanner.nextLine();
                    String statusDetails = programMonitor.trackProgramStatus(programStatus, programName);
                    System.out.println(statusDetails);
                }
                case 7 -> manageFeedback(scanner, feedbackManagement);
                case 8 -> manageSubscriptions(scanner, subscriptionManager);
                case 9 -> {
                    System.out.println("Exiting Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void displayInstructorMenu(Scanner scanner, AddNewProgram addNewProgram) {
        while (true) {
            System.out.println("========== Instructor Menu ==========");
            System.out.println("1. Add New Fitness Program");
            System.out.println("2. Delete Fitness Program");
            System.out.println("3. Update Fitness Program");
            System.out.println("4. Interact with Clients");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            DeleteProgram deleteProgram = new DeleteProgram();
            UpdateProgram updateProgram = new UpdateProgram();
            Chating chating=new Chating();
            switch (choice) {

                case 1 -> addFitnessProgram(scanner, addNewProgram);
                case 2 -> deleteFitnessProgram(scanner, deleteProgram);
                case 3 -> updateFitnessProgram(scanner, updateProgram);
                case 4 -> interactWithClients(scanner, chating);
                case 5-> {
                    System.out.println("Exiting Instructor Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageFeedback(Scanner scanner, FeedbackManagement feedbackManagement) {
        while (true) {
            System.out.println("=== Manage Feedback and Suggestions ===");
            System.out.println("1. Add Feedback");
            System.out.println("2. Add Suggestion");
            System.out.println("3. Display All Feedback and Suggestions");
            System.out.println("4. Save Feedback and Suggestions");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("=== Add Feedback ===");
                    System.out.print("Enter Program Name: ");
                    String programName = scanner.nextLine();
                    System.out.print("Enter Program Rating (1-5): ");
                    int rating = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Program Review: ");
                    String review = scanner.nextLine();
                    feedbackManagement.addFeedback(programName, rating, review);
                    System.out.println("Feedback added successfully.");
                }
                case 2 -> {
                    System.out.println("=== Add Suggestion ===");
                    System.out.print("Enter Program Name: ");
                    String programName = scanner.nextLine();
                    System.out.print("Enter Suggestion: ");
                    String suggestion = scanner.nextLine();
                    feedbackManagement.addSuggestion(programName, suggestion);
                    System.out.println("Suggestion added successfully.");
                }
                case 3 -> {
                    System.out.println("=== Display All Feedback and Suggestions ===");
                    String allFeedback = feedbackManagement.displayAllFeedback();
                    System.out.println(allFeedback);
                }
                case 4 -> {
                    System.out.println("=== Save Feedback and Suggestions ===");
                    String saveResult = feedbackManagement.saveFeedbackAndSuggestions();
                    System.out.println(saveResult);
                }
                case 5 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void manageSubscriptions(Scanner scanner, SubscriptionManager subscriptionManager) {
        while (true) {
            System.out.println("=== Manage Subscription Plans ===");
            System.out.println("1. View Current Subscription");
            System.out.println("2. Update Subscription Plan");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("=== View Current Subscription ===");
                    System.out.print("Enter User Type (Client/Instructor): ");
                    String userType = scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    String currentPlan = subscriptionManager.viewSubscription(userType, username);
                    System.out.println("Current Subscription Plan: " + currentPlan);
                }
                case 2 -> {
                    System.out.println("=== Update Subscription Plan ===");
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter New Subscription Plan (Basic/Standard/Premium): ");
                    String newPlan = scanner.nextLine();
                    String updateResult = subscriptionManager.updateSubscription(username, newPlan);
                    System.out.println(updateResult);
                }
                case 3 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void addFitnessProgram(Scanner scanner, AddNewProgram addNewProgram) {
        System.out.println("=== Add New Fitness Program ===");

        System.out.print("Enter Program Title: ");
        String programTitle = scanner.nextLine();

        System.out.print("Enter Duration (e.g., 4 months): ");
        String duration = scanner.nextLine();

        System.out.print("Enter Difficulty Level (Easy/Medium/Hard): ");
        String difficultyLevel = scanner.nextLine();

        System.out.print("Enter Goals: ");
        String goals = scanner.nextLine();

        System.out.print("Enter Price: ");
        String price = scanner.nextLine();

        System.out.print("Enter Schedule (e.g., Online, Monday 5pm): ");
        String schedule = scanner.nextLine();

        boolean success = addNewProgram.addFitnessProgram(programTitle, duration, difficultyLevel, goals, price, schedule);

        if (success) {
            System.out.println("Program added successfully!");
        } else {
            System.out.println("Failed to add program: " + addNewProgram.getStatus());
        }
    }
    private static void deleteFitnessProgram(Scanner scanner, DeleteProgram deleteProgram) {
        System.out.println("=== Delete Fitness Program ===");

        System.out.print("Enter Program Title to Delete: ");
        String programTitle = scanner.nextLine();

        boolean success = deleteProgram.deleteFitnessProgram(programTitle);

        if (success) {
            System.out.println("Program deleted successfully!");
        } else {
            System.out.println("Failed to delete program: " + deleteProgram.getStatus());
        }
    }
    private static void updateFitnessProgram(Scanner scanner, UpdateProgram updateProgram) {
        System.out.println("=== Update Fitness Program ===");

        System.out.print("Enter Program Title: ");
        String programTitle = scanner.nextLine();

        System.out.print("Enter New Duration (leave blank to keep current): ");
        String duration = scanner.nextLine();

        System.out.print("Enter New Difficulty Level (leave blank to keep current): ");
        String difficultyLevel = scanner.nextLine();

        System.out.print("Enter New Goals (leave blank to keep current): ");
        String goals = scanner.nextLine();

        System.out.print("Enter New Price (leave blank to keep current): ");
        String price = scanner.nextLine();

        System.out.print("Enter New Schedule (leave blank to keep current): ");
        String schedule = scanner.nextLine();

        boolean success = updateProgram.updateProgram(programTitle, duration, difficultyLevel, goals, price, schedule);

        if (success) {
            System.out.println("Program updated successfully!");
        } else {
            System.out.println("Failed to update program: " + updateProgram.getStatus());
        }
    }
    private static void interactWithClients(Scanner scanner, Chating chating) {
        System.out.println("=== Enhanced Client Interaction ===");

        System.out.print("Enter message to the client (or press Enter to skip): ");
        String messageContent = scanner.nextLine();

        System.out.print("Enter discussion comment (or press Enter to skip): ");
        String discussionComment = scanner.nextLine();

        System.out.print("Enter feedback (or press Enter to skip): ");
        String feedback = scanner.nextLine();

        System.out.print("Enter progress report (or press Enter to skip): ");
        String progressReport = scanner.nextLine();

        // التحقق إذا كان أي من المدخلات غير فارغ
        if (messageContent.isEmpty() && discussionComment.isEmpty() && feedback.isEmpty() && progressReport.isEmpty()) {
            System.out.println("No interaction was provided.");
            return;
        }

        // إرسال الرسالة وإدارة الحالة
        boolean success = chating.addClientMessage(
                messageContent.isEmpty() ? "No message provided" : messageContent,
                discussionComment.isEmpty() ? "No discussion comment provided" : discussionComment,
                feedback.isEmpty() ? "No feedback provided" : feedback,
                progressReport.isEmpty() ? "No progress report provided" : progressReport
        );

        if (success) {
            System.out.println("Client interaction completed successfully!");
        } else {
            System.out.println("Failed to complete client interaction: " + chating.getStatus());
        }
    }
}
