package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonPrimeVideo {
	
	WebDriver driver;

	@BeforeMethod
	public void SetUpTest() {
		driver=browserconfig.BrowserConfig.open("chrome");
		driver.get("https://amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Amazon(){
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.xpath("//div[text()='Amazon Prime Video']")).click();
		driver.findElement(By.xpath("//a[text()='All Videos']")).click();
		String landingPage =driver.findElement(By.xpath("//h1[contains(.,'Welcome to Prime Video')]")).getText();
		Assert.assertEquals("Welcome to Prime Video", landingPage);
	}
	
	@AfterTest
	public void After() {
		driver.quit();
		System.out.println("Test Completed Sucessfully");
	}
	
}
