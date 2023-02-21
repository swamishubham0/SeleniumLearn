#Author: swamishubham0@gmail.com
Feature: Automate Web elements

Background:
	Given Properties Files are Setup
	And Browser is setup
	When Browser is triggered
	Then Check if browser is started
	
  @WebElements @Dropdown
  Scenario: Automating Dropdown Element
    Given user is on the home page of Practice Page
    And User verifies there are 4 options in the dropdown
    Then user selects "Option2" from the Dropdown

