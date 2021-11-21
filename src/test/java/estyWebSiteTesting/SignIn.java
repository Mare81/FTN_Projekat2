package estyWebSiteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.StandardSystemProperty;

import etsyWebSite.pages.ChooseAndSetUpBrowser;

import etsyWebSite.pages.SignInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.ObjectInputValidation;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SignIn {

	public SignInPage signIn;
	int WaitTime = 5000;
	public WebDriver driver;
	public ChooseAndSetUpBrowser utilClass;
	public String validEmail = "marko@gmail.com";
	public String validPassword = "Majofilip1";
	public String browser = "Chromedriver";
	public String url = "https://www.etsy.com/";

	@BeforeTest
	public void setUrl() throws InterruptedException {

		utilClass = new ChooseAndSetUpBrowser(driver);
		driver = utilClass.chooseBrowserAndSetUrl(browser, url);
		signIn = new SignInPage(driver);

	}

	@AfterMethod
	public void refreshPage() {

		driver.get(url);

	}

	@AfterTest

	public void closeSelenium()

	{
		System.out.println("Testing is successful!");
		driver.close();

	}

	@Test(priority = 1, description = "User can't register on website without entering email and password")
	public void TC_SignIn_001() throws InterruptedException {

		signIn.getSignUpButton().click();
		assertEquals(true, signIn.getSignUpMenu().isDisplayed() && signIn.getSignUpMenu().isEnabled());

		String blankemail = signIn.getEmail().getText();
		String blankPassword = signIn.getPassword().getText();
		assertEquals("", blankemail);
		assertEquals("", blankPassword);
		signIn.getSignInButton().click();

		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getEmailCantBeBlankMessage().isDisplayed());
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getPasswordCantBeBlankMessage().isDisplayed());

		String actualEmailMessage = signIn.getEmailCantBeBlankMessage().getText();
		String actualPasswordMessage = signIn.getPasswordCantBeBlankMessage().getText();
		String expectedEmailMessage = "Email can't be blank.";
		String expectedPasswordMessage = "Password can't be blank.";

		assertEquals(expectedEmailMessage, actualEmailMessage);
		assertEquals(expectedPasswordMessage, actualPasswordMessage);
		System.out.println("Right messages are displayed!");

	}

	@Test(priority = 2, description = "User can't register on website without entering email")
	public void TC_SignIn_002() throws InterruptedException {

		signIn.getSignUpButton().click();
		String blankEmail = "";
		signIn.setEmail(blankEmail);
		signIn.setPassword(validPassword);
		signIn.getSignInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getEmailCantBeBlankMessage().isDisplayed());
		String actualEmailMessage = signIn.getEmailCantBeBlankMessage().getText();
		String expectedEmailMessage = "Email can't be blank.";
		assertEquals(expectedEmailMessage, actualEmailMessage);
		System.out.println("Right message is displayed!");
	}

	@Test(priority = 3, description = "User can't register on website without entering password")
	public void TC_SignIn_003() throws InterruptedException {

		signIn.getSignUpButton().click();
		String blankPassword = "";
		signIn.setEmail(validEmail);
		signIn.setPassword(blankPassword);
		signIn.getSignInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getPasswordCantBeBlankMessage().isDisplayed());
		String actualPasswordMessage = signIn.getPasswordCantBeBlankMessage().getText();
		String expectedPasswordMessage = "Password can't be blank.";
		assertEquals(expectedPasswordMessage, actualPasswordMessage);
		System.out.println("Right message is displayed!");
	}

	@Test(priority = 4, description = "User can't sign in with invalid password")
	public void TC_SignIn_004() throws InterruptedException {

		signIn.getSignUpButton().click();
		String invalidPassword = "milskitu";
		signIn.setEmail(validEmail);
		signIn.setPassword(invalidPassword);
		signIn.getSignInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getinvalidPassword().isDisplayed());
		String actualInvalidPasswordMessage = signIn.getinvalidPassword().getText();
		String expectedInvalidPasswordMessage = "Password was incorrect";
		assertEquals(actualInvalidPasswordMessage, expectedInvalidPasswordMessage);
		System.out.println("Right message is displayed!");

	}

	@Test(priority = 5, description = "User can't sign in with invalid email")
	public void TC_SignIn_005() throws InterruptedException {

		signIn.getSignUpButton().click();
		String invalidEmail = "mlinki@gmail.com";
		signIn.setEmail(invalidEmail);
		signIn.setPassword(validPassword);
		signIn.getSignInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getSignininvalidEmailAddressMessage().isDisplayed());
		String actualInvalidEmailMessage = signIn.getSignininvalidEmailAddressMessage().getText();
		String expectedInvalidEmailMessage = "Email address is invalid.";
		assertEquals(actualInvalidEmailMessage, expectedInvalidEmailMessage);
		System.out.println("Right message is displayed!");

	}

	@Test(priority = 6, description = "User can sign in")
	public void TC_SignIn_006() throws InterruptedException {

		signIn.getSignUpButton().click();
		signIn.setEmail(validEmail);
		signIn.setPassword(validPassword);
		signIn.getSignInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, signIn.getFavoritesIcon().isDisplayed() && signIn.getFavoritesIcon().isEnabled());
		assertEquals(true, signIn.getAccountIcon().isDisplayed() && signIn.getAccountIcon().isEnabled());
		assertEquals(true, signIn.getUpdatesIcon().isDisplayed() && signIn.getUpdatesIcon().isEnabled());
		assertEquals(true, signIn.getWelcomeMessage().isDisplayed());
		System.out.println("Sign in is successful!");

	}

	@Test(priority = 5, description = "User can find help with signing in")
	public void TC_SignIn_007() {

		signIn.getSignUpButton().click();
		assertEquals(true, signIn.getTroubleSignInLink().isDisplayed() && signIn.getTroubleSignInLink().isEnabled());
		signIn.getTroubleSignInLink().click();
		String helppage = driver.getCurrentUrl();
		assertEquals("https://help.etsy.com/hc/en-us/articles/115015410188", helppage);
		System.out.println("Help page is displayed!");

	}

}
