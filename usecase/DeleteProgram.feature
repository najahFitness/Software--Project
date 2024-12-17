
Feature:  Delete new fitness program
  Scenario Outline: Add new fitness program scenarios
    Given admin is logged in to the system for deleting new fitness programs
    When admin fills in 'programtitle' with '<programtitle>' for deleting
    And admin clicks on Delete Program
    Then admin should see after deleting '<message>'

    Examples:
      | programtitle         | message                    |
      |    | You must provide the program title to delete          |
      | Advanced Strength    | Program deleted successfully|
      | Yoga for Relaxation  | Program deleted successfully|
      |   | You must provide the program title to delete|
      | Intro to Fitness     |  You must provide the program title to delete            |
