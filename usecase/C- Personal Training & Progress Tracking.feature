Feature: Personal Training & Progress Tracking

  Scenario: View and track personal training plan
    Given Client logs in to the system
    When Client navigates to the Training Plan section
    Then Client can view their personalized training plan and follow the daily exercises

  Scenario: Track personal progress
    Given Client logs in to the system
    When Client navigates to the Progress section
    Then Client can view their progress, completed workouts, and improvements
