@sorting
Feature: Sorting

  @sorting
  Scenario Outline: As a user, I should be able to choose price low to high
    Given user is on the login page
    And user input valid username "<username>" and valid password "<password>"
    And  user click on the login button
    When user filter option low to high
    Then compare first product price with second product price

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |