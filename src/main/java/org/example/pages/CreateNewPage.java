package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPage {

    WebDriver driver;

    @FindBy(xpath = "//label[@for='title']")
    public WebElement titleLabel;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleInputField;

    @FindBy(xpath = "//small[@id='title-help']")
    public WebElement titleHelpText;

    @FindBy(xpath = "//label[@for='target-date']")
    public WebElement targetDateLabel;

    @FindBy(xpath = "//small[@id='target-date-help']")
    public WebElement targetDateHelpText;

    @FindBy(xpath = "//label[@for='text']")
    public WebElement textLabel;

    @FindBy(xpath = "//textarea[@id='text']")
    public WebElement textInputField;

    @FindBy(xpath = "//small[@id='text-help']")
    public WebElement textHelpText;

   @FindBy(xpath = "//button[@class='p-ripple p-element p-button p-component']")
    public WebElement saveButton;


    @FindBy(xpath = "//div[@data-pc-section='summary']")
    public WebElement toastSummary;

    @FindBy(xpath = "//div[@data-pc-section='detail']")
    public WebElement toastDetail;

    public CreateNewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTitleText(String titleText) {
        titleInputField.sendKeys(titleText);
    }

    public void enterTextToTextField(String text) {
        textInputField.sendKeys(text);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

}
