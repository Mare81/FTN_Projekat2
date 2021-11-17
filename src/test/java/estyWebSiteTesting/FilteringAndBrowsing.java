package estyWebSiteTesting;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import etsyWebSite.pages.ChooseAndSetUpBrowser;
import etsyWebSite.pages.FilteringAndBrowsingPages;
import etsyWebSite.pages.SignInPage;

public class FilteringAndBrowsing {

	public FilteringAndBrowsingPages filteringAndBrowsing;
	public String browser = "Chromedriver";
	public WebDriver driver;
	public ChooseAndSetUpBrowser utilClass;
	public int WaitTime = 3000;
	public String url = "https://www.etsy.com/";
	public SignInPage signIn;
	public String validEmail = "marko@gmail.com";
	public String validPassword = "Majofilip1";

	@BeforeTest
	public void setUrlAndSignIn() throws InterruptedException {

		utilClass = new ChooseAndSetUpBrowser(driver);
		driver = utilClass.chooseBrowserAndSetUrl(browser, url);
		signIn = new SignInPage(driver);
		filteringAndBrowsing = new FilteringAndBrowsingPages(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		signIn.getSignUpButton().click();
		signIn.signIn(validEmail, validPassword);
		Thread.sleep(WaitTime);

	}

	@AfterMethod
	public void refreshPage() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(WaitTime);
	}

	@AfterTest
	public void closeSelenium() {

		driver.close();
		System.out.println("Testing is successful!");
	}

	@Test(priority = 1, description = "User can search for the specific items using search bar")
	public void TC_FilteringAndBrowsing_001() throws InterruptedException {

		assertEquals(true,
				filteringAndBrowsing.getSearchBar().isDisplayed() && filteringAndBrowsing.getSearchBar().isEnabled());
		assertEquals(true, filteringAndBrowsing.getSearchButton().isDisplayed()
				&& filteringAndBrowsing.getSearchButton().isEnabled());
		Thread.sleep(WaitTime);

		filteringAndBrowsing.getSearchBar().click();
		filteringAndBrowsing.getSearchBar().clear();

		Thread.sleep(WaitTime);
		String searchItem = "Purse";
		filteringAndBrowsing.getSearchBar().sendKeys(searchItem);
		filteringAndBrowsing.getSearchButton().click();
		Thread.sleep(WaitTime);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.etsy.com/search?q=" + searchItem;

		if (actualUrl.equals(expectedUrl)) {
			System.out.println("Page of specific item/s with information is displayed!");

		}

	}

	@Test(priority = 2, description = "User can search for the specific items using dropdown menu")
	public void TC_FilteringAndBrowsing_002() throws InterruptedException {

		assertEquals(true, filteringAndBrowsing.getJewelryAndAccessoriesMenu().isDisplayed()
				&& filteringAndBrowsing.getJewelryAndAccessoriesMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getClothingAndShoesMenu().isDisplayed()
				&& filteringAndBrowsing.getClothingAndShoesMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getHomeAndLivingMenu().isDisplayed()
				&& filteringAndBrowsing.getHomeAndLivingMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getWeddingAndPartyMenu().isDisplayed()
				&& filteringAndBrowsing.getWeddingAndPartyMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getToysAndEntertainmentMenu().isDisplayed()
				&& filteringAndBrowsing.getToysAndEntertainmentMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getArtAndCollectibilesMenu().isDisplayed()
				&& filteringAndBrowsing.getArtAndCollectibilesMenu().isEnabled());
		assertEquals(true, filteringAndBrowsing.getVintageMenu().isDisplayed()
				&& filteringAndBrowsing.getVintageMenu().isEnabled());
		System.out.println("All dropdown menus are displayed and enabled");
		Thread.sleep(WaitTime);

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		String expectedTitle = "Jewelry & Accessories | Etsy";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 3, description = "User can fiter wanted items with colour filter")
	public void TC_FilteringAndBrowsing_003() throws InterruptedException {

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		List<WebElement> allColourCheckboxes = driver.findElements(By.xpath("//input[contains(@id,'attr_1-')]"));
		int expNumColCheckbox = 21;
		int actualNumColCheckbox = allColourCheckboxes.size();
		Thread.sleep(WaitTime);
		assertEquals(expNumColCheckbox, actualNumColCheckbox);
		Thread.sleep(WaitTime);
		filteringAndBrowsing.getColourCheckBox().click();
		Thread.sleep(WaitTime);
		WebElement blueFilterIcon = driver.findElement(By.xpath("//a[@aria-label='Remove Black Filter']"));
		if (blueFilterIcon.isDisplayed() && blueFilterIcon.isEnabled()) {

			System.out.println("Colour filter successful");

		}
		blueFilterIcon.click();

	}

	@Test(priority = 4, description = "User can fiter wanted items with price range filters")
	public void TC_FilteringAndBrowsing_004() throws InterruptedException {

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		Thread.sleep(WaitTime);
		List<WebElement> priceButtons = driver.findElements(By.xpath("//input[contains(@id,'price-input-')]"));
		int expectedPriceButtons = 6;
		int actualPricebuttons = priceButtons.size();
		assertEquals(expectedPriceButtons, actualPricebuttons);
		if (filteringAndBrowsing.getPriceButtonGroup().isDisplayed()
				&& filteringAndBrowsing.getPriceButtonGroup().isEnabled()) {

			System.out.println("All price radio buttons are displayed and enabled");
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,750)");

		WebElement priceRadioButton1 = driver.findElement(By.cssSelector("a[data-path='USD 50 to USD 100']"));

		if (!priceRadioButton1.isSelected()) {

			priceRadioButton1.click();
			System.out.println("Price radio button 1 is selected");
		}
		Thread.sleep(WaitTime);
		assertEquals(true, filteringAndBrowsing.getPriceFilterInfo().isDisplayed());

		System.out.println("Filtering with items with price range filter is successful!");

	}

