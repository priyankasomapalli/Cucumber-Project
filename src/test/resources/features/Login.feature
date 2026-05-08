#Author 
@tag
Feature: Test Login functionality
@tag1
Scenario:Test login with valid credentials
Given Chrome browser is opened
When Go to URL "https://the-internet.herokuapp.com/"
Then User should be on "https://the-internet.herokuapp.com/"
When User clicks on "Form Authentication link"
Then User should land on login page
When User enters Username "tomsmith"
And User enters Password "SuperSecretPassword!"
And clicks on Login button
Then User should be logged in successfully


