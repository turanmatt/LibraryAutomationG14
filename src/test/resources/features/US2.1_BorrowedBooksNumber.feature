@us2.1
Feature: As a librarian, I want to know borrowed books number
  @db
  Scenario: verify the total amount of borrowed books
    Given I login as a "librarian"
    When I take borrowed books number
    Then the borrowed books number information must match with DB