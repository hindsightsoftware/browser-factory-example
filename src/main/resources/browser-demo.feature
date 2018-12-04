Feature: Browser demo

  Scenario: Read more button takes me to the article
    Given I am on the home page
    When I click on the read more button
    Then the browser scrolls to the start of the article
