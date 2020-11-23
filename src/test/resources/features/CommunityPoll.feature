Feature: Community Poll

  Scenario: Validate that "COMMUNITY POLL" selected checkbox is updated
    Given The page is opened
    When Click on the Women's wear dropdown button from the top banner
    Then Select Women Clothing link text from the list
    Then Click on any non selected radio button
    Then Click the SEND button
    And Validate that the COMMUNITY POLL is updated