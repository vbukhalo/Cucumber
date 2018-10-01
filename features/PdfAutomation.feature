Feature: Testing PDF content
  I wish to test the contents of a pdf file
  
  Scenario: Textbook pdf link open pdf file
  	Given I am on the sample document page
  	When I click the textbook pdf link
  	Then The pdf file is displayed in the window


	Scenario: The textbook pdf contains the work cutaneous
		When I am on the textbook pdf
		Then I see the word cutaneous on the first page
		
	@test
	Scenario: The dictionary pdf has fonts by monokrom
		Given I am on the prince xml page
		When I click the dictionary pdf
		Then I should see fonts by monokrom