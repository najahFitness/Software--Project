Feature: Notifications and Updates
  Scenario Outline: Notify clients about lesson rescheduling and special discounts
    Given the admin is logged into the system to notify clients about updates
    When the admin notifies the client about the rescheduling of the lesson '<lessonName>' to '<newTime>'
    And the admin informs the client about a special discount or offer '<discountOffer>'
    Then the client should receive '<expectedMessage>' confirming the publication was successful

    Examples:
      | lessonName          | newTime     | discountOffer                                 | expectedMessage                                                                 |
      | Yoga class          | 8:00 AM     | 20% discount on monthly subscriptions         | The lesson Yoga class has been rescheduled to 8:00 AM. Special offer: 20% discount on monthly subscriptions. |
      | Zumba session       | 7:00 PM     | Get one free session with your subscription   | The lesson Zumba session has been rescheduled to 7:00 PM. Special offer: Get one free session with your subscription. |
      | Pilates lesson      | 6:00 PM     | Summer discounts on group training packages   | The lesson Pilates lesson has been rescheduled to 6:00 PM. Special offer: Summer discounts on group training packages. |