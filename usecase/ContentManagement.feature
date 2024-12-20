Feature: Content Management

  Scenario Outline: Manage wellness content and user feedback
    Given the admin is logged into the content management system
    When the admin reviews a shared article titled '<contentTitle>'
    And the admin decides to '<action>' the content
    Then the system should confirm that the content is '<expectedResult>'
    And the admin should be able to handle user feedback or complaints titled '<feedbackTitle>'

    Examples:
      | contentTitle                  | action     | expectedResult          | feedbackTitle                |
      | Wellness Tips for Beginners  | approve    | approved successfully   | Issue with wellness article  |
      | Healthy Recipes for Kids     | reject     | rejected successfully   | Complaints about recipes     |
      | Daily Yoga Tips              | approve    | approved successfully   | Feedback on yoga content     |
      | Seasonal Diet Tips           | reject     | rejected successfully   | Issue with seasonal tips     |