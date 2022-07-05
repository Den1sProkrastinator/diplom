Feature: Удаление сущности

  Background: open browser
    And login page is opened
    * user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
    * "dashboard page" is opened
    * chose project "diplomDN"

  Scenario: Удаление сущности
    Given open  "Test Runs & Results" page
    When check box near test run "test run name" is activity
    * delete selected
    * check box near message is activity
    * delete
    Then message "Successfully deleted the test runs."


