Feature: Test CRUD methods in Sample REST API testing framework

  Background:
    Given I set sample REST API url

  Scenario: POST
    Given I Set POST posts api endpoint
    When I Set HEADER param request content type as "application/json."
    And Set request Body
    And Send a POST HTTP request
    Then I receive valid HTTP response code 200
    And Response BODY "POST" is non-empty.


  Scenario: GET
    Given I Set GET posts api endpoint "1"
    When I Set HEADER param request content type as "application/json."
    And Send GET HTTP request
    Then I receive valid HTTP response code 200 for "GET."
    And Response BODY "GET" is non-empty


  Scenario: UPDATE
    Given I Set PUT posts api endpoint for "1"
    When I Set Update request Body
    And Send PUT HTTP request
    Then I receive valid HTTP response code 200 for "PUT."
    And Response BODY "PUT" is non-empty


  Scenario: DELETE
    Given I Set DELETE posts api endpoint for "1"
    When I Send DELETE HTTP request
    Then I receive valid HTTP response code 200 for "DELETE."