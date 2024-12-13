Feature: Evaluation & Challenges

  Scenario: Evaluate instructor and training quality
    Given Client logs in to the system
    When Client navigates to the Feedback section
    Then Client can rate their instructor and provide feedback on the training quality

  Scenario: Participate in challenges and competitions
    Given Client logs in to the system
    When Client navigates to the Challenges section
    Then Client can view and participate in available fitness challenges or competitions

  Scenario: View subscription details and payments
    Given Client logs in to the system
    When Client navigates to the Subscription section
    Then Client can view subscription status, renewal dates, and outstanding payments
    And Client can view dietary needs and daily regimen
