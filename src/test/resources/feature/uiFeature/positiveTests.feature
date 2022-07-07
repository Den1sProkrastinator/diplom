Feature: 6 позитивных тестов

  Background: open browser
    And user with username "testsGitForFinalProject" and psw "Den1andNikita228" logged in

  Scenario: Загрузка файлов
    Given  open repositories page
    * chose "repository for download file name"
    * "selected repository" is opened
    When your click button download
    * click "Download ZIP"
    Then download is successful












