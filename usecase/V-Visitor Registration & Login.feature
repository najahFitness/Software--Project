Feature: Visitor Registration & Login

  Scenario: Sign up for an account as a visitor
    Given the user is on the homepage
    When the user clicks on the "Sign Up" button
    Then the user should be directed to the registration page
    And the user should be able to fill out personal details to create a new account

  Scenario: Log in as an existing user
    Given the user is on the homepage
    When the user clicks on the "Login" button
    Then the user should be directed to the login page
    And the user should be able to enter credentials to log into their account
