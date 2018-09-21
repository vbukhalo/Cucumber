Feature: Links on Landing Page
  I wish to test the links on the landing page
  
  Background:
  	Given I am on the landing page

  Scenario: Logo in upper right corner redirect
    When I click the logo in the upper right corner
    Then I am redirected to the Ultimate QA home page
    
	Scenario: Video tutorials link redirects to courses
		When I click the Video tutorials link
		Then I am redirected to the cources page
		
	Scenario: Best Selenium link redirects to selenium resources
		When I click the Best Selenium Resouces link
		Then I am redirected to the Selenium resouces page
		
	Scenario: Automation exercises link redirects to exercise page
		When I click the Automation Exercises Link
		Then I am redirected to the Automation Exercises page
		
	Scenario: Blog link redirects to Blog page
		When I click the Blog link
		Then I am redirected to the Blog page
		
	Scenario: Work with Us link redirects to Work with Us page
		When I click the Work with Us link
		Then I am redirected to the Work with Us page
		
	@test
	Scenario: Redirection to free trial
		When I enter my first name and email
		And Click submit
		Then I am redirected to the sign up confirmation page

