package mavenProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssessmentOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Login to https://login.salesforce.com Credentials:
		 * ramkumar.ramaiah@testleaf.com Password$123 2. Click on toggle menu button
		 * from the left corner 3. Click view All and click Sales from App Launcher
		 * 4.Click on Opportunity tab 5. Click on New button 6. Enter Opportunity name
		 * as'Salesforce Automation by *Your Name*,Get the text and Store it 7. Choose
		 * close date as Today 8. Select 'Stage' as Need Analysis 9. click Save and
		 * VerifyOppurtunity Name"
		 * 
		 * 
		 * Expected Result:New Opportunity should be created with name as 'Salesforce
		 * Automation by *Your Name*'
		 */

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//p[text()=\"Sales\"]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//a[@title='Opportunities']//..")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement val = driver.findElement(By.xpath("//input[@name='Name']"));
		val.sendKeys("Salesforce Automation by Rameshkumar Kandsamy");
		String typed = val.getAttribute("value");
		System.out.println(typed);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("8/03/2022");
		driver.findElement(By.xpath("//div[@role='none']/button")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}

}
