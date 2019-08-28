package GoogleCloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//*[@id='top_of_page']/div[1]/div[1]/header/div[1]/div/div/div[2]/nav/ul/li[5]/a")
    private WebElement pricingMenu;
    @FindBy(xpath = "//*[@class='devsite-nav-title' and @track-metadata-eventdetail='calculators']")
    private WebElement calculatorsMenu;
    public GoogleCloudHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, 50);
        return this;
    }
    public GoogleCloudCalculatorPage openCalculatorsPage(){
        pricingMenu.click();
        calculatorsMenu.click();
        return new GoogleCloudCalculatorPage(webDriver);
    }

    public GoogleCloudHomePage(WebDriver webDriver){super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
