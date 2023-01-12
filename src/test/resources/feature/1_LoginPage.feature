@Login
Feature: Login to magento application and place an order

  Scenario: Login with incorrect credentials
    Given user is on home page
    When user click on signin link
    And user enters username "abc123@gmail.com"
    And user enters password "Test@123"
    And user clicks on Login button
    Then verify the error message

  Scenario: Login with correct credentials
    Given user is on home page
    When user click on signin link
    And user enters username "abc0505@gmail.com"
    And user enters password "Test@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should include "Home Page - Magento eCommerce"



