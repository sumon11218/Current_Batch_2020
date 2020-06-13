Feature: Google Test Scenarios
  Scenario Outline: TC01: Allow user to capture google search number on search result
    #following use case covers google test scenarios
    Given I navigate to google home page
    When I enter a keyword <Cars> on search field
    When I click on search icon
    When I capture search result
    Then I can extract the search number and print it

    Examples:
      |Cars|
      |Lexus|
      |BMW  |

    #each scenario/scenario out line are individual test cases. no relationship between
    #them
    Scenario: TC02: Allow user to go to google sign in page
