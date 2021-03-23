Feature: Buy items

  @buy
  Scenario: Load items in shopping cart
    Given I have selected item size
    And I have also selected item quantity
    When I click the button
    Then the items will be loaded into the shopping cart