Feature: Enhanced Client Interaction

  Scenario Outline: Validate client interaction scenarios with multiple inputs
    Given the admin is logged into the system to interact with clients
    When the admin sends a message to the client 'messageContent' with '<messageContent>' for chating
    And the admin posts a discussion forum comment 'discussionComment' with '<discussionComment>' for chating
    And the admin provides feedback 'feedback' with '<feedback>' for chating
    And the admin prepares a progress report 'progressReport' with '<progressReport>' for chating
    And the admin sends the progress report to the client
    Then the client should receive '<confirmationMessage>' for chating

    Examples:
      | messageContent                | discussionComment                | feedback                      | progressReport              | confirmationMessage                     |
      | Welcome to the program        | What are your fitness goals?     | Excellent progress!           | 90% of tasks completed      | The client has been notified successfully |
      | Please stay consistent        | Are you enjoying the program?    | Amazing performance!          | 100% tasks completed        | The client has been notified successfully |
      | Focus on your nutrition       | Any difficulties?                | Consider meal planning tips.  | Progress pending review     | The client has been notified successfully |
