package com.next.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.next.errors.InvalidBrowserNameError;

public class BaseTest {

	public RemoteWebDriver driver;
	
	@Parameters("browser-name")
	@BeforeMethod
	public void setup(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
	    driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Microsoft Edge")){
			driver = new EdgeDriver();
		}else{
			throw new InvalidBrowserNameError(browserName);
			//System.out.println("Invalid browser name :" + browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.next.co.uk");
		
		long start = System.currentTimeMillis();
	    driver.get("https://www.next.co.uk");
	    long loadTime = System.currentTimeMillis() - start;
	    System.out.println("Page Load Time (driver.get): " + loadTime + " ms");
		
		
		try {
		    WebElement cookieAccept = driver.findElement(By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]"));
		    cookieAccept.click();
		    System.out.println("Cookies popup closed!");
		    Thread.sleep(1000);
		} catch (Exception e) {
		    System.out.println("No cookie popup found, continuing...");
		}

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
}
