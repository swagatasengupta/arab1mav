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
Feature: Log in and log out to automationpractice.com
  Description: This test will log in to the choice of browser of the user and test if the user is able to log in successfully or not

  @Autop_TestScenario
  Scenario Outline: I can log in to the application with valid credentials
    Given User is using <browser>
    And User credential is <user_name> and <password>
    When user clicks on Sign In link on automationpractice.com website
    And provides valid credentials for log in
    Then User is able to log in to the system
    And user is able to log out and close the page

    Examples: 
      | browser | user_name                 | password |
      | chrome  | swagatasengupta@yahoo.com |  12345 |
 			| mozilla | swagatasengupta@yahoo.com | 12345 |