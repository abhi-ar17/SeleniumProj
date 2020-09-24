package testbase;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {
	
public static WebDriver driver;
	
	
	public static void launchBrowser(String url)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Browser to Launch :\n1.Chrome\n2.FireFox\n3.Internet Explorer\nEnter Your Choice : ");
		int choice = s.nextInt();
				
		
		switch(choice)
		{
		   case 1 :  //Launch Chrome Browser
			   		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			   		driver = new ChromeDriver(options);
		   			 break;
		   			 
		   case 2 :  //Launch FireFox Browser
			   		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			   		driver = new FirefoxDriver();
		   			 break;
		   			 
		   default : //Launch IE Browser 
			   		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			   		driver = new InternetExplorerDriver();
		}
		s.close();
		
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


}
