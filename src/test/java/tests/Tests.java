package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Tests {
	//
	WebDriver driver;
	@Test
	public void test1()
	{
		  DesiredCapabilities options=new DesiredCapabilities();

	        // Create a new instance of the Chrome driver with the specified options
	        //http://3.95.160.237/ui/
		  options.setBrowserName("chrome");
		  options.setPlatform(Platform.LINUX);
			try {
				driver = new RemoteWebDriver(new URL("http://35.175.244.1/"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Navigate to a web page
	        driver.get("http://www.google.com");

	        // Print the title of the page
	        System.out.println("Title: " + driver.getTitle());

	        // Close the browser
	        driver.quit();
	}
	
	@Test
	public void test2()
	{
		  DesiredCapabilities options=new DesiredCapabilities();

	        // Create a new instance of the Chrome driver with the specified options
	        //http://3.95.160.237/ui/
		  options.setBrowserName("chrome");
		  options.setPlatform(Platform.LINUX);
			try {
				driver = new RemoteWebDriver(new URL("http://35.175.244.1/"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Navigate to a web page
	        driver.get("http://www.facebook.com");

	        // Print the title of the page
	        System.out.println("Title: " + driver.getTitle());
            System.out.println(driver.getCurrentUrl());
	        // Close the browser
	        driver.quit();
	}

}
