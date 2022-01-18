package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type = 'search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class = 'kH5PAAC _1KRfEms']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'product-hero']")
    private WebElement currentProduct;

    @FindBy(xpath = "//a[@data-testid = 'miniBagIcon']")
    private WebElement bagButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSearchFileVisible(){
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isCurrentProductVisible() {
        return currentProduct.isDisplayed();
    }

    public void clickOnBagButton() {
        bagButton.click();
    }

}
