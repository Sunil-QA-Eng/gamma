Feature: Gamma-group home page functionality

  Background: User is on home page
    Given I am on home page

  @smoke
  Scenario: Verify homepage loads successfully
    Then The page title should contain "Gamma Communications: Good Together | Empowering good business"

  @smoke
  Scenario: Check the mission statement text on homepage
    Then I should see the mission statement text as "We're on a mission to make business communications less complex, and more human."

  @smoke
  Scenario: Verify top navigation menu items are displayed correctly
    When I fetch the top navigation menu items
    Then I should see the following menu items:
      | Company            |
      | Business Solutions |
      | Partner Solutions  |
      | Product Portfolio  |
      | Resources          |

  @smoke
  Scenario: Validate submenu items of Product Portfolio are displayed correctly
    When I click on product portfolio from top menu
    Then I should see the following submenu items:
      | Enable     |
      | Connect    |
      | Experience |
      | Secure     |
      | Solutions  |
      | Toolbox    |