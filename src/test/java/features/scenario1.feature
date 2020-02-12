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
@Scenario1
Feature: Scenario1
  I want to use this template for my feature file

  @tag1
  Scenario: Guest explores Ports of Departure
    Given a Guest
    And I am on Homepage
	  And I navigated to "Ports" page
    When I search for "Honolulu" port
    Then Map zoomed to show selected port
    And Port is on the middle of the map
    And Port displayed as “Port Of Departure” 
    
 
 
  


    

