Feature: Program Exploration and Enrollment

  Scenario Outline: Explore programs and enroll based on filters
    Given the client is logged into the system to explore programs
    When the client browses programs with difficulty level '<difficultyLevel>' and focus area '<focusArea>'
    And the client selects a program titled '<programTitle>' for enrollment
    And the client confirms the enrollment
    Then the system should confirm '<confirmationMessage>' for the enrollment

    Examples:
      | difficultyLevel | focusArea           | programTitle          | confirmationMessage          |
      | Beginner        | Weight loss         | Intro to Weight Loss  | Enrollment successful        |
      | Intermediate    | Muscle building     | Strength Bootcamp     | Enrollment successful        |
      | Advanced        | Flexibility         | Advanced Yoga Program | Enrollment successful        |
      | Beginner        | General fitness     | Beginner Fitness Plan | Enrollment successful        |
