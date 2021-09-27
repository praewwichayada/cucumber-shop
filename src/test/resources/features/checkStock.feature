Feature: Check product stock
    As a seller
    I want to check product stock

Background:
    Given a product "Bread" with price 20.50 with quantity 10 exists
    And a product "Jam" with price 80.00 with quantity 5 exists

Scenario: Customer buy product amount less than availability
    When customer buy "Bread" with quantity 2
    Then total "Bread" in stock should be 8

Scenario: Customer buy product amount more than availability
    When customer over buy "Jam" with quantity 10
    Then total "Jam" in stock should be 5