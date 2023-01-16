Feature: Login to magento application and place an order

  Background:
    Given user is on home page
    And user click on signin link

  Scenario: Verify user is on login page
    Given user is on login page
    And verify title contains "Customer Login Magento Commerce"
    And verify url contains "account/login"

  Scenario: Login with invalid email and verify error
    Given user is on login page
    When user enter invalid email
    And user enter invalid password
    And user clicks on Login button
    Then verify the email error message

  Scenario: Login with incorrect credentials and verify error
    Given user is on login page
    When user enter invalid username
    And user enter invalid password
    And user clicks on Login button
    Then verify the error message

  Scenario: Login with valid credentials
    Given user is on login page
    When user enter valid username
    And user enter valid password
    And user clicks on Login button
    Then user gets the title of the page
    And page title should include "Home Page - Magento eCommerce"



