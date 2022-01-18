package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'bag-contents-holder-panel bag-title-holder']")
    private WebElement bagHolder;

    @FindBy(xpath = "//button[@class = 'bag-item-remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//h2[contains(text(), 'Your bag is empty')]")
    private WebElement emptyBagTitle;

    public BagPage(WebDriver driver) {
        super(driver);
    }

    public String checkBagPage() {
        return bagHolder.getText();
    }

    public WebElement getElementVisibility() {
        return bagHolder;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public String emptyBagTitle() {
        return emptyBagTitle.getText();
    }
}
