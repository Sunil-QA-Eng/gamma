Feature: Gamma-group help & support page functionality

  Background: User is on home page
    Given I am on home page

  @smoke
  Scenario: Verify help and support page loads successfully
    Given I click on help and support link
    Then The url title should contain "https://gammagroup.co/support/"
    And The page sub title should have "We’re here to help! Get answers to our frequently asked questions or find out more about the help available to you by choosing one of the options below."
