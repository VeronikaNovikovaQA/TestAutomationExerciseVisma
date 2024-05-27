package org.example.pages;

import org.example.utils.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage{

    @FindBy(xpath = "//span[text()='Rādīt arī neaktīvos']")
    public WebElement showInactiveButton;

    @FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
    public WebElement nextMonthButton;

    public MainPage() {
        PageFactory.initElements(WebDriverController.getDriver(), this);
    }

    public String showInactiveButtonText() {
        return showInactiveButton.getText();
    }

    public void clickNextMonthButton() {
        nextMonthButton.click();
    }
}
