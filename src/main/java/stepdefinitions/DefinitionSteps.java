package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 20;

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    BagPage bagPage;
    SavedItemsPage savedItemsPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void userOpensHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks current product visibility")
    public void userChecksCurrentProductProductVisibility() {
        homePage.isCurrentProductVisible();
    }

    @Then("User checks current products {string} category visibility")
    public void userChecksCurrentProductsCategoryVisibility(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        for (WebElement element : searchResultsPage.getSearchResultProductList()) {
            assertTrue(element.getText().toLowerCase().contains(keyword));
        }
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFileVisible();
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnFirstProduct();
    }

    @And("User checks ADD TO BAG button visibility")
    public void userChecksADDTOBAGButtonVisibility() {
        productPage.isAddToBagButtonVisible();
    }

    @And("User clicks size select field")
    public void userClicksSizeSelectField() {
        productPage.clickSelectSizeField();
    }

    @And("User clicks current size")
    public void userClicksCurrentSize() {
        productPage.clickCurrentSize();
    }

    @And("User clicks ADD TO BAG button on product")
    public void userClicksADDTOBAGButtonOnProduct() {
        productPage.clickAddToBagButton();
    }

    @And("User checks that add to bag popup is visible")
    public void userChecksThatAddToBagPopupIsVisible() {
        productPage.isAddToBagPopupVisible();
    }

    @And("User moves My Bag button")
    public void userMovesMyBagButton() {
        productPage.moveToBagPopup();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getViewBagButton());
    }

    @And("User clicks VIEW BAG button")
    public void userClicksVIEWBAGButton() {
        productPage.clickViewBagButton();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that bag page header is {string}")
    public void userChecksThatBagPageHeaderIsBagHeader(final String bagHeader) {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getElementVisibility());
        assertTrue(bagPage.checkBagPage().contains(bagHeader));
    }

    @And("User checks that current url contains keyword {string}")
    public void userChecksThatCurrentUrlContainsKeywordWrongKeyword(final String wrongKeyword) {
        assertTrue(driver.getCurrentUrl().contains(wrongKeyword));
    }

    @Then("User checks lack of products with {string}")
    public void userChecksLackOfProductsWithSearchHeader(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertTrue(searchResultsPage.getTextHeader().contains(keyword));
    }

    @And("User clicks wish list on first product")
    public void userClicksWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickFirstWishListButton();
    }

    @And("User clicks wish list on second product")
    public void userClicksWishListOnSecondProduct() {
        searchResultsPage.clickSecondWishListButton();
    }

    @And("User clicks wish list on fourth product")
    public void userClicksWishListOnFourthProduct() {
        searchResultsPage.clickFourthWishListButton();
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void userChecksThatAmountOfProductsInWishListAreAmountOfProducts(final String amount) {
        assertEquals(Integer.parseInt(amount), searchResultsPage.getAmountOfProductsInWishList());
    }

    @When("User clicks on heart button")
    public void userClicksOnHeartButton() {
        searchResultsPage.clickOnHeartButton();
    }


    @And("User checks that amount of products in saved list are {string}")
    public void userChecksThatAmountOfProductsInSavedListAreAmount(final String amount) {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getHeader());
        assertEquals(Integer.parseInt(amount), savedItemsPage.getAmountProductsOnSavedItemsPage());
    }

    @And("User clicks delete button on first product")
    public void userClicksDeleteButtonOnFirstProduct() {
        savedItemsPage.clickDeleteButtonFirstProduct();
    }

    @Then("User checks that products decrease by one {string}")
    public void userChecksThatProductsDecreaseByOneFinishAmount(String amount) {
        assertEquals(Integer.parseInt(amount), savedItemsPage.getAmountProductsOnSavedItemsPage());
    }

    @Then("User checks the {string}")
    public void userChecksTheMessage(final String message) {
        assertTrue(productPage.checkErrorMessageWithoutSelectSize().contains(message));
    }

    @And("User checks remove button visibility")
    public void userChecksRemoveButtonVisibility() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        bagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, bagPage.getElementVisibility());
        assertTrue(bagPage.getRemoveButton().isDisplayed());
    }

    @And("User clicks remove button")
    public void userClicksRemoveButton() {
        bagPage.clickRemoveButton();
        bagPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
    }

    @Then("User checks that the bag is empty {string} visibility")
    public void userChecksThatTheBagIsEmptyTextVisibility(final String text)  {

        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        assertTrue(bagPage.emptyBagTitle().contains(text));
    }

    @And("User clicks My Bag button")
    public void userClicksMyBagButton() {
        homePage.clickOnBagButton();
    }

    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsCurrentUrl(final String textUrl) {
        assertTrue(driver.getCurrentUrl().contains(textUrl));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
