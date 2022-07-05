Feature: Проверка всплывающих сообщений

  Background: open browser
    And login page is opened
    * user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
    * dashboard is opened
    * chose project "diplomDN"
    * test Runs & Results  page is opened

  Scenario: Проверка всплывающего сообщения
    Given open add test run page
    When the cursor is above the question mark of the description field
    Then message "Open the editor formatting reference." near cursor