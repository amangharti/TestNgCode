package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon {

	WebDriver driver;

	@BeforeMethod
	public void SetUpTest() {
		driver=browserconfig.BrowserConfig.open("chrome");
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
		
	}

	@DataProvider (name = "dataProvider" )
	public Object[][] getData() {
		return new Object[][] {
			{"All Videos"},{"Movies"},{"TV Shows"},{"Kids Shows"}
		};
	}

	@Test(dataProvider = "dataProvider")
	public void NavigateToAmazonPrimeVideo(String option) 
	{
		
		driver.findElement(By.id("nav-hamburger-menu")).click();
		//driver.findElement(By.xpath("//a[@data-menu-id='6']")).click();
		driver.findElement(By.xpath("//div[text()='Amazon Prime Video']")).click();
		//driver.findElement(By.xpath("//ul[contains(@class,'hmenu-visible')]/li/a[contains(., 'Amazon Prime Video')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//ul[contains(@class,'hmenu-visible')]/li/a[contains(., 'All Video')]")).click();
		driver.findElement(By.linkText(option)).click();

		String landingPage =driver.findElement(By.xpath("//h1[contains(.,'Welcome to Prime Video')]")).getText();
		Assert.assertEquals("Welcome to Prime Video", landingPage);

	}



	@AfterMethod
	public void After() {
		driver.quit();
		System.out.println("Task run successfully");
	}
}
