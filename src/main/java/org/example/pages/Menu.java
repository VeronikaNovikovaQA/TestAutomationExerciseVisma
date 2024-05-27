package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Sākums']")
    public WebElement mainPageButton;

    @FindBy(xpath = "//span[text()='Veidot jaunu...']" )
    public WebElement createNewItemButton;

    public Menu (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        mainPageButton.click();
        return new MainPage();
    }

    public CreateNewPage openCreateNewItem() {
        createNewItemButton.click();
        return new CreateNewPage(driver);
    }
}
