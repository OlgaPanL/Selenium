package PasteBin.test;

import PasteBin.page.PasteBinHomePage;
import PasteBin.page.PasteBinNewPateTitlePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPasteBin {

    private  WebDriver webDriver;
    String codeText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    String titleName = "how to gain dominance among developers";
    String errorMeesage = "You have reached your guest paste limit of 10 pastes per 24 hours. Either wait a little or sign up for a free account to get higher limits.";
    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
         webDriver = new ChromeDriver();
    }
    @Test (description = "Just first test, JIRA binding can be here")
    public void createNewPasteHelloWeb() {
        PasteBinNewPateTitlePage pasteBinNewPateTitlePage = new PasteBinHomePage(webDriver)
                .openPage()
                .createNewPaste(codeText,titleName);
        Assert.assertEquals(pasteBinNewPateTitlePage.getErrorMessageText(),errorMeesage);
    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        webDriver.quit();
        webDriver = null;
    }
}
