Feature: Add user functionality 

@CreateUser @Regression
Scenario Outline: Verify add new user functionality 
	Given Add user payload with "<name>" and "<username>" and "<email>" and "<phone>"
	When user call "AddUserAPI" with Post http request 
	Then API call is sucess with status code 200 
	And verify "<name>" and "<username>" and "<email>" and "<phone>" in response 
	
	
	Examples: 
		| name           | username  | email            | phone                 |
		| Leanne Graham  | Bret      | Sincere@april.biz| 1-770-736-8031 x56442 |
		
@GetUser @Regression		
Scenario: Get the data of added user
	Given Get the id of new added user
	When user call "GetUserAPI" with Get http request 
	Then then API call is sucess with status code 200 
	