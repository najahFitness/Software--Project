Feature: Limited Access for Visitors

  Scenario: View limited access for visitors
    Given the user is on the homepage
    When the user tries to view detailed training plans or enroll in a program
    Then the user should be prompted to sign up or log in to access these features

  Scenario: Redirect to a sign-up page for full access
    Given the user is a visitor trying to access advanced features
    When the user attempts to enroll in a program or view personalized content
    Then the user should be redirected to the registration page to create an account
