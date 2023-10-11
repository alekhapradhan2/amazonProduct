package SomeAutomationScripts;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.AppUtils;

public class ProductCount extends AppUtils {
	
	@Test
	public void countTotalProduct()throws InterruptedException 
	{
		AppUtils.openApp("https://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> computers = new ArrayList<>();
		computers=driver.findElements(By.xpath("//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')]"));
		
		int totalitems=computers.size();

		WebElement next=driver.findElement(By.xpath("//*[contains(@class,'s-pagination-next')]"));
		String data=next.getAttribute("class");
		while(!data.contains("disabled"))
		{
			Thread.sleep(1000);
			next.click();
			driver.navigate().refresh();
			next=driver.findElement(By.xpath("//*[contains(@class,'s-pagination-next')]"));
			data=next.getAttribute("class");
			computers=driver.findElements(By.xpath("//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')]"));
			totalitems=totalitems+computers.size();
		}
		System.out.println(totalitems);
		AppUtils.closeApp();
		
		
	}

}
