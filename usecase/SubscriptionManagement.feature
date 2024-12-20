Feature: Subscription Management

  Scenario Outline: Manage subscription plans for clients and instructors
    Given the admin is logged into the subscription management system
    When the admin views the current subscription plan for '<userType>' with username '<username>'
    And the admin changes the subscription plan to '<newPlan>'
    Then the system should confirm that the subscription plan for '<username>' is updated to '<expectedPlan>'

    Examples:
      | userType    | username          | newPlan  | expectedPlan |
      | Client      | john_doe          | Premium  | Premium      |
      | Instructor  | jane_instructor   | Basic    | Basic        |
      | Client      | emma_client       | Standard | Standard     |
      | Instructor  | mark_instructor   | Premium  | Premium      |
