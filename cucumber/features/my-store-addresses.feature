Feature: User adds new address

  Scenario Outline: User adds new address to the account
    Given User is logged in to CodersLab shop
    When User goes to addresses page
    And User adds new address
    And User enters new address details alias "<alias>", address "<address>", zip or postal code "<postcode>", city "<city>", country "<country>", phone number "<phone>"
    Then User can see new address
    And User can verify created address alias "<alias>", address "<address>", zip or postal code "<postcode>", city "<city>", country "<country>", phone number "<phone>"
    And User closes browser

    Examples:
      | alias | address    | postcode | city       | country | phone         |
      | Mr.   | 69 Test Rd | CL13 7AO | Testingham | 17      | 011 1111 1111 |