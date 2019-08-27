
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://pastebin.com/");

        WebElement searchButtonNewPaste = webDriver.findElement(By.id("header_new_paste"));
        searchButtonNewPaste.click();

        WebElement searchTextBoxNewPaste =  webDriver.findElement(By.xpath("//*[@id='paste_code']"));
        searchTextBoxNewPaste.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        WebElement sel = webDriver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[1]/div[2]/select/option[3]"));
        sel.click();
        WebElement sel2 = webDriver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[2]/div[2]/select/option[2]"));
        sel.click();

        WebElement searchTextBoxPasteName =  webDriver.findElement(By.name("paste_name"));
        searchTextBoxPasteName.sendKeys("how to gain dominance among developers");
        WebElement searchButtonCreateNewPaste = webDriver.findElement(By.id("submit"));
        searchButtonCreateNewPaste.click();

         WebElement TitlePageText = webDriver.findElement(By.xpath("//*[@class='paste_box_line1']/h1"));

         WebElement CodeText = webDriver.findElement(By.xpath("//*[@class='de1']"));
        Assert.assertEquals(TitlePageText.getText(),"how to gain dominance among developers");
//        Assert.assertEquals(CodeText.getText(),"Hello from WebDriver");
        Thread.sleep(5000);
        webDriver.quit();
    }

    private static WebElement waitForElementLocationBy(WebDriver webDriver, By by) {
        return (WebElement) new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
