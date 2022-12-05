package com.LibraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US6_1_LibrarianAddBookPage extends BasePage {

    @FindBy(xpath = "//div[@class='portlet-title']//a")
    public WebElement addBookButton;

    @FindBy(id = "book_group_id")
    public WebElement bookCategoryDropdown;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMsg;

}
