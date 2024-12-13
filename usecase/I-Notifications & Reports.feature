Feature: Notifications & Reports

  Scenario: Report gym supplies needs to Admin
    Given Instructor logs in to the system
    When Instructor navigates to the Inventory section
    Then Instructor can report missing gym supplies or equipment to Admin

  Scenario: Notify clients about schedule updates
    Given Instructor logs in to the system
    When Instructor updates the schedule for a program
    Then Clients enrolled in the program should receive notifications about the new schedule
