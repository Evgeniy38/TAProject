package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class = '_3J74XsK']")
    private List<WebElement> searchResultProductsList;

    @FindBy(xpath = "//h2[contains(text(),'NOTHING')]")
    private WebElement header;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> wishListButton;

    @FindBy(xpath = "//button[@aria-label='Item saved']")
    private List<WebElement> wishListButtonAdded;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement heartButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultProductList() {
        return searchResultProductsList;
    }

    public String getTextHeader() {
        return header.getText();
    }

    public void clickFirstWishListButton() {
        wishListButton.get(0).click();
    }

    public void clickSecondWishListButton() {
        wishListButton.get(1).click();
    }

    public void clickFourthWishListButton() {
        wishListButton.get(3).click();
    }

    public int getAmountOfProductsInWishList() {
        return wishListButtonAdded.size();
    }

    public void clickOnHeartButton() {
        heartButton.click();
    }
}
