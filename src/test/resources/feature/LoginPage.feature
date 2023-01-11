Feature: Login page feature

#Scenario: Login page title
#Given user is on login page
#When user gets the title of the page
#Then page title should be "Login - My Store"
#
#Scenario: Forgot Password link
#Given user is on login page
#Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on home page
When user click on signin link
And user enters username "abc0505@gmail.com"
And user enters password "Test@123"
And user clicks on Login button
#Then user gets the title of the page
#And page title should be "My account - My Store"