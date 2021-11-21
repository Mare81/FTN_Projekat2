package etsyWebSite.pages;

import java.awt.Point;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bsh.util.Util;

public class SignInPage {

	private final int WaitTime = 3000;
	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSignUpButton() {
		return Utils.waitForElementPresence(driver, By.cssSelector("button.wt-mr-xs-1"), WaitTime);
	}

	public WebElement getSignUpMenu() {
		return Utils.waitForElementPresence(driver, By.id("join-neu-form"), WaitTime);
	}

	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.name("email"), WaitTime);
	}

	public WebElement getCloseButton() {

		return Utils.waitToBeClickable(driver, By.xpath(
				"//button[@class='wt-btn wt-btn--transparent wt-btn--icon wt-overlay__close-icon wt-btn--light']"),
				WaitTime);

	}

	public WebElement getContinueButton() {

		return Utils.waitForElementPresence(driver,
				By.xpath("//button[@aria-describedby='aria-privacy-policy' and @name='submit_attempt']"), WaitTime);

	}

	public WebElement getContinuewithButtons() {

		return Utils.waitToBeClickable(driver, By.xpath("//*[@class='wt-btn wt-btn--secondary wt-width-full']"),
				WaitTime);

	}

	public WebElement getPrivacypolicy() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[@id='aria-privacy-policy']"), WaitTime);

	}

	public WebElement getFirstName() {
		return Utils.waitForElementPresence(driver, By.name("first_name"), WaitTime);

	}

	public WebElement getPassword() {
		return Utils.waitForElementPresence(driver, By.id("join_neu_password_field"), WaitTime);
	}

	public void setEmail(String email) {

		WebElement emailInput = getEmail();
		emailInput.click();
		emailInput.clear();
		emailInput.sendKeys(email);

	}

	public void setFirstName(String firstName) {

		WebElement firstNameInput = getFirstName();
		firstNameInput.click();
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);

	}

	public void setPassword(String password) {

		WebElement passwordInput = getPassword();
		passwordInput.click();
		passwordInput.clear();
		passwordInput.sendKeys(password);

	}

	public void signIn(String email, String password) throws InterruptedException {

		setEmail(email);
		setPassword(password);
		getSignInButton().click();

	}
	
	public void clearInputFields() {
		
		WebElement getEmail=getEmail();
		WebElement getFirstName=getFirstName();
		WebElement getPassword=getPassword();
		getEmail.click();
		getEmail.clear();
		getFirstName.click();
		getFirstName.clear();
		getPassword.click();
		getPassword.clear();
		
		
	}
	
	
	

	public WebElement getCreateAccountMenu() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"join-neu-form\"]"), WaitTime);
	}

	public WebElement getInvalidRegisterMessage() {

		return Utils.waitForElementPresence(driver, By.id("aria-join_neu_email_field-error"), WaitTime);

	}

	public WebElement getRegisterButton() {

		return Utils.waitToBeClickable(driver, By.cssSelector("button.wt-btn.wt-btn--secondary.wt-btn--small"),
				WaitTime);

	}

	public WebElement getRegisterInButton() {

		return Utils.waitForElementPresence(driver, By.xpath("//div/button[@value='register']"), WaitTime);

	}

	public WebElement getTroubleButton() {

		return Utils.waitForElementPresence(driver, By.xpath("//p/a[@href='/help/article/18?ref=signin']"), WaitTime);

	}

	public WebElement getFavoritesIcon() {

		return Utils.waitForElementPresence(driver, By.xpath("//a[@aria-labelledby='ge-tooltip-label-favorites']"),
				WaitTime);

	}

	public WebElement getAccountIcon() {

		return Utils.waitForElementPresence(driver,
				By.cssSelector("button.wt-menu__trigger[aria-describedby='ge-tooltip-label-you-menu']"), WaitTime);

	}

	public WebElement getUpdatesIcon() {

		return Utils.waitForElementPresence(driver,
				By.cssSelector("button.wt-menu__trigger[aria-describedby='ge-tooltip-label-notifications']"), WaitTime);
	}

	public WebElement getWelcomeMessage() {

		return Utils.waitForElementPresence(driver, By.cssSelector("h1.welcome-message-text"), WaitTime);

	}

	public WebElement getFirstnameCantBeBlankMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[@id='aria-join_neu_first_name_field-error']"),
				WaitTime);

	}

	public WebElement getEmailCantBeBlankMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[@id='aria-join_neu_email_field-error']"), WaitTime);

	}

	public WebElement getPasswordCantBeBlankMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[@id='aria-join_neu_password_field-error']"),
				WaitTime);

	}

	public WebElement getSignInButton() {

		return Utils.waitToBeClickable(driver, By.cssSelector("button.wt-btn[value='sign-in'] "), WaitTime);

	}
	
	public WebElement getinvalidFirstNameMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[text()='Your first name contains invalid characters.']"), WaitTime);

	}
	
	
	public WebElement getinvalidEmailAddressMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[text()='Please enter a valid email address.']"), WaitTime);

	}
	
	public WebElement getSignininvalidEmailAddressMessage() {

		return Utils.waitForElementPresence(driver, By.xpath("//div[text()='Email address is invalid.']"), WaitTime);

	}
	
	

	public WebElement getinvalidPassword() {

		return Utils.waitForElementPresence(driver, By.xpath("//*[text()='Password was incorrect']"), WaitTime);

	}

	public WebElement getTroubleSignInLink() {

		return Utils.waitForElementPresence(driver, By.linkText("Trouble signing in?"), WaitTime);

	}

	

}
