Feature: Instructor Dashboard Access and Permissions

  Scenario: Assign training plans to clients
    Given Instructor logs in to the system
    When Instructor navigates to the Client Management section
    Then Instructor can view assigned clients and assign personalized training plans

  Scenario: Track client progress
    Given Instructor logs in to the system
    When Instructor navigates to the Progress Tracking section
    Then Instructor can view each client's progress, performance, and achievements

  Scenario: Provide feedback on client performance
    Given Instructor logs in to the system
    When Instructor navigates to the Client Feedback section
    Then Instructor can provide feedback on client performance and improvements

  Scenario: Communicate with clients
    Given Instructor logs in to the system
    When Instructor navigates to the Messaging section
    Then Instructor can send messages to clients for guidance, updates, or clarifications

  Scenario: Report equipment or protein shortages to Admin
    Given Instructor logs in to the system
    When Instructor navigates to the Inventory section
    Then Instructor can report missing equipment or protein shortages to the Admin

  Scenario: Notify clients about schedule changes
    Given Instructor logs in to the system
    When Instructor updates the schedule for a program
    Then Clients enrolled in the program should receive notifications about the new schedule

  Scenario: Send personalized progress reports to clients
    Given Instructor logs in to the system
    When Instructor navigates to the Client Progress section
    Then Instructor can send personalized progress reports to clients including feedback and recommendations
