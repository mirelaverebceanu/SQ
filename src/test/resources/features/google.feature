Feature: Google

  Scenario Outline: Validate searching for <element>
    Given The browser is launched
    When The google web page is opened
    Then Search for the "<element>"
    Then Validate the result is displayed as "<expected>"

    Examples:
      | element  |expected|
      |++++++|notmatch|
      |tenical|didyoumean|