Feature: Account page feature

  Background:
    Given user has already logged in to application
    |email|password|
    |abc0505@gmail.com|Test@123|

  Scenario: Select product and add into cart
    Given user is on main page
    When user navigate and hover to Men>Top and click on Jackets
    Then user click on product "Montana Wind Jacket"
    And user fetch first product name
    And user fetch first product price
    And user click on size "M"
    And user click on color "Green"
    And user click on Add to cart button
    Then verify product is added into cart
    And user navigate and hover to Men>Top and click on Jackets
    Then user click on product "Lando Gym Jacket"
    And user fetch second product name
    And user fetch second product price
    And user click on size "L"
    And user click on color "Blue"
    And user click on Add to cart button
    Then verify product is added into cart
    Then user navigate and hover to Men>Bottoms and click on Pants
    Then user click on product "Zeppelin Yoga Pant"
    And user fetch third product name
    And user fetch third product price
    And user click on size "32"
    And user click on color "Red"
    And user click on Add to cart button
    Then verify product is added into cart
    And user click on cart link
    And user click on proceed to checkout button

