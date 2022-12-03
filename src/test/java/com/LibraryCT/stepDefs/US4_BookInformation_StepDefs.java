package com.LibraryCT.stepDefs;
import com.LibraryCT.pages.BasePage;
import com.LibraryCT.pages.BookPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class US4_BookInformation_StepDefs extends BasePage {
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    @Given("I login as a {string}")
    public void i_login_as_a(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        BrowserUtils.waitFor(2);
        loginPage.login(userType);
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String module) {
        BrowserUtils.waitFor(2);
        navigateModule(module);
    }
    @When("I open book {string}")
    public void i_open_book(String bookName) {
        bookPage.search.sendKeys(bookName);
        BrowserUtils.waitFor(1);
        bookPage.editBook(bookName).click();
        BrowserUtils.waitFor(1);
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualIsbn= bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        String actualAuthor = bookPage.author.getAttribute("value");
        String actualDescription = bookPage.description.getAttribute("value");

        DB_Util.runQuery("select name,isbn,year,author,description from books where name='Chordeiles minor'");

        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String expectedBookName = rowMap.get("name");
        String expectedIsbn= rowMap.get("isbn");
        String expectedYear = rowMap.get("year");
        String expectedAuthor = rowMap.get("author");
        String expectedDescription = rowMap.get("description");

        assertEquals(expectedBookName,actualBookName);
        assertEquals(expectedIsbn,actualIsbn);
        assertEquals(expectedYear,actualYear);
        assertEquals(expectedAuthor,actualAuthor);
        assertEquals(expectedDescription,actualDescription);

    }
}
