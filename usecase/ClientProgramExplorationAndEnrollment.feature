Feature: Program Exploration and Enrollment

  Scenario Outline: Explore programs and enroll based on filters
    Given the client is logged into the system to explore programs
    When the client browses programs by difficulty level '<difficultyLevel>'
    And the client selects a program titled '<programTitle>' for enrollment
    And the client confirms the enrollment
    Then the system should confirm '<confirmationMessage>' for the enrollment

    Examples:
      | difficultyLevel | programTitle          | confirmationMessage          |
      | Beginner        | Intro to Weight Loss  | Enrollment successful        |
      | Intermediate    | Strength Bootcamp     | Enrollment successful        |
      | Advanced        | Advanced Yoga Program | Enrollment successful        |
      | Beginner        | Beginner Fitness Plan | Enrollment successful        |

  Scenario Outline: Explore programs by focus area and enroll
    Given the client is logged into the system to explore programs
    When the client browses programs by focus area '<focusArea>'
    And the client selects a program titled '<programTitle>' for enrollment
    And the client confirms the enrollment
    Then the system should confirm '<confirmationMessage>' for the enrollment

    Examples:
      | focusArea           | programTitle          | confirmationMessage          |
      | Weight loss         | Intro to Weight Loss  | Enrollment successful        |
      | Muscle building     | Strength Bootcamp     | Enrollment successful        |
      | Flexibility         | Advanced Yoga Program | Enrollment successful        |
      | General fitness     | Beginner Fitness Plan | Enrollment successful        |
