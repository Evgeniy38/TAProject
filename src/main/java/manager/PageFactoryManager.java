package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public BagPage getBagPage() {
        return new BagPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SavedItemsPage getSavedItemsPage(){
        return new SavedItemsPage(driver);
    }

}
