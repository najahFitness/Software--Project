Feature: Program Exploration and Enrollment

  Scenario: User navigates to the Program Exploration menu
    Given the user starts the application
    When the user selects "2. Program Exploration" from the main menu
    Then the system displays the Program Exploration menu options

  Scenario Outline: Filter programs by criteria
    Given the user is on the Program Exploration menu
    When the user selects "Filter Programs by <criteria>" in the Program Exploration menu
    And the user enters "<value>"
    Then the system displays programs matching the "<value>"

    Examples:
      | criteria           | value            |
      | Difficulty Level   | Beginner         |
      | Difficulty Level   | Advanced         |
      | Focus Area         | Weight Loss      |
      | Focus Area         | Flexibility      |

  Scenario: User views the program schedule
    Given the user is on the Program Exploration menu
    When the user selects "View Program Schedule" in the Program Exploration menu
    Then the system displays the program schedule

  Scenario: User exits the Program Exploration menu
    Given the user is on the Program Exploration menu
    When the user selects "Go Back" in the Program Exploration menu
    Then the system returns to the main menu from Program Exploration
