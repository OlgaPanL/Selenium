package PasteBin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinNewPateTitlePage extends AbstractPage {
    @FindBy(xpath = "//*[@class='paste_box_line1']/h1")
    private WebElement titlePageText;
    @FindBy(xpath = "//*[@class='de1']")
    private WebElement codeText;
    @FindBy(xpath = "//*[@id='error']")
    private WebElement errorMessage;
    public PasteBinNewPateTitlePage(WebDriver webDriver, String title){
        super(webDriver);
    }
    public String getErrorMessageText(){
        return errorMessage.getText();
    }
    public String getTitlePageText(){
        return titlePageText.getText();
    }
    public String getCodeText(){
        return codeText.getText();
    }
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
}
