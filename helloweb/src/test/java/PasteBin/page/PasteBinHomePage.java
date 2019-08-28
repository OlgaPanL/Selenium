package PasteBin.page;

//import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private  WebDriver webDriver;
    @FindBy(xpath = "//*[@id='paste_code']")
    private  WebElement newPasteInput;
    @FindBy(xpath = "//*[@id='myform']/div[3]/div[2]/div[2]/select/option[2]")
    private WebElement pasteExpirationSelect;
    @FindBy(xpath = "//*[@id='myform']/div[3]/div[1]/div[2]/select/option[3]")
    private  WebElement syntaxHighlightingSelect;
    @FindBy(name = "paste_name")
    private WebElement pasteNameInput;
    @FindBy(xpath = "//*[@id='submit']")
    private WebElement createNewPasteButton;

    public PasteBinHomePage(WebDriver webDriver){ super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public PasteBinHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
       new WebDriverWait(webDriver, 50);
        return this;
    }
    public  PasteBinNewPateTitlePage createNewPaste(String code, String title){
        newPasteInput.sendKeys(code);
        syntaxHighlightingSelect.click();
        pasteExpirationSelect.click();
        pasteNameInput.sendKeys(title);
        createNewPasteButton.click();
        return new PasteBinNewPateTitlePage(webDriver, title);
    }
}
