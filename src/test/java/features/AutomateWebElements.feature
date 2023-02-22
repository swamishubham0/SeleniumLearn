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
    
  @WebElements @RadioButton
	Scenario: Automation of Radio button Element
		Given user is on the home page of SpiceJet Page
    Then User selects radio button of "Senior Citizen"
    
  @WebElements @CheckBox
	Scenario: Automation of Checkbox Element
		Given user is on the home page of Practice Page
		And User selects checkbox of "option1"
    Then Verify checkbox of "option1" is selected
    And Get the count of checkboxes present on the page
       
  @WebElements @CalendarUI
	Scenario: Automation of Calendar UI Element
		Given user is on the home page of SpiceJet Page
    Then User selects today's date on calendar
    
   @WebElements @AngularPage
	Scenario Outline: Submit data on Angular Practice page
		Given user is on the home page of Angular practice Page
    And User enters following data "<Name>" ,"<Email>", "<Password>", "<Check>", "<Gender>", "<Employment Status>", "<Date of Birth>" and submits
    Then verify user receives success message
    
    Examples:
     	|Name 			|Email 								| Password	|Check		|Gender	|Employment Status 	|Date of Birth	|
 			|Test Name	|testEmail@none.com		|Pa$$W0rd		|true			|Female	|Student						|25-06-2000			|
   
   @WebElements @Alerts
	Scenario: Automation Dynamic Dropdown Element
		Given  user is on the home page of Practice Page
		And user clicks on Alert button on practice page
		Then verify user is prompted by an alert
		And user clicks on confirm button on practice page
		Then verify user is able to dismiss the alert
	
    
    
    