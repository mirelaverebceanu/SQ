Feature: Reddit

  Scenario Outline: Search for <element> and logo presence
    Given The chrome browser is launched
    When The reddit web page is opened
    Then Search for "<element>"
    Then Validate the logo presence
    And Close browser

    Examples:
      | element  |
      | computer |
      | art      |