package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[@class = '_3TqU78D']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class = 'add-item']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//select[@id = 'main-size-select-0']")
    private WebElement selectSizeField;

    @FindBy(xpath = "//select[@id='main-size-select-0']/option[2]")
    private WebElement selectSize;

    @FindBy(xpath = "//span[@class = '_3dfrZFm']")
    private WebElement addToBagPopupHeader;

    @FindBy(xpath = "//div[@id = 'miniBagDropdown']")
    private WebElement miniBagDropdownButton;

    @FindBy(xpath = "//a[@class = '_1TlOB9h _2tvh469 _12h15d-']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//span[@class='error basic-error-box']")
    private WebElement errorMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProduct() {
        productList.get(0).click();
    }

    public void isAddToBagButtonVisible() {
        addToBagButton.isDisplayed();
    }

    public void clickSelectSizeField() {
        selectSizeField.click();
    }

    public void clickCurrentSize() {
        selectSize.click();
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public void isAddToBagPopupVisible() {
        addToBagButton.isDisplayed();
    }

    public void moveToBagPopup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(miniBagDropdownButton).pause(500);
    }

    public WebElement getViewBagButton() {
        return viewBagButton;
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public String checkErrorMessageWithoutSelectSize() {
        return errorMessage.getText();
    }
}
