Feature: Update Information from Admin

  Scenario Outline: Update scenarios
    Given admin is logged in to the system for updating
    When admin fills in 'registernumber' with '<registernumber>' for update
    And admin fills in 'name' with '<name>' for update
    And admin fills in 'password' with '<password>' for update
    And admin fills in 'phonenumber' with '<phonenumber>' for update
    And admin fills in 'role' with '<role>' for update
    And admin clicks on "Update"
    Then admin should see '<message>' for current status


    Examples:
      | registernumber | name | password| phonenumber   | role        | message           |
      | A1000          | Ali  | a123    | 1234567890    | Client      | Update successful |
      | C1000          | Nimer|pass12345| 9876543210    | Instructor  | Update successful|
      | I1000          |Jamila| pass123 |               | Client      | Update successful |
      | B2001          | Sarah|pass560  | 5558889999    | Instructor  | Update failed     |
      |                |omar  |pass98765| 2223334444    | Client      | Update failed     |
