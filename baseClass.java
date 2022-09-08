package mavenProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public ChromeDriver driver;
	
	
	@Test
	@Parameters({"username","password", "url"})
	
	public void basiclogin(String username, String password , String url ) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	WebDriverManager.firefoxdriver().setup();
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(option);

	driver.get(url);
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("Login")).click();
	System.out.println(driver.getTitle());
	}
}
