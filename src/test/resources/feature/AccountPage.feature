Feature: Account page feature

  Scenario: Select product and add into cart
    Given user is on address page
    When user navigate and hover to Men>Top and click on Jackets
    Then user select product "Montana Wind Jacket"
    And user select size "M"
    And user select color "Green"
    And user click on Add to cart button
    Then verify product "Montana Wind Jacket" is added into cart
    And user navigate and hover to Men>Top and click on Jackets
    Then user select product "Lando Gym Jacket"
    And user select size "L"
    And user select color "Blue"
    And user click on Add to cart button
    Then verify product "Lando Gym Jacket" is added into cart
    Then user navigate and hover to Men>Bottoms and click on Pants
    Then user select product "Zeppelin Yoga Pant"
    And user select size "32"
    And user select color "Red"
    And user click on Add to cart button
    Then verify product "Zeppelin Yoga Pant" is added into cart
    And user click on cart link
    And user click on proceed to checkout button

