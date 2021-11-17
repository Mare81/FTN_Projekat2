package estyWebSiteTesting;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import etsyWebSite.pages.ChooseAndSetUpBrowser;
import etsyWebSite.pages.SignInPage;

public class RegisterIn {

	public SignInPage login;
	public WebDriver driver;
	public String browser = "Chromedriver";
	public ChooseAndSetUpBrowser utilClass;
	public String url = "https://www.etsy.com/";
	public String Firstname = "Marko";
	public String validEmail = "marko@gmail.com";
	public String validPassword = "Majofilip1";
	int WaitTime = 3000;

	@BeforeClass
	public void setUrl() throws InterruptedException {

		utilClass = new ChooseAndSetUpBrowser(driver);
		driver = utilClass.chooseBrowserAndSetUrl(browser, url);
		login = new SignInPage(driver);
		Thread.sleep(WaitTime);

	}

	@AfterMethod
	public void clearInputFields() {

		login.clearInputFields();

	}

	@AfterClass

	public void closeSelenium()

	{

		System.out.println("Everything is fine");
		driver.close();

	}

	@Test(priority = 1, description = "User can't register on website without entering email, name, password ")
	public void TC_RegisterIn_001() throws InterruptedException {

		login.getSignUpButton().click();
		Thread.sleep(1500);
		assertEquals(true, login.getEmail().isDisplayed() && login.getEmail().isEnabled());
		assertEquals(true, login.getPassword().isDisplayed() && login.getPassword().isEnabled());
		assertEquals(true, login.getContinuewithButtons().isDisplayed() && login.getContinuewithButtons().isEnabled());
		assertEquals(true, login.getPrivacypolicy().isDisplayed());

		System.out.println("Signin menu is displayed and enabled");

		Thread.sleep(WaitTime);

		if (login.getRegisterButton().isDisplayed() && login.getRegisterButton().isEnabled()) {
			login.getRegisterButton().click();
		}
		Thread.sleep(WaitTime);
		assertEquals(true, login.getEmail().isDisplayed() && login.getEmail().isEnabled());
		assertEquals(true, login.getFirstName().isDisplayed() && login.getFirstName().isEnabled());
		assertEquals(true, login.getPassword().isDisplayed() && login.getPassword().isEnabled());

		System.out.println("Create your account menu is displayed and enabled");
		Thread.sleep(WaitTime);

		String blankemail = login.getEmail().getText();
		String blankFirstName = login.getFirstName().getText();
		String blankPassword = login.getPassword().getText();
		assertEquals("", blankFirstName);
		assertEquals("", blankemail);
		assertEquals("", blankPassword);

		assertFalse(login.getRegisterInButton().isEnabled());
		System.out.println("You can not register without fillinig in email, first name and password!");

	}

	@Test(priority = 2, description = "User can't register on website without entering email")
	public void TC_RegisterIn_002() throws InterruptedException

	{

		/*
		 * login.getSignUpButton().click(); Thread.sleep(1500); if
		 * (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) { login.getRegisterButton().click(); }
		 */
		login.setEmail("");
		login.setFirstName(Firstname);
		login.setPassword(validPassword);
		login.getRegisterInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, login.getEmailCantBeBlankMessage().isDisplayed());

	}

	@Test(priority = 3, description = "User can't register on website without entering first name")
	public void TC_RegisterIn_003() throws InterruptedException

	{
		/*
		 * login.getSignUpButton().click(); Thread.sleep(1500); if
		 * (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) { login.getRegisterButton().click(); }
		 */

		login.setEmail(validEmail);
		login.setFirstName("");
		login.setPassword(validPassword);
		login.getRegisterInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, login.getFirstnameCantBeBlankMessage().isDisplayed());

	}

	@Test(priority = 4, description = "User can't register on website without entering password")
	public void TC_RegisterIn_004() throws InterruptedException

	{
		/*
		 * login.getSignUpButton().click(); Thread.sleep(1500); if
		 * (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) { login.getRegisterButton().click(); }
		 */
		login.setEmail(validEmail);
		login.setFirstName(Firstname);
		login.setPassword("");
		login.getRegisterInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, login.getPasswordCantBeBlankMessage().isDisplayed());

	}

	@Test(priority = 5, description = "User can't register with invalid mail address")
	public void TC_RegisterIn_005() throws InterruptedException {

		/*
		 * login.getSignUpButton().click(); Thread.sleep(1500); if
		 * (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) { login.getRegisterButton().click(); }
		 * Thread.sleep(WaitTime);
		 */
		String invalidEmail = "$%ty*jovi@gmail.com";
		login.setEmail(invalidEmail);
		login.setFirstName(Firstname);
		login.setPassword(validPassword);
		login.getRegisterInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, login.getinvalidEmailAddressMessage().isDisplayed());

	}

	@Test(priority = 6, description = "User can't register with invalid first name")
	public void TC_RegisterIn_006() throws InterruptedException {

		/*
		 * login.getSignUpButton().click(); Thread.sleep(1500); if
		 * (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) { login.getRegisterButton().click(); }
		 */
		Thread.sleep(WaitTime);
		String invalidName = "!#Dragana";

		login.setEmail(validEmail);
		login.setFirstName(invalidName);
		login.setPassword(validPassword);
		login.getRegisterInButton().click();
		Thread.sleep(WaitTime);
		assertEquals(true, login.getinvalidFirstNameMessage().isDisplayed());

	}

	@Test(priority = 7, description = "User can register on website")

	public void TC_RegisterIn_007() throws InterruptedException {

		/*
		 * login.getSignUpButton().click();
		 * 
		 * if (login.getRegisterButton().isDisplayed() &&
		 * login.getRegisterButton().isEnabled()) {
		 * 
		 * Thread.sleep(WaitTime); login.getRegisterButton().click();
		 * 
		 * }
		 */

		login.setEmail(validEmail);
		login.setFirstName(Firstname);
		login.setPassword(validPassword);
		Thread.sleep(WaitTime);
		if (login.getRegisterInButton().isEnabled() && login.getRegisterInButton().isDisplayed()) {

			login.getRegisterInButton().click();

		}
		Thread.sleep(WaitTime);
		assertEquals(true, login.getFavoritesIcon().isDisplayed() && login.getFavoritesIcon().isEnabled());
		assertEquals(true, login.getAccountIcon().isDisplayed() && login.getAccountIcon().isEnabled());
		assertEquals(true, login.getUpdatesIcon().isDisplayed() && login.getUpdatesIcon().isEnabled());
		System.out.println("Registration successful!");

	}

}
