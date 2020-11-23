Feature: Add To Chart

  Scenario: Check "ADD TO CART" quantity with invalid data
    Given The web page of Elite Shop is launched
    When Click on the Women's wear drop-down button from the top banner
    Then Select the Women Clothing link text from the list
    Then Click on the ADD TO CART button from any item
    Then Enter in quantity box a letter
    Then Click on cart symbol from ban-top
    Then Check the quantity box