package com.LibraryCT.stepDefs;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class US5_MostBorrowedBooks {


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
    }
    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        String query =" select bc.name,count(*) from book_borrow bb\n" +
                "            inner join books b on bb.book_id = b.id\n" +
                "            inner join book_categories bc on b.book_category_id=bc.id\n" +
                "            group by name\n" +
                "            order by 2 desc;\n";


        DB_Util.runQuery(query);

    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedMostPopular) {
        String actualMostPopular = DB_Util.getFirstRowFirstColumn();
        //System.out.println(expectedMostPopular);
        Assertions.assertEquals(expectedMostPopular,actualMostPopular);
        //System.out.println(actualMostPopular);


    }


}
