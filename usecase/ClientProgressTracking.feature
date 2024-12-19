Feature: Progress Tracking

  Scenario: User navigates to the Progress Tracking menu
    Given the user starts the application for Progress Tracking
    When the user selects "3. Progress Tracking" from the main menu
    Then the system displays the Progress Tracking menu options

  Scenario Outline: View fitness milestones
    Given the user is on the Progress Tracking menu
    When the user selects "View Current Progress" in the Progress Tracking menu
    And the user views "<metric>"
    Then the system displays the "<metric>" correctly

    Examples:
      | metric     |
      | Weight     |
      | BMI        |
      | Attendance |

  Scenario: User views achievements and badges
    Given the user is on the Progress Tracking menu
    When the user selects "View Achievements and Badges" in the Progress Tracking menu
    Then the system displays the achievements and badges

  Scenario: User exits the Progress Tracking menu
    Given the user is on the Progress Tracking menu
    When the user selects "Go Back" in the Progress Tracking menu
    Then the system returns to the main menu from Progress Tracking
