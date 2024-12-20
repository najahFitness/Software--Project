Feature: Client Interaction
  Scenario Outline: Communicate with clients and provide feedback or progress reports
    Given the admin is logged into the system to interact with clients
    When the admin sends a message to the client 'messageContent' with '<messageContent>' for chating
    And the admin posts a discussion forum comment 'discussionComment' with '<discussionComment>'  for chating
    And the admin provides feedback 'feedback'  with '<feedback>'  for chating
    And the admin prepares a progress report 'progressReport' with '<progressReport>'  for chating
    And the admin sends the progress report to the client
    Then the client should receive  '<confirmationMessage>'  for chating

    Examples:
      | messageContent                      | discussionComment                          | feedback                                     | progressReport                             | confirmationMessage            |
      | Welcome to the fitness program      | Please share your current fitness goals   | You have shown great progress in your exercises! | You have completed the first week with eighty percent of the tasks | The client has been notified successfully |
      | You are performing excellently      | How has your experience been so far?      | It is recommended to increase your daily step count. | You have completed the first month with ninety-five percent of the tasks | The client has been notified successfully |
      | Please stay consistent in your work | What challenges are you facing right now? | Your consistency this week has been amazing! | You have completed the third week with all tasks finished |  The client has been notified successfully   |