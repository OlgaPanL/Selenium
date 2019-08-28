package GoogleCloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudCalculatorPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator/";
    @FindBy(xpath = "//*[@class=\"md-ripple-container\"]")
    private WebElement sectionComputeEngine;
    @FindBy(xpath = "//*[@id='input_486']")
    private WebElement inputNumberOfInstances;
    @FindBy(xpath = "//*[@id='select_value_label_48']")
    private WebElement selectMachineType;
    @FindBy(xpath = "//*[@id='select_option_216']")
    private WebElement itemMachineType;
    @FindBy(xpath = "//*[@class='hexagon-in2']")
    private WebElement computeEngine;

    public GoogleCloudCalculatorPage FillForm(String numberOfInstances){
        sectionComputeEngine.click();
        inputNumberOfInstances.sendKeys(numberOfInstances);
        selectMachineType.click();
        itemMachineType.click();
        return new GoogleCloudCalculatorPage(webDriver);
    }
    @Override
    protected AbstractPage openPage() throws InterruptedException {
        throw new RuntimeException();
    }
    public GoogleCloudCalculatorPage(WebDriver webDriver){super(webDriver);
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);}
}
