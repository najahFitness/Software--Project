Feature: Schedule & Reports Management

  Scenario: Manage instructor and client schedules
    Given Admin logs in to the system
    When Admin navigates to the Schedule Management section
    Then Admin can create and update the schedules for instructors and clients

  Scenario: Generate reports on client progress and trainer performance
    Given Admin logs in to the system
    When Admin navigates to the Reports section
    Then Admin can generate reports on client progress and trainer performance
