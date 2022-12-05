package com.LibraryCT.stepDefs;

import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.US6_1_LibrarianAddBookPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class US6_1_LibrarianAddBook_StepDefs {


    BookPage bookPage = new BookPage();
    US6_1_LibrarianAddBookPage us6_1_librarianAddBookPage = new US6_1_LibrarianAddBookPage();

    @When("the librarian clicks to add book")
    public void the_librarian_clicks_to_add_book() {
        us6_1_librarianAddBookPage.addBookButton.click();
    }

    @And("the librarian enters book name {string}")
    public void the_librarian_enters_book_name (String bookName) {
        BrowserUtils.sleep(5);
        bookPage.bookName.sendKeys(bookName);
    }

    @When("the librarian enters ISBN {string}")
    public void the_librarian_enters_ISBN (String isbn){
        bookPage.isbn.sendKeys(isbn);
    }

    @And ("the librarian enters year {string}")
    public void the_librarian_enters_year (String year){
        bookPage.year.sendKeys(year);
    }

    @When ("the librarian enters author {string}")
    public void the_librarian_enters_author (String authorName){
        bookPage.author.sendKeys(authorName);
    }

    @And ("the librarian chooses the book category {string}")
    public void the_librarian_chooses_the_book_category (String category){
        BrowserUtils.selectByVisibleText(us6_1_librarianAddBookPage.bookCategoryDropdown, category);
    }

    @And ("the librarian clicks to save changes")
    public void the_librarian_clicks_to_save_changes(){
        us6_1_librarianAddBookPage.saveChangesButton.click();
    }

    @Then ("the librarian verifies new book is saved")
    public void the_librarian_verifies_new_book_is_saved(){
        BrowserUtils.sleep(5);
        Assertions.assertTrue(us6_1_librarianAddBookPage.toastMsg.isDisplayed());
    }

    @Then ("the librarian verifies new book from database by {string}")
    public void the_librarian_verifies_new_book_from_database_by (String expectedBookName){
        BrowserUtils.sleep(5);
        String query = "select id,name,author from books\n" + "where name = '"+expectedBookName+"'";
        DB_Util.runQuery(query);
        Map<String, String> rowMap = DB_Util.getRowMap(1);
        Assertions.assertEquals(expectedBookName, rowMap.get("name"));
    }
}
