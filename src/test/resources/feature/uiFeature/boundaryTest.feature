Feature: Boundary test
Background: open browser
And login page is opened
* user with username "atrostyanko@gmail.com" and psw "Americana#1" logged in
* "dashboard page" is opened
* chose project "diplomDN"
* "Test Runs & Results" page is opened




Scenario Outline: Положительный тест на проверку поля для ввода на граничные значения
Given open "add test run" page
When name is "<name>"
Then "Test Runs & Results" is opened
* message "Successfully added the new test run."
Examples:
| name                                                                                      |
| 1                                                                                                    |
| 11                                                                                                   |
|x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x12345678|
|x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789x123456789|