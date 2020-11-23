Feature: Quick View

  Scenario: Validate that Quick View returns the right element
    Given The shop web page is opened
    When Click on Women section dropdown
    Then Click on Women Clothing option
    Then Select one of the products
    And Click on Quick View button on the selected element
    Then Validate that the name of returned product is the same as for requested one