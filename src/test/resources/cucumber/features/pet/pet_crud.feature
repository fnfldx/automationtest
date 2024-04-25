@Pet
@CRUD
Feature: CRUD pet and body validation

  @issue:BA-40-setupEngineWithBasicSteps
  Scenario: Checks if pets with certain status are correctly returned
    When Finds Pets by status "available"
    Then Check if status "available" is returned

  @issue:BA-40-setupEngineWithBasicSteps
  Scenario: Checks if pet is added correctly to the store
    When Add a new pet to the store
    Then The response with status code 200 is returned
    And Check the response body of created pet is correct

  @issue:BA-40-setupEngineWithBasicSteps
  Scenario Outline: Checks the response code for returned pets by status
    When Finds Pets by status "<status>"
    Then The response with status code 200 is returned

    Examples:
    | status |
    | available |
    | pending |
    | sold |