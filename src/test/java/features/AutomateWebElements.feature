#Author: swamishubham0@gmail.com
Feature: Automate Web elements

Background:
	Given Properties Files are Setup
	And Browser is setup
	When Browser is triggered
	Then Check if browser is started
	
  @WebElements @Dropdown
  Scenario: Automating Static Dropdown Element
    Given user is on the home page of Practice Page
    And User verifies there are 4 options in the dropdown
    Then user selects "Option2" from the Dropdown
    
	@WebElements @Dropdown
	Scenario: Automation Dynamic Dropdown Element
		Given user is on the home page of Dropdown Practice Page
    And User enters "Ind" in the dropdown search field
    Then User selects "India" from the autosuggest dropdown
    
  @WebElements @CheckBox
	Scenario: AutomationCheckbox Element
		Given user is on the home page of SpiceJet Page
    Then User selects checkbox of "Senior Citizen"
    
    
    