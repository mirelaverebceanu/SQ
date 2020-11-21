Feature: Add a review

  Scenario: Validate add a review to an item functionality
    Given The web page is opened
    When Click on Women's wear drop-down button
    Then Select Women Clothing link text
    Then Hover over the image of any product
    Then Click on QUICK VIEW button
    Then Select the Reviews tab
    Then In the Name box enter a valid name, in the Email box enter a valid email, and in the Message box a message
      | name   | email                      | message      |
      | mirela | verebceanumirela@gmail.com | test message |
    And Click on the Send button
    And Review is added and displayed on UI