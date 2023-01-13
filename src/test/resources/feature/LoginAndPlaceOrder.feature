@Login
Feature: Login to magento application and place an order

#  Scenario: Login with incorrect credentials
#    Given user is on home page
#    When user click on signin link
#    And user enters username "abc123@gmail.com"
#    And user enters password "Test@123"
#    And user clicks on Login button
#    Then verify the error message
    
  Scenario: Login with correct credentials
    Given user is on home page
    When user click on signin link
    And user enters username
    And user enters password
#    And user clicks on Login button
#    Then user gets the title of the page
#    And page title should include "Home Page - Magento eCommerce"
#
##  Scenario: Select product and add into cart
#    Given user is on main page
#    When user navigate and hover to Men>Top and click on Jackets
#    Then user click on product "Montana Wind Jacket"
#    And user verify "Montana Wind Jacket" product name
#    And user verify "Montana Wind Jacket" product price
#    And user click on size "M"
#    And user click on color "Green"
#    And user click on Add to cart button
#    Then verify product "Montana Wind Jacket" is added into cart
#    And user navigate and hover to Men>Top and click on Jackets
#    Then user click on product "Lando Gym Jacket"
#    And user verify "Lando Gym Jacket" product name
#    And user verify "Lando Gym Jacket" product price
#    And user click on size "L"
#    And user click on color "Blue"
#    And user click on Add to cart button
#    Then verify product "Lando Gym Jacket" is added into cart
#    Then user navigate and hover to Men>Bottoms and click on Pants
#    Then user click on product "Zeppelin Yoga Pant"
#    And user verify "Zeppelin Yoga Pant" product name
#    And user verify "Zeppelin Yoga Pant" product price
#    And user click on size "32"
#    And user click on color "Red"
#    And user click on Add to cart button
#    Then verify product "Zeppelin Yoga Pant" is added into cart
#    And user click on cart link
#    And user click on proceed to checkout button
#
##  Scenario: Verify order summary and place an order
#    Given user is on checkout page
#    When user expand order summary
#    Then verify selected product on the order summary
#    And user verify shipping address is selected
#    And user verify shipping method is selected
#    Then user click on next button
#    Then user click on place order button
#    Then verify order is placed with thanks message and fetch order number
#    Then click on My Account under user profile
#    And click on My Orders
##    TODO : failing to verify
##    And verify order number is present in order table


