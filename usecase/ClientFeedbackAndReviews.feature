Feature: Feedback and Reviews

  Scenario Outline: User rates the program and trainer with reasons
    Given the user has completed a program
    When the user rates the program with "<programRating>" stars in Feedback and Reviews
    And the user rates the trainer with "<trainerRating>" stars in Feedback and Reviews
    And the user provides reasons:
      | aspect  | reason            |
      | Program | "<programReason>" |
      | Trainer | "<trainerReason>" |
    Then the system saves the ratings and reasons successfully in Feedback and Reviews

    Examples:
      | programRating | trainerRating | programReason                   | trainerReason              |
      | 5             | 5             | Excellent content and structure | Very interactive and clear |
      | 4             | 5             | Great content but too fast      | Very supportive            |
      | 3             | 4             | Average content, needs updates  | Good but sometimes unclear |

  Scenario: User views submitted feedback
    Given the user is on the Feedback and Reviews menu
    When the user selects "View Submitted Feedback" in Feedback and Reviews
    Then the system displays all feedback successfully

  Scenario: User exits the Feedback and Reviews menu
    Given the user is on the Feedback and Reviews menu
    When the user selects "Go Back" in Feedback and Reviews
    Then the system returns to the main menu from Feedback and Reviews

