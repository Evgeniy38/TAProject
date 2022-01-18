package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavedItemsPage extends BasePage {

    @FindBy(xpath = "//div[@class='customerItemsProductTile_2D72P']")
    private List<WebElement> wishListElements;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private List<WebElement> deleteButtonList;

    @FindBy(xpath = "//h1[contains(text(),'Saved Items')]")
    private WebElement header;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountProductsOnSavedItemsPage() {
        return wishListElements.size();
    }

    public void clickDeleteButtonFirstProduct() {
        deleteButtonList.get(0).click();
    }

    public WebElement getHeader() {
        return header;
    }

}
