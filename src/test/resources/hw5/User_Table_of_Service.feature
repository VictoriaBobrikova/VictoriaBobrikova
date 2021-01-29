Feature: User Table page of Service
  In order to check users
  As a logged in user
  I want see users on User Table page

Background:
  Given I am on JDI GitHub site Home page
  And I logged in as user ROMAN_IOVLEV

Scenario: User Table Page test
  When I click on "Service" button in Header
  And I click 'User Table' button in Service dropdown
  Then 'User Table' page should be opened
  And 6 Number Type Dropdowns should be displayed on Users Table
  And 6 Usernames should be displayed on Users Table
  And 6 Description texts under images should be displayed on Users Table
  And 6 checkboxes should be displayed on Users Table
  And User table should contain values:
    | Number | User             | Description                        |
    | 1      | Roman            | Wolverine                          |
    | 2      | Sergey Ivan      | Spider Man                         |
    | 3      | Vladzimir        | Punisher                           |
    | 4      | Helen Bennett    | Captain America \nsome description |
    | 5      | Yoshi Tannamuri  | Cyclope \nsome description         |
    | 6      | Giovanni Rovelli | Hulk\nsome description             |
  And droplist should contain in column Type for user 'Roman':
    | Values          |
    | Admin           |
    | User            |
    | Manager         |

Scenario: Vip checkbox test
  And I click on "Service" button in Header
  And I click 'User Table' button in Service dropdown
  When I select 'Vip' checkbox for 'Sergey Ivan'
  Then 1 log row has 'Vip: condition changed to true' text in log section