package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {	
		WebDriver driver;
		ReadPropertyFile readPropertyFile;
		
		protected WebDriver initalizeDriver() throws IOException{
		String currentPath = System.getProperty("user.dir");
		
		readPropertyFile = new ReadPropertyFile();
		String browser = readPropertyFile.getProperty("browser");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", currentPath+"//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "safari":
			System.setProperty("webdriver.safari.driver", currentPath+"//safaridriver.exe");
			driver = new SafariDriver();
			break;
		}	
		driver.get("http://google.com");					     
		driver.manage().window().maximize();	
		return driver;
	}
}
