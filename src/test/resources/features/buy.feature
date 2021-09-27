Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product "Bread" with price 20.50 exists
    And a product "Jam" with price 80.00 exists
    And a product "Butter" with price 60.00 exists

Scenario: Buy one product
    When I buy "Bread" with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When I buy "Bread" with quantity 2
    And I buy "Jam" with quantity 1
    Then total should be 121.00

Scenario: Buy three products
    When I buy "Butter" with quantity 2
    And I buy "Jam" with quantity 3
    And I buy "Bread" with quantity 4
    Then total should be 442.00
