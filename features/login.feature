#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: This is a simple login app test

  @tag1
  Scenario: This scenario tests the login form where username and password are hardcoded.
  	Given setUp
    And User is in login app
    When User enter correct user id
    And User enter correct password
    And User click on login button
    Then I validate the outcomes
    And tearDown
    
  @tag2
  Scenario Outline: This scenario tests the login form where correct username and password are passed from the example.
  	Given setUp
    And User is in login app
    When User enters username <username>
    And User enters password <password>
    And User click on login button
    Then I validate the outcomes
    And tearDown

Examples: 
| username | password |
| tomsmith | SuperSecretPassword! |
| tomsmith | SuperSecretPassword! |
| tomsmith | SuperSecretPassword! |
| tomsmith | SuperSecretPassword! |
| tomsmith | SuperSecretPassword! |
 