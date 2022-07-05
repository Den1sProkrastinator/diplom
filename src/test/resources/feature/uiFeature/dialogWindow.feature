Feature: Диалоговое окно

  Background: open browser
    And login page is opened
    * user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
    * "dashboard page" is opened
    * chose project "diplomDN"
    * "Test Runs & Results" is opened

  Scenario: Проверка диалогового окна
    Given  open "test run" page
    When lose run
    *  dialog window is visible
    *  agree
    Then message "Successfully closed the test run."