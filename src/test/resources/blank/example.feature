Feature: Hipertextual

  Scenario: Search for search Term
    Given User navigate to "https://hipertextual.com"
    When User search for "Steve Jobs"
    And User Scrolls down to the first post about "Reed Jobs"
    Then User validates that the URL contains the search term
    And User click on post
    Then User can subscribe to the news letter
