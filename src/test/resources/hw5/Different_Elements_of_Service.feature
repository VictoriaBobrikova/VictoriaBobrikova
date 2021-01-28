Feature: Different Elements page of Service
  In order to choose elements
  As a logged in user
  I want to select certain checkboxes, radio button and color

  Background:
    Given I am on JDI GitHub site Home page
    And I logged in as user ROMAN_IOVLEV
    And I click on "Service" button in Header
    And I click 'Different elements' button in Service dropdown

  Scenario: Select checkboxes, radio button and color test
    When I select 'Water' element
    And I select 'Wind' element
    And I select 'Selen' element
    And I select 'Yellow' color in colors dropdown
    Then log row number 0 has 'Colors: value changed to Yellow' text
    And log row number 1 has 'metal: value changed to Selen' text
    And log row number 2 has 'Wind: condition changed to true' text
    And log row number 3 has 'Water: condition changed to true' text