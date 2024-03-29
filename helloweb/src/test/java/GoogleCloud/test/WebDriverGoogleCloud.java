package GoogleCloud.test;

import GoogleCloud.page.GoogleCloudCalculatorPage;
import GoogleCloud.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverGoogleCloud {
    private WebDriver webDriver;
    String numberOfInstances = "4";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        webDriver = new ChromeDriver();
    }
    @Test (description = "Just first test, JIRA binding can be here")
    public void NewEstimate() throws InterruptedException {
        GoogleCloudCalculatorPage googleCloudHomePage = new GoogleCloudHomePage(webDriver)
                .openPage()
                .openCalculatorsPage();
        Thread.sleep(5000);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        webDriver.quit();
        webDriver = null;
    }
}
