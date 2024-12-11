Feature: Role-Based Redirection After Login

  Scenario: Redirect Admin to Admin Dashboard
    Given Admin logs in to the system
    When the system verifies Admin credentials
    Then Admin is redirected to the Admin Dashboard
    And Admin sees options for managing users, schedules, finances, and system settings

  Scenario: Redirect Instructor to Instructor Dashboard
    Given Instructor logs in to the system
    When the system verifies Instructor credentials
    Then Instructor is redirected to the Instructor Dashboard
    And Instructor sees options for managing clients, training plans, and progress tracking

  Scenario: Redirect Client to Client Dashboard
    Given Client logs in to the system
    When the system verifies Client credentials
    Then Client is redirected to the Client Dashboard
    And Client sees options for viewing training plans, progress tracking, and communication with the instructor
