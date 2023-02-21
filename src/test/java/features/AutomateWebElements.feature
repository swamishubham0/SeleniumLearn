#Author: your.email@your.domain.com

Feature: Automate Web elements

  @WebElements
  Scenario: Automating Dropdown Element
    Given user is on the home page of Practice Page
    And User verifies there are "3" options in the dropdown
    Then user selects "Option2" from the Dropdown

