Feature: Login to magento application and place an order

  Scenario Outline: Login with valid credentials
    Given user is on home page
    When user click on signin link
    And user enter valid username
    And user enter valid password
    And user clicks on Login button
    Then user gets the title of the page
    And page title should include "Home Page - Magento eCommerce"

#  Scenario Outline: Go to My Account and edit address
    Given user navigates to my account page
    When user click on edit address link
    And user fills the form from sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on save address button
    Then it shows a successful message "You saved the address."

#  Scenario: Select products and add into cart
    Given user is on address page
    When user navigate and hover to Men>Top and click on Jackets
    Then user select product "Montana Wind Jacket" and size "M" and color "Green"
    And user click on Add to cart button
    Then verify product "Montana Wind Jacket" is added into cart
    And user navigate and hover to Men>Top and click on Jackets
    Then user select product "Lando Gym Jacket" and size "L" and color "Blue"
    And user click on Add to cart button
    Then verify product "Lando Gym Jacket" is added into cart
    Then user navigate and hover to Men>Bottoms and click on Pants
    Then user select product "Zeppelin Yoga Pant" and size "32" and color "Red"
    And user click on Add to cart button
    Then verify product "Zeppelin Yoga Pant" is added into cart
    And user click on cart link
    And user click on proceed to checkout button

#  Scenario: Verify order summary and place an order
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

    Examples:
      |SheetName|RowNumber|
      |AddressDetails|0|

