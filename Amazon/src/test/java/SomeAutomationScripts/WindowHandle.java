package SomeAutomationScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utils.AppUtils;

public class WindowHandle extends AppUtils {
	
	@Test
	public void windowHandle() throws InterruptedException
	{
		AppUtils.openApp("https://grotechminds.com/window-handle-and-handles/");
		driver.findElement(By.xpath("//button[text()='Launch Broweser 1']")).click();
		Thread.sleep(2000);
		String windowid=driver.getWindowHandle();
//		System.out.println(windowid);
		Set<String>ids=driver.getWindowHandles();
		for(String id:ids)
		{
			System.out.println(id);
			if(!id.equals(windowid))
			{
				driver.switchTo().window(id);
			}
		}
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Images")).click();
		driver.close();
		driver.switchTo().window(windowid);
		driver.findElement(By.xpath("//button[text()='Launch Broweser 1']")).click();
			
		
		
	
		
	}
	

}
