Feature: Feedback and Reviews Management

  Scenario Outline: User rates a program and provides suggestions
    Given the user has completed the program "<programName>"
    When the user rates the program with "<programRating>" stars
    And the user submits a review: "<programReview>"
    And the user provides an improvement suggestion: "<suggestion>"
    Then the system saves the rating, review, and suggestion successfully

    Examples:
      | programName        | programRating | programReview                     | suggestion                       |
      | Yoga for Beginners | 5             | Excellent program, very helpful  | Add more meditation sessions     |
      | Strength Training  | 4             | Good program, but tough schedule | Adjust the schedule for beginners|
      | Zumba Express      | 3             | Average program, needs updates   | Include more music variety       |
