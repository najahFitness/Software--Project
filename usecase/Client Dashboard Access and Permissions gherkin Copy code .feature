Feature: Client Dashboard Access and Permissions

  Scenario: View and track personal training plan
    Given Client logs in to the system
    When Client navigates to the Training Plan section
    Then Client can view their personalized training plan and follow the daily exercises

  Scenario: Track personal progress
    Given Client logs in to the system
    When Client navigates to the Progress section
    Then Client can view their progress, completed workouts, and improvements

  Scenario: Interact with the Instructor
    Given Client logs in to the system
    When Client navigates to the Messaging section
    Then Client can send messages to their assigned instructor for advice and feedback

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

  Scenario: Notify clients about subscription renewal
    Given Client logs in to the system
    When Client navigates to the Subscription section
    Then Client should receive a notification about the upcoming subscription renewal date
    And Client should be able to view the payment status and outstanding amount
