
Feature:  Add new fitness program
  Scenario Outline: Add new fitness program scenarios
Given admin is logged in to the system for adding new fitness programs
When admin fills in 'programtitle' with '<programtitle>' for addition
And admin fills in 'duration' with '<duration>' for addition
And admin fills in 'difficultylevel' with '<difficultylevel>' for addition
And admin fills in 'goals' with '<goals>' for addition
And admin fills in 'price' with '<price>' for addition
And admin sets 'schedule' to '<schedule>' for group sessions addition
And admin clicks on Add Program
Then admin should see '<message>'

Examples:
| programtitle          | duration | difficultylevel | goals                              | price | schedule          | message                    |
| Beginner Program      |  4months | Easy            | Improve basic fitness and stamina   | 50    | Online, Monday 5pm | Program added successfully |
| Advanced Strength     | 3 months | Hard            | Build strength and muscle mass      | 100   | In-person, Wed 6pm | Program added successfully  |
| Yoga for Relaxation   | 1 month  | Medium          | Improve flexibility and relaxation  | 30    | Online, Saturday 10am | Program added successfully  |
| Weight Loss Program   | 2 months | Medium          | Lose weight and tone body          | 60    | In-person, Monday 7pm | Program added successfully  |
| Intro to Fitness      | 1 week   | Easy            |       Lose weight and tone body        | 25    | Online, Friday 4pm | Program added successfully |
