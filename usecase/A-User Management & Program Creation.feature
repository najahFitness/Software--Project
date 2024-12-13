Feature: User Management & Program Creation

  Scenario: Manage user accounts
    Given Admin logs in to the system
    When Admin navigates to the User Management section
    Then Admin can view and manage accounts for instructors and clients
    And Admin can create, update, or delete user accounts

  Scenario: Assign clients to instructors
    Given Admin logs in to the system
    When Admin navigates to the Client Management section
    Then Admin can assign clients to specific instructors

  Scenario: Create training and diet plans
    Given Admin logs in to the system
    When Admin navigates to the Program Management section
    Then Admin can create new training and diet plans for clients
