package etsyWebSite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChooseAndSetUpBrowser {

	public WebDriver driver;

	public ChooseAndSetUpBrowser(WebDriver driver) {

		super();
		this.driver = driver;

	}

	public WebDriver chooseBrowserAndSetUrl(String browser, String url) {

		if (browser == "Firefox") {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browser == "Chromedriver") {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		
		return driver;
	}

}
