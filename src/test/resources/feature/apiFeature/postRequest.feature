Feature: Test Post request

  Background:
    Given I set sample REST API url

  Scenario: POST
    Given I Set POST posts api endpoint
    When I Set HEADER param request content type as "application/json."
    And Set request Body
    And Send a POST HTTP request
    Then I receive valid HTTP response code 200
    And Response BODY "POST" is non-empty.