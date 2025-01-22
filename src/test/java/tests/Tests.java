package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tests {
	//

	@Test
	public void test1() {

		// which machine,

		WebDriver driver = new ChromeDriver();

		// Navigate to a web page
		driver.get("http://www.google.com");

		// Print the title of the page
		System.out.println("Title: " + driver.getTitle());

		// Close the browser
		driver.quit();
	}

}
