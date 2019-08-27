package GoogleCloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        new WebDriverWait(webDriver, 50);
        return this;
    }

    public GoogleCloudHomePage(WebDriver webDriver){super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
