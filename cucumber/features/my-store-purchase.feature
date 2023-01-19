Feature: User orders new product

  Scenario Outline: User orders new product
    Given User is logged in to MyStore shop
    When User chooses product Hummingbird Printed Sweater
    And User chooses product size "<size>"
    And User adds "<quantity>" items
    And User adds order to cart
    And User confirms cart contents
    And User proceeds to checkout
    And User confirms address
    And User chooses shipping method
    And User chooses payment method
    Then User places order
    And User takes a screenshot with order summary and total price
    And User closes store browser

    Examples:
      | size | quantity |
      | 2    | 5        |
