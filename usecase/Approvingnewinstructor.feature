Feature: Approve New Gym Instructor Registrations
  Scenario Outline: Approval of new gym instructor registrations
    Given Admin is on the registration requests page
    When admin views the registration request for 'name' with '<name>' with registration details
    And admin checks the registration details for 'phone_number' with '<phone_number>'
    And admin verifies 'years_of_experience' has valid number of years of experience with '<years_of_experience>'
    And admin reads the job description for 'job_description' with description '<job_description>'
    And admin clicks on approve for login
    Then user should see '<message>' for Appproving

    Examples:
      | name   | phone_number| years_of_experience|message | job_description                                 |
      |maher   | 0597571210  | 5y |Accepted  |Certified fitness instructor specializing in strength training and bodybuilding |
      |Farah   | 0597412560  | 3y |   unacceptable  |               |
      |Juwan   | 0563255582  | 2y |  Accepted   |Yoga and pilates instructor focusing on flexibility and posture improvement |
      |Mohammad|   | 7y |   unacceptable  |Experienced trainer specializing in weight loss and muscle toning programs |
