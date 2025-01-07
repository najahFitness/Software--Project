Feature: Client Account Management

  Scenario Outline: Create and customize client profiles with enhanced details
    Given the client is logged into the system to manage their account
    When the client enters personal details with <age>, <weight>, and <height>
    And the client specifies fitness goals as '<fitnessGoals>'
    And the client specifies dietary preferences or restrictions as '<dietaryPreferences>'
    And the client saves their profile
    Then the system should confirm '<confirmationMessage>' for the profile creation

    Examples:
      | age | weight | height | fitnessGoals               | dietaryPreferences       | confirmationMessage               |
      | 25  | 70     | 175    | Build muscle               | High protein             | Profile created successfully      |
      | 30  | 85     | 180    | Lose weight                | Vegan                    | Profile created successfully      |
      | 35  | 68     | 160    | Maintain current fitness   | Gluten-free              | Profile created successfully      |
      | 28  | 75     | 170    | Improve stamina            | None                     | Profile created successfully      |
