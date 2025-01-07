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
        FeedbackManagement feedbackManagement = new FeedbackManagement();
        SubscriptionManager subscriptionManager = new SubscriptionManager();
        AddNewProgram addNewProgram = new AddNewProgram(); // لإضافة البرامج
        DeleteProgram deleteProgram = new DeleteProgram(); // لحذف البرامج
        UpdateProgram updateProgram = new UpdateProgram(); // لتحديث البرامج
        AccountManagement accountManagement = new AccountManagement(); // لإدارة الحسابات
        ProgramManagement programManagement = new ProgramManagement();
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
                displayAdminMenu(scanner, signUp, updater, approver, programMonitor, contentManager, feedbackManagement, subscriptionManager, addNewProgram, deleteProgram, updateProgram);
            } else if (username.startsWith("C")) {
                System.out.println("Login successful! Welcome Client.");
                displayClientMenu(scanner, accountManagement, programManagement);

            } else {
                System.out.println("Login successful! Welcome User.");
            }
        } else {
            System.out.println("Login failed! " + userLogin.getStatus());
        }
    }

    // عرض قائمة الأدمن
    private static void displayAdminMenu(Scanner scanner, SinUp_FromAdmin signUp, updateFromAdmin updater,
                                         ApprovingFromAdmin approver, ProgramMonitor programMonitor,
                                         ContentManager contentManager, FeedbackManagement feedbackManagement,
                                         SubscriptionManager subscriptionManager, AddNewProgram addNewProgram,
                                         DeleteProgram deleteProgram, UpdateProgram updateProgram) {
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
            System.out.println("9. Add New Fitness Program");
            System.out.println("10. Delete Fitness Program");
            System.out.println("11. Update Fitness Program");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 7 -> manageFeedback(scanner, feedbackManagement);
                case 8 -> manageSubscriptions(scanner, subscriptionManager);
                case 9 -> addFitnessProgram(scanner, addNewProgram);
                case 10 -> deleteFitnessProgram(scanner, deleteProgram);
                case 11 -> updateFitnessProgram(scanner, updateProgram);
                case 12 -> {
                    System.out.println("Exiting Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // قائمة العميل
    private static void displayClientMenu(Scanner scanner, AccountManagement accountManagement, ProgramManagement programManagement) {
        while (true) {
            System.out.println("========== Client Menu ==========");
            System.out.println("1. Create and Customize Profile");
            System.out.println("2. Explore and Enroll in Programs");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> createAndCustomizeProfile(scanner, accountManagement);
                case 2 -> exploreAndEnrollInPrograms(scanner, programManagement);
                case 3 -> {
                    System.out.println("Exiting Client Menu...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // وظيفة إضافة برنامج لياقة بدنية
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

    // وظيفة حذف برنامج لياقة بدنية
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

    // وظيفة تحديث برنامج لياقة بدنية
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

    // إدارة Feedback
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

    // إدارة الاشتراكات
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
    private static void exploreAndEnrollInPrograms(Scanner scanner, ProgramManagement programManagement) {
        System.out.println("=== Explore and Enroll in Programs ===");

        System.out.print("Enter Difficulty Level (Beginner, Intermediate, Advanced): ");
        String difficultyLevel = scanner.nextLine();

        System.out.print("Enter Focus Area (e.g., Weight loss, Muscle building, Flexibility): ");
        String focusArea = scanner.nextLine();

        // تصفية البرامج بناءً على الفلاتر
        programManagement.filterPrograms(difficultyLevel, focusArea);

        // طلب إدخال عنوان البرنامج للتسجيل
        System.out.print("Enter Program Title to Enroll: ");
        String programTitle = scanner.nextLine();

        // محاولة التسجيل في البرنامج
        String enrollmentResult = programManagement.enrollInProgram(programTitle);

        // عرض النتيجة
        System.out.println(enrollmentResult);

        // التأكيد على التسجيل إذا كان ناجحًا
        if (enrollmentResult.equals("Enrollment successful")) {
            String confirmationResult = programManagement.confirmEnrollment(programTitle);
            System.out.println(confirmationResult);
        }
    }

    // وظيفة إنشاء وتخصيص الملف الشخصي
    private static void createAndCustomizeProfile(Scanner scanner, AccountManagement accountManagement) {
        System.out.println("=== Create and Customize Profile ===");

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Weight (kg): ");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Height (cm): ");
        int height = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Fitness Goals: ");
        String fitnessGoals = scanner.nextLine();

        System.out.print("Enter Dietary Preferences (leave blank for None): ");
        String dietaryPreferences = scanner.nextLine();

        // استدعاء كلاس إدارة الحساب لإنشاء الملف الشخصي
        String result = accountManagement.createProfile(age, weight, height, fitnessGoals, dietaryPreferences.isEmpty() ? "None" : dietaryPreferences);

        // عرض النتيجة للمستخدم
        System.out.println(result);
    }
}
