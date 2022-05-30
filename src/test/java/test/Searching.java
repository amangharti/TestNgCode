package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Searching {
	
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
		//driver.findElement(By.xpath("//ul[contains(@class,'hmenu-visible')]/li/a[contains(.,'All Videos')]")).click();
		driver.findElement(By.className("hmenu-close-icon")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Kids Movies");
		driver.findElement(By.id("nav-search-submit-text")).click();
	}
	
	@AfterTest
	public void After() {
		driver.quit();
		System.out.println("Test Completed Sucessfully");
	}
	
}
