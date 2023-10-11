package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppUtils {
	
	public static WebDriver driver;
	
	public static void openApp(String url)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	public static void closeApp()
	{
		driver.close();
	}

}
