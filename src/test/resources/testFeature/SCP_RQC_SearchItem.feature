@SearchItem 
Feature: Perform search in amazon online portal 

@SearchBooks_1 
Scenario: Search for data catalog under book category 

	Given User has launched the application 
	Then Validate the user has navigated to home page 
	Then Select the category from dropdown 
		|TestScenarioName|
		|SearchBooks_1|
	And Enter item to search in text box 
		|TestScenarioName|
		|SearchBooks_1|
	Then Click on search 
	And Validate the search results 
		|TestScenarioName|
		|SearchBooks_1|
	Then Fetch and store the results 
		|TestScenarioName|
		|SearchBooks_1|
		
@SearchBooks_2 
Scenario: Search for data catalog under book category 

	Given User has launched the application 
	Then Validate the user has navigated to home page 
	Then Select the category from dropdown 
		|TestScenarioName|
		|SearchBooks_1|
	And Select item from suggestions 
		|TestScenarioName|
		|SearchBooks_1|
	And Validate the search results 
		|TestScenarioName|
		|SearchBooks_1|
	Then Fetch and store the results 
		|TestScenarioName|
		|SearchBooks_1| 
