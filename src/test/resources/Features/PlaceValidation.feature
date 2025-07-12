#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

@tag
Feature: Validating Place API

  @tag1
  Scenario Outline: Verify if place is bein successfully added using Add Place API
    Given Add Place payload with "<Name>" "<Language>" "<Address>"
    When user calls "AddPlaceAPI" request using "POST" Https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify whether place_id created maps to "<Name>" in "GetPlaceAPI"

  
Examples:
    |Name           |Language |Address                  |
    |Frontline house|French-IN|29, side layout, cohen 09|

@DeleteAPI
  Scenario: Verify whether DeletePlaceAPI deletes a Place
		Given DeletePlaceAPI Payload
		When user calls "DeletePlaceAPI" request using "POST" Https request
		And "status" in response body is "OK"

