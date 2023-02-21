#Author: Shubham Swami swamishubham0@gmail.com
Feature: SouceDemo Login
  I want to use this template for my feature file

Background:
	Given Properties Files are Setup
	And Browser is setup
	When Browser is triggered
	Then Check if browser is started

  Scenario: Home Page Login 
    Given User is on SauceDemo Login Page
    When User Login to application with username and password
    Then Home page is displayed
    And Shopping Items are displayed on the homepage
