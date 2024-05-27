package tests;

import com.github.javafaker.Faker;
import org.example.utils.WebDriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.example.pages.CreateNewPage;
import org.example.pages.MainPage;
import org.example.pages.Menu;

import java.util.concurrent.TimeUnit;

public class Test2 extends WebDriverController {
    MainPage mainPage;
    CreateNewPage createNewPage;
    Menu menu;
    Faker faker = new Faker();

    @Test(description = "Create new item, validate it is shown on the main page")
    public void createNewItem () throws Exception {
        getDriver().get("https://omega-vismatestingapp.azurewebsites.net/");
        menu = new Menu(getDriver());
        menu.openCreateNewItem();
        createNewPage = menu.openCreateNewItem();
        String title = faker.superhero().name();
        createNewPage.enterTitleText(title);
        createNewPage.enterTextToTextField("Šogad visiem Visma darbiniekiem tiks rīķots kino varaks birojā. Tuvākajās dienās būs pieejama visa informācija.");
        createNewPage.clickSaveButton();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(createNewPage.toastSummary.getText(), "Paziņojums saglabāts!");
        Assert.assertEquals(createNewPage.toastDetail.getText(), "Paziņojums ir veiksmīgi izveidots.");

        mainPage = menu.openMainPage();
        TimeUnit.SECONDS.sleep(2);

        boolean isFound = false;
        while (!isFound) {
            for (WebElement row : getDriver().findElements(By.xpath("//div[@class='p-dataview-content']//div[@class='title']//parent::div[contains(@class,'row')]"))) {
                if (row.getText().contains(title)) {
                    Assert.assertEquals(row.findElement(By.xpath(".//div[@class='title']")).getText(), title);
                    isFound = true;
                    break;
                }
            }
            mainPage.clickNextMonthButton();
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
        getDriver().quit();
    }
}

