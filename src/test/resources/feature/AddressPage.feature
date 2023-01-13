Feature: Edit Address Feature

  Scenario Outline: Go to My Account and edit address
    Given user navigates to my account page
    When user click on edit address link
    And user fills the form from sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on save address button
    Then it shows a successful message "You saved the address."

    Examples:
      |SheetName|RowNumber|
      |AddressDetails|0|