Feature: Login to magento application and place an order

  Scenario: Login with incorrect credentials
    Given user is on home page
    When user click on signin link
    And user enter invalid username
    And user enter invalid password
    And user clicks on Login button
    Then verify the error message

  Scenario : Login with valid credentials
    Given user is on home page
    When user click on signin link
    And user enter valid username
    And user enter valid password
    And user clicks on Login button
    Then user gets the title of the page
    And page title should include "Home Page - Magento eCommerce"



