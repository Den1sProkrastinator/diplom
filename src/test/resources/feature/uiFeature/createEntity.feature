Feature: Создание сущности

  Background: open browser
    And login page is opened
    * user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
    * "dashboard page" is opened
    * chose project "diplomDN"
    * "Test Runs & Results" page is opened



  Scenario: Создание сущности
    Given open "add test run" page
    When name is "test run name" and add test run
    Then add test run page is opened
    * message "Successfully added the new test run."