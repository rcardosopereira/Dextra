


Feature: Search with QA
  As a recruiter
	I want to collect survey data
	For more detailed analysis of the QA (https://bit.ly/3jOMrR9)

  
	Scenario: Fill survey with valid mandatory data
		Given I access the VV Test page
		And access the Research - QA menu
		When I fill in all required fields
		Then should be directed to a successful page

  