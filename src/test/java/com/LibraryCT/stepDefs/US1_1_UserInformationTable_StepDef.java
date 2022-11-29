package com.LibraryCT.stepDefs;

import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;

public class US1_1_UserInformationTable_StepDef {
    int actualUserIDCount;
    DB_Util db=new DB_Util();

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection(ConfigurationReader.getProperty("library2.db.url"), ConfigurationReader.getProperty("library2.db.username"), ConfigurationReader.getProperty("library2.db.password"));
    }
    @When("Execute query to get user IDs")
    public void execute_query_to_get_user_i_ds() {
        //TODO: Get a count of all Users


DB_Util.runQuery("select COUNT(id) from users");
    }
    @Then("verify all users have unique ID")
    public void verify_all_users_have_unique_id() {
//TODO: Create a set of all user ids. Compare count of set with number of users to determine if ids are unique.
    }


    @When("Execute query to get all user table columns")
    public void execute_query_to_get_all_user_table_columns() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the below <{string}> are listed in result")
    public void verifyTheBelowAreListedInResult(String arg0) {
    }


}
