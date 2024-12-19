Feature: Account Management

  Scenario: User navigates to the Account Management menu
    Given the user starts the application
    When the user selects "1. Account Management" from the main menu
    Then the system displays the Account Management menu options

  Scenario Outline: User customizes their profile
    Given the user is on the Account Management menu
    When the user selects "Customize Profile" in the Account Management menu
    And the user enters "<field>" as "<value>"
    Then the system saves the "<field>" successfully

    Examples:
      | field                | value            |
      | Age                  | 30               |
      | Fitness Goal         | Weight Loss      |
      | Dietary Preference   | Vegan            |
      | Fitness Goal         | Muscle Building  |

  Scenario: User exits Account Management menu
    Given the user is on the Account Management menu
    When the user selects "Go Back" in the Account Management menu
    Then the system returns to the main menu from Account Management

