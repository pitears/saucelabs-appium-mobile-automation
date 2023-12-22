@checkout
Feature: Checkout

  @checkout
  Scenario Outline: As a user, I should be able to order and checkout multiple products
    Given user is on the login page
    And user input valid username "<username>" and valid password "<password>"
    And  user click on the login button
    When user click Add To Cart button on two products
    And user do checkout
    Then verify checkout successfully with title "<text>"

    Examples:
      | username                | password     |           text          |
      | standard_user           | secret_sauce | THANK YOU FOR YOU ORDER |
