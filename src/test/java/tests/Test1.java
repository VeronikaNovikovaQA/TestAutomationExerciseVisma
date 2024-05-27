package tests;

import org.example.utils.WebDriverController;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.example.pages.CreateNewPage;
import org.example.pages.MainPage;
import org.example.pages.Menu;

import static org.example.utils.WebDriverController.getDriver;


public class Test1 {
    MainPage mainPage = new MainPage();
    CreateNewPage createNewPage;
    Menu menu;

    @Test (description = "Assert field names")
    public void assertFieldNames() throws Exception {
       getDriver().get("https://omega-vismatestingapp.azurewebsites.net/");
       menu = new Menu(getDriver());
       Assert.assertEquals(menu.mainPageButton.getText(),"Sākums");
       Assert.assertEquals(menu.createNewItemButton.getText(),"Veidot jaunu...");
       mainPage = menu.openMainPage();
       Assert.assertEquals(mainPage.showInactiveButtonText(),"Rādīt arī neaktīvos");
       createNewPage = menu.openCreateNewItem();
       Assert.assertEquals(createNewPage.titleLabel.getText(),"Virsraksts:");
       Assert.assertEquals(createNewPage.titleHelpText.getText(),"Paziņojuma virsraksts, tiks attēlots sarakstā.");
       Assert.assertEquals(createNewPage.targetDateLabel.getText(),"Mērķa datums:");
       Assert.assertEquals(createNewPage.targetDateHelpText.getText(),"Datums, līdz kuram lasītāji aicināti paveikt paziņojumā aprakstīto.");
       Assert.assertEquals(createNewPage.textLabel.getText(),"Teksts:");
       Assert.assertEquals(createNewPage.textHelpText.getText(),"Paziņojuma teksts.");
       Assert.assertEquals(createNewPage.saveButton.getText(),"Saglabāt");
    }

    @AfterClass
    public void tearDown() {
        WebDriverController.closeBrowser();
    }
}



