@Pet
@CRUD
Feature: CRUD pet and body validation

  @issue:BA-40-setupEngineWithBasicSteps
  Scenario: Checks if pets with certain status are correctly returned
    When Finds Pets by status "available"
    And Check if status "available" is returned

  @issue:BA-40-setupEngineWithBasicSteps
  Scenario Outline: Checks the response code for returned pets by status
    When Finds Pets by status "<status>"
    Then The response with status code 200 is returned

    Examples:
    | status |
    | available |
    | pending |
    | sold |