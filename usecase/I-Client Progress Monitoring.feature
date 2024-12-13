Feature: Client Progress Monitoring

  Scenario: Track client progress and attendance
    Given Instructor logs in to the system
    When Instructor navigates to the Progress Tracking section
    Then Instructor can view each client's progress and attendance

  Scenario: Send motivational messages during workouts
    Given Instructor logs in to the system
    When Instructor navigates to the Messaging section
    Then Instructor can send motivational messages to clients during their workouts
