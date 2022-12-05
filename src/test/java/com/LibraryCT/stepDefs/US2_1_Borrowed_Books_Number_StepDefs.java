package com.LibraryCT.stepDefs;

import com.LibraryCT.pages.CommonAreaPage;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US2_1_Borrowed_Books_Number_StepDefs {

    CommonAreaPage commonAreaPage = new CommonAreaPage();
    String actualBorrowedBooks;

    @When("I take borrowed books number")
    public void I_take_borrowed_books_number() {
        actualBorrowedBooks = commonAreaPage.borrowedBooksNumber.getText();
    }

    @Then("the borrowed books number information must match with DB")
    public void the_borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBooks = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooks, actualBorrowedBooks);


    }

}
