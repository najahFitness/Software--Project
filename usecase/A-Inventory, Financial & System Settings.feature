Feature: Inventory, Financial & System Settings

  Scenario: Receive info from instructors on protein shortages and equipment needs
    Given Admin logs in to the system
    When Admin navigates to the Inventory Management section
    Then Admin receives information from instructors on protein shortages or equipment needs
    And Admin can order replacements or new equipment

  Scenario: Financial Management
    Given Admin logs in to the system
    When Admin navigates to the Financial Management section
    Then Admin can view and manage financial data, including subscription payments and outstanding fees

  Scenario: System settings management
    Given Admin logs in to the system
    When Admin navigates to the System Settings section
    Then Admin can configure system preferences, notifications, and other settings
