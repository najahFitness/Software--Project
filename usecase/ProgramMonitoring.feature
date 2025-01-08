Feature: Program Monitoring

  Scenario Outline: Monitor statistics, revenue, and program tracking
    Given the admin is logged into the system to monitor program performance
    When the admin views the statistics for the most popular programs by enrollment '<programName>'
    And the admin generates a report on '<reportType>' for the program
    And the admin tracks the status of the program as '<programStatus>'
    Then the system should display '<expectedResult>' for the selected program

    Examples:
      | programName        | reportType               | programStatus       | expectedResult                                                                                 |
      | A| Revenue and Attendance   | Active              | The Yoga for Beginners program has high enrollment, with $5000 revenue and 85% attendance.    |
      | Zumba Express      | Client Progress          | Completed           | The Zumba Express program is completed. Average client progress is 90% goal achievement.      |
      | Strength Training  | Revenue and Attendance   | Active              | The Strength Training program has steady enrollment, with $3500 revenue and 75% attendance.   |
      | Pilates Plus       | Client Progress          | Completed           | The Pilates Plus program is completed. Average client progress is 95% goal achievement.       |