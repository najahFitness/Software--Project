Feature:  Update fitness program
  Scenario Outline: Update fitness program scenarios
    Given admin is logged in to the system for updating new fitness programs
    When admin fills in 'programtitle' with '<programtitle>' for updating
    And admin fills in 'duration' with '<duration>' for updating
    And admin fills in 'difficultylevel' with '<difficultylevel>' for updating
    And admin fills in 'goals' with '<goals>' for updating
    And admin fills in 'price' with '<price>' for updating
    And admin sets 'schedule' to '<schedule>' for group sessions updating
    And admin clicks on Update Program
    Then admin should see '<message>' for update opration

    Examples:
      | programtitle          | duration | difficultylevel | goals                              | price | schedule          | message                    |
      | Beginner Program      | 8 months| hard            | Improve basic fitness and stamina   | 300   | Online, Monday 7pm | Program updated successfully |
      | Advanced Strength     | 3 months |           | Build strength and muscle mass      | 100   | In-person, Wed 6pm | Program updated successfully |
      | Yoga for Relaxation   | 1 month  |         | Improve flexibility and relaxation  | 30    | Online, Saturday 9am | Program updated successfully |
      | Weight Loss Program   | 2 months | Mediuhardm          | Lose weight and tone body          | 90   | | Program updated successfully  |
      | Intro to Fitness      | 1 week   | Easy            |  Lose weight and tone body            | 25    | Online, Friday 4pm | Program updated successfully |
