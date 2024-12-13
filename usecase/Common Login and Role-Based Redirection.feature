Feature: General Login and Role-Based Redirection

  Scenario: Successful login as Admin
    Given the user is on the login page
    When the user enters valid credentials for an Admin account
    Then the user should be redirected to the Admin Dashboard
    And the user should see options for user management, financial management, reports, and system settings

  Scenario: Successful login as Instructor
    Given the user is on the login page
    When the user enters valid credentials for an Instructor account
    Then the user should be redirected to the Instructor Dashboard
    And the user should see options for managing clients, training plans, and client progress

  Scenario: Successful login as Client
    Given the user is on the login page
    When the user enters valid credentials for a Client account
    Then the user should be redirected to the Client Dashboard
    And the user should see options for viewing training plans, tracking personal progress, and interacting with the instructor

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then an error message should be displayed indicating incorrect login details

  Scenario: Unsuccessful login due to missing credentials
    Given the user is on the login page
    When the user does not fill in the required login fields
    Then an error message should be displayed indicating that credentials are missing
