Feature: Account page feature

  Background:
    Given user has already logged in to application
    |email|password|
    |abc0505@gmail.com|Test@123|

  Scenario: Select product and add into cart
    Given user is on main page
    When user navigate and hover to Men>Top and click on Jackets
    Then user click on product "Montana Wind Jacket"
    And user click on size "M"
    And user click on color "Green"
    And user click on Add to cart button


