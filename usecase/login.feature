Feature: Login
  Scenario Outline: login scenarios
    Given user is connected to the database
    When he fills in 'registernumber' with '<registernumber>' for login
    And he fills in 'password' with '<password>' for login
    And user clicks on login
    Then user should see '<message>' for login


    Examples:
      | registernumber  | password   | message                     |
      | A1000           | ali123     | Valid username and password |
      | C1000           | nimer123   | Valid username and password |
      | C1000           | jamila123       | Invalid username or password|
      |                 | 12de456    | Invalid username or password|
      | A1001           |            | Invalid username or password|