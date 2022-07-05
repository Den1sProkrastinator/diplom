Feature: Удаление сущности

  Background: open browser
    And login page is opened
    * user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
    * "dashboard page" is opened
    * chose project "diplomDN"
    * "Test Runs & Results" is opened

  Scenario: Загрузка файлов
    Given  open "test run" page
    When export run
    * export to XML
    Then download is successful