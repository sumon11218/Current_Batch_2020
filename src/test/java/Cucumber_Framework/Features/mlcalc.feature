@mlcalcFeature
Feature: Retrieve expected mortgage payments after calculation

  Scenario Outline: TC1 capture monthly payment and pay off date
    Given I navigate to mlcalc home page
    When I clear and enter a value <pPrice> on Purchase Price
    When I clear and enter a value <dPayment> on Down Payment
    When I select a value <sMonth> on Start Month
    When I select a value <sYear> on Start Year
    When I click on 'Calculate' button
    Then I capture Monthly Payment & Payoff Date

    Examples:
    |pPrice|dPayment|sMonth|sYear|
    |350000|25      |Mar   |2021 |
    |400000|18      |Jun   |2024 |