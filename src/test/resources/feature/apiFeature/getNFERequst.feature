Feature: Test GET request NEF

  Background:
    Given I set sample REST API url,username,psw I Set HEADER param request content type as "json"

  Scenario: get_run NEF
    Given I Set GET posts api endpoint 1
    When Send GET HTTP request
    Then I receive valid HTTP response status code 200 for "GET."
    And Response BODY "GET" is non-empty

  Scenario: get_runs NEF
    Given I Set GET posts api endpoint "project_id"
    When I Set HEADER param request content type as "application/json."
    And Send GET HTTP request
    Then I receive valid HTTP response code 200 for "GET."
    And Response BODY "GET" is non-empty

