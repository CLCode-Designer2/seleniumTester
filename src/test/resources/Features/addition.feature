Feature: Calc

  @add
  Scenario: (1) Add two numbers
    Given I have entered 70 into the calculator
    And I have also entered 50 into the calculator
    When I press add
    Then the result should be 120 on the screen

  Scenario: (2) Add two numbers
    Given I have entered 123 into the calculator
    And I have also entered 456 into the calculator
    When I press add
    Then the result should be 579 on the screen


