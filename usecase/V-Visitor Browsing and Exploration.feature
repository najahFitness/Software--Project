Feature: Visitor Browsing and Exploration

  Scenario: View available fitness programs as a visitor
    Given the user is on the homepage
    When the user navigates to the Programs section
    Then the user should be able to browse and view available fitness programs
    And the user should see basic information about each program (e.g., title, description, and focus area)

  Scenario: View fitness articles and wellness tips as a visitor
    Given the user is on the homepage
    When the user navigates to the Articles and Tips section
    Then the user should be able to browse and view wellness articles and tips
    And the user should be able to read article summaries
