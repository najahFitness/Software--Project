Feature: Interaction & Motivation

  Scenario: Interact with the Instructor
    Given Client logs in to the system
    When Client navigates to the Messaging section
    Then Client can send messages to their assigned instructor for advice and feedback

  Scenario: Notify clients about schedule updates
    Given Client logs in to the system
    When Client navigates to the Subscription section
    Then Client should receive notifications about any updates to their program schedule

  Scenario: Send motivational messages during workouts
    Given Client logs in to the system
    When Client navigates to the Progress section
    Then Client should receive motivational messages from their instructor during workouts
