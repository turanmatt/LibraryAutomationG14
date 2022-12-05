@TS14-213
Feature: As a librarian, I should be able to add new books to the library
  @db
  Scenario Outline: Verify added book is matching with DB
    Given I login as a "librarian"
    And I navigate to "Books" page
    When the librarian clicks to add book
    And the librarian enters book name "<Book Name>"
    When the librarian enters ISBN "<ISBN>"
    And the librarian enters year "<Year>"
    When the librarian enters author "<Author>"
    And the librarian chooses the book category "<Book Category>"
    And the librarian clicks to save changes
    Then the librarian verifies new book is saved
    Then the librarian verifies new book from database by "<Book Name>"

    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Clean Code            | 09112021 | 2021 | Robert C.Martin | Drama                |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |