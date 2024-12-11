Feature: Admin Dashboard Access and Permissions

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

  Scenario: Financial Management
    Given Admin logs in to the system
    When Admin navigates to the Financial Management section
    Then Admin can view and manage financial data, including subscription payments and outstanding fees

  Scenario: Manage instructor and client schedules
    Given Admin logs in to the system
    When Admin navigates to the Schedule Management section
    Then Admin can create and update the schedules for instructors and clients

  Scenario: Generate reports on client progress and trainer performance
    Given Admin logs in to the system
    When Admin navigates to the Reports section
    Then Admin can generate reports on client progress and trainer performance

  Scenario: System settings management
    Given Admin logs in to the system
    When Admin navigates to the System Settings section
    Then Admin can configure system preferences, notifications, and other settings

  Scenario: Monitor protein shortages and equipment needs
    Given Admin logs in to the system
    When Admin navigates to the Inventory Management section
    Then Admin can monitor protein shortages and equipment needs
    And Admin can order replacements or new equipment

  Scenario: Manage subscriptions and payments
    Given Admin logs in to the system
    When Admin navigates to the Payment Management section
    Then Admin can view outstanding payments and generate invoices for clients and instructors
