  @TS14-206 @db
#  US1: Verify that user information is stored in mySQL DB correctly in Users Table- DB1
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.

  Background:
    Given Establish the database connection

  Scenario: verify users has unique IDs
    When Execute query to get user IDs
    Then verify all users have unique ID

  Scenario: verify users table columns
    When Execute query to get all user table columns
    Then verify the below columns are listed in result
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |