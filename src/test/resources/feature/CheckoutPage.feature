Feature: Checkout page feature

  Scenario: Verify order summary and place an order
    Given user is on checkout page
    When user expand order summary
    Then verify selected product on the order summary
    And user verify shipping address is selected
    And user verify shipping method is selected
    Then user click on next button
    Then user click on place order button
    Then verify order is placed with thanks message and fetch order number
    Then click on My Account under user profile
    And click on My Orders
    And verify order number is present in order table

