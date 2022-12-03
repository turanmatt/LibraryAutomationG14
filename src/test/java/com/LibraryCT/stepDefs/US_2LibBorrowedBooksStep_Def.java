package com.LibraryCT.stepDefs;

import com.LibraryCT.pages.CommonAreaPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class US_2LibBorrowedBooksStep_Def {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();
    String actualBorrowedBooksNum;


    @Given("user login as a {string}")
    public void user_login_as_a(String librarian) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        loginPage.login(librarian);


    }

    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        BrowserUtils.waitFor(2);
        actualBorrowedBooksNum = commonAreaPage.borrowedBooksNumber.getText();


    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        DB_Util.runQuery("select count(*) as BorrowedBooks from book_borrow where is_returned=0");

        String expectedRowFirstColumn = DB_Util.getFirstRowFirstColumn();

        Assertions.assertEquals(expectedRowFirstColumn, actualBorrowedBooksNum);


    }


}
