Feature: Web Search
  As a user
  I want to search on Google/Bing
  So that I can find relevant information

  @Clover
  Scenario Outline: Web Search
    Given I Open "<search engine>"
    When I search for "<search keyword>" on "<search engine>"
    Then I should see "<search keyword>" is present in "<search engine>" results
    Examples:
      | search engine | search keyword |
      | Google        | Clover         |
      | Bing          | Clover         |


