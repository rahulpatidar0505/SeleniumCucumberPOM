Feature: Edit Address Feature

  Background:
    Given user has already logged in to application
      |email|password|
      |abc0505@gmail.com|Test@123|

  Scenario Outline: Go to My Account and edit address
    Given user is on home page
    When user navigates to my account page
    And user click on edit address link
    And user fills the form from sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on save address button
    Then it shows a successful message "You saved the address."

    Examples:
      |SheetName|RowNumber|
      |AddressDetails|0|