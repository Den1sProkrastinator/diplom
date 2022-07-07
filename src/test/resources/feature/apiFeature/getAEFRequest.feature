Feature: Test GET request AEF
  Background:
    Given I set sample REST API url

  Scenario: get_run AEF
    Given I Set GET posts api endpoint " non-existent run_id"
    When I Set HEADER param request content type as "application/json."
    And Send GET HTTP request
    Then I receive valid HTTP response code 400 for "GET."
    And Response BODY "GET" is non-empty

  Scenario: get_runs AEF
    Given I Set GET posts api endpoint " non-existent project_id"
    When I Set HEADER param request content type as "application/json."
    And Send GET HTTP request
    Then I receive valid HTTP response code 400 for "GET."
    And Response BODY "GET" is non-empty