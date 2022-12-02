package com.LibraryCT.stepDefs;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US1_1_UserInformationTable_StepDef {
    String actualUserIDCount;
    String expectedUserIDCount;
    List<String> actualUserColumnNames;
    DB_Util db = new DB_Util();

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection();
    }

    @When("Execute query to get user IDs")
    public void execute_query_to_get_user_i_ds() {
           DB_Util.runQuery("select COUNT(id) from users");
        expectedUserIDCount = DB_Util.getFirstRowFirstColumn();
    }

    @Then("verify all users have unique ID")
    public void verify_all_users_have_unique_id() {
        DB_Util.runQuery("select distinct COUNT(id) from users");
        actualUserIDCount=DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedUserIDCount, actualUserIDCount);
    }


    @When("Execute query to get all user table columns")
    public void execute_query_to_get_all_user_table_columns() {

        DB_Util.runQuery("select * from users");
       actualUserColumnNames = DB_Util.getAllColumnNamesAsList();

    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(io.cucumber.datatable.DataTable dataTable) {
      List<String> expectedUserColumnNames=dataTable.asList();
      System.out.println(expectedUserColumnNames);
      Assert.assertEquals(expectedUserIDCount, actualUserIDCount);
    }



}