	@Test(priority = 5, description = "User can sort wanted items with Sort by filter")
	public void TC_FilteringAndBrowsing_005() throws InterruptedException {

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		assertEquals(true, filteringAndBrowsing.getSortByButton().isDisplayed()
				&& filteringAndBrowsing.getSortByButton().isEnabled());
		filteringAndBrowsing.getSortByButton().click();
		if (filteringAndBrowsing.getSortByMenu().isDisplayed()) {
			System.out.println("Sort by menu is displayed");
			filteringAndBrowsing.getHighPriceButton().click();
		}
		assertEquals(true, filteringAndBrowsing.getHighPriceInfo().isDisplayed());
		Thread.sleep(WaitTime);
		System.out.println("Sort by function ok");
	}

	@Test(priority = 6, description = "User can fiter wanted items with custom price range filters")
	public void TC_FilteringAndBrowsing_006() throws InterruptedException {

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		Thread.sleep(WaitTime);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)");
		assertEquals(true, filteringAndBrowsing.getSearchFilterMinPriceInput().isDisplayed()
				&& filteringAndBrowsing.getSearchFilterMinPriceInput().isEnabled());
		assertEquals(true, filteringAndBrowsing.getSearchFilterMaxPriceInput().isDisplayed()
				&& filteringAndBrowsing.getSearchFilterMaxPriceInput().isEnabled());
		assertEquals(true, filteringAndBrowsing.getMinMaxPriceRangeButton().isDisplayed()
				&& filteringAndBrowsing.getMinMaxPriceRangeButton().isEnabled());

		System.out.println(
				"Search filter minimum price input, maximum price input and done button are displayed and enabled");

		String minPrice = "25";
		String maxPrice = "500";

		filteringAndBrowsing.setCustomPriceFilters(minPrice, maxPrice);

		Thread.sleep(WaitTime);
		String expectedText = "USD" + " " + minPrice + " " + "-" + " " + "USD" + " " + maxPrice;
		String actualText = filteringAndBrowsing.getCustomPriceFilterInfo().getText();

		if (filteringAndBrowsing.getCustomPriceFilterInfo().isDisplayed() && expectedText.equals(actualText)) {
			System.out.println("Filtering with items with custom price range filter is successful!");
		}

	}

	@Test(priority = 7, description = "User can fiter wanted items with shop location filter buttons")
	public void TC_FilteringAndBrowsing_007() throws InterruptedException {

		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		Thread.sleep(1500);
		List<WebElement> allShopLocationButtons = driver
				.findElements(By.xpath("//input[contains(@id,'shop-location-')]"));
		int expectedNumOfShopLocationButtons = 5;
		int actualNumOfShopLocationButtons = allShopLocationButtons.size();
		assertEquals(expectedNumOfShopLocationButtons, actualNumOfShopLocationButtons);
		System.out.println("All shop location filter buttons are present");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,750)");
		WebElement shopLocEurope = driver.findElement(By.xpath("//label[@for='shop-location-input-1']"));
		assertEquals(true, shopLocEurope.isEnabled());

		if (!shopLocEurope.isSelected()) {
			shopLocEurope.click();
			System.out.println("Europe shop location button is selected");

		}

		WebElement itemsFromEuropeFilter = driver.findElement(By
				.xpath("//a[@href='https://www.etsy.com/c/jewelry-and-accessories?explicit=1&q=&page_type=category']"));
		assertEquals(true, itemsFromEuropeFilter.isDisplayed());

	}

	@Test(priority = 8, description = "User can filter wanted items with item type filter")
	public void TC_FilteringAndBrowsing_008() throws InterruptedException {

		Thread.sleep(1500);
		filteringAndBrowsing.getJewelryAndAccessoriesMenu().click();
		List<WebElement> itemTypesButtons = driver.findElements(By.xpath("//input[contains(@id,'item-type-input-')]"));
		int expectedItemTypesButtons = 3;
		int numberOfItemTypesButton = itemTypesButtons.size();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,850)");
		boolean isEnabled = true;
		boolean isDisplayed = true;
		for (int i = 0; i < numberOfItemTypesButton; i++) {

			isDisplayed = itemTypesButtons.get(i).isDisplayed();
			isEnabled = itemTypesButtons.get(i).isEnabled();

		}

		if (expectedItemTypesButtons == numberOfItemTypesButton) {

			System.out.println("All item type buttons are displayed and enabled");

		}

		WebElement vintageItemTypeButton= driver.findElement(By.xpath("//label[@for='item-type-input-2']"));
		
		if (!vintageItemTypeButton.isSelected()) {
			vintageItemTypeButton.click();
		}
		Thread.sleep(WaitTime);
		WebElement vintageFilter=driver.findElement(By.xpath("//a[contains(@aria-label,'Vintage Filter')]"));
		assertEquals(true, vintageFilter.isDisplayed());
		
		

	}

}
