package etsyWebSite.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import okhttp3.internal.Util;

public class FilteringAndBrowsingPages {

	private WebDriver driver;
	int WaitTime = 2500;

	public FilteringAndBrowsingPages(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSearchBar() {
		return Utils.waitForElementPresence(driver, By.id("global-enhancements-search-query"), WaitTime);
	}

	public WebElement getSearchButton() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@data-id='gnav-search-submit-button']"),
				WaitTime);
	}

	public WebElement getNameOfGroupItems() {
		return Utils.waitForElementPresence(driver, By.id("catnav-primary-link-10855"), WaitTime);
	}

	public WebElement getJewelryAndAccessoriesMenu() {

		return Utils.waitToBeClickable(driver, By.xpath(
				"//a[@href='/c/jewelry-and-accessories?ref=catnav-10855' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getmenuPageTitle() {

		return Utils.waitForElementPresence(driver, By.xpath("//h1[text()='Jewelry & Accessories']"), WaitTime);

	}

	public WebElement getClothingAndShoesMenu() {

		return Utils.waitToBeClickable(driver,
				By.xpath("//a[@href='/c/clothing-and-shoes?ref=catnav-10923' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getHomeAndLivingMenu() {

		return Utils.waitToBeClickable(driver,
				By.xpath("//a[@href='/c/home-and-living?ref=catnav-891' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getWeddingAndPartyMenu() {

		return Utils.waitToBeClickable(driver,
				By.xpath("//a[@href='/c/wedding-and-party?ref=catnav-10983' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getToysAndEntertainmentMenu() {

		return Utils.waitToBeClickable(driver, By.xpath(
				"//a[@href='/c/toys-and-entertainment?ref=catnav-11049' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getArtAndCollectibilesMenu() {

		return Utils.waitToBeClickable(driver,
				By.xpath("//a[@href='/c/art-and-collectibles?ref=catnav-66' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getSuppliesAndToolsMenu() {

		return Utils.waitToBeClickable(driver, By.xpath(
				"//a[@href='/c/craft-supplies-and-tools?ref=catnav-562' and @class='wt-text-link-no-underline']"),
				WaitTime);

	}

	public WebElement getVintageMenu() {

		return Utils.waitToBeClickable(driver, By.xpath("//span[text()='Vintage']"), WaitTime);

	}

	public WebElement getPriceButtonGroup() {

		return Utils.waitForElementPresence(driver, By.cssSelector("div.container[role='radiogroup']"), WaitTime);

	}

	public WebElement getPriceFilterInfo() {

		return Utils.waitForElementPresence(driver, By.xpath("//a[@aria-label='Remove USD 50 &ndash; USD 100 Filter']"),
				WaitTime);

	}

	public WebElement getSearchFilterMinPriceInput() {

		return Utils.waitForElementPresence(driver, By.xpath("//input[@id='search-filter-min-price-input']"), WaitTime);

	}

	public WebElement getSearchFilterMaxPriceInput() {

		return Utils.waitForElementPresence(driver, By.xpath("//input[@id='search-filter-max-price-input']"), WaitTime);

	}

	public WebElement getCustomPriceFilterInfo() {

		return Utils.waitForElementPresence(driver, By.xpath(
				"//a[@class='wt-btn wt-action-group__item wt-btn--small wt-display-flex-xs wt-align-items-center']"),
				WaitTime);

	}

	public WebElement getMinMaxPriceRangeButton() {

		return Utils.waitToBeClickable(driver, By.xpath("//button[@data-context='price']"), WaitTime);

	}

	public WebElement getRadioButton() {

		return Utils.waitToBeClickable(driver, By.xpath(
				"/html/body/div[5]/div/div[1]/div/div[4]/div[1]/div/div/form/div[4]/fieldset/div/div/div[2]/a/label"),
				WaitTime);
	}

	public WebElement getSortByMenu() {

		return Utils.waitForElementPresence(driver,
				By.xpath("//div[@role='menu' and @class='wt-menu__body wt-menu__body--will-animate']"), WaitTime);

	}

	public WebElement getColourCheckBox() {

		return Utils.waitToBeClickable(driver, By.xpath("//div/a/label[@for='attr_1-1']"), WaitTime);

	}

	public WebElement getColourInfo() {

		return Utils.waitForElementPresence(driver,
				By.xpath("/html/body/div[5]/div/div[1]/div/div[4]/div[2]/div[2]/div[2]/ul/li/ul/li/a"), WaitTime);

	}

	public WebElement getPriceInfo() {

		return Utils.waitForElementPresence(driver,
				By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[2]/div[2]/div[2]/ul/li"), WaitTime);

	}

	public WebElement getSortByButton() {

		return Utils.waitToBeClickable(driver,
				By.cssSelector("button.wt-menu__trigger.wt-btn--small[aria-haspopup='true']"), WaitTime);
	}

	public WebElement getHighPriceButton() {

		return Utils.waitToBeClickable(driver,
				By.xpath("//div[@role='menu' and @class='wt-menu__body wt-menu__body--will-animate']/a[3]"), WaitTime);

	}

	public WebElement getHighPriceInfo() {

		return Utils.waitForElementPresence(driver, By.xpath("//span[text()='Sort by: Highest Price']"), WaitTime);
	}

	public WebElement getAnywhereShopLocationButton() {

		return Utils.waitToBeClickable(driver, By.xpath("//label[@for='shop-location-input-0']"), WaitTime);

	}

	public WebElement getEuropeShopLocationButton() {

		return Utils.waitToBeClickable(driver, By.xpath("//label[@for='shop-location-input-1']"), WaitTime);

	}
	
	
public void setCustomPriceFilters(String minPrice, String maxPrice) {
		
		WebElement getMinPriceInput=getSearchFilterMinPriceInput();
		WebElement getMaxPriceInput=getSearchFilterMaxPriceInput();
		getMinPriceInput.click();
		getMinPriceInput.clear();
		getMinPriceInput.sendKeys(minPrice);
		getMaxPriceInput.click();
		getMaxPriceInput.clear();
		getMaxPriceInput.sendKeys(maxPrice);
		getMinMaxPriceRangeButton().click();
		
		
		
		
	}
	
	
	
	
	
	
	

}
