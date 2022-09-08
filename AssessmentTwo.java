package mavenProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssessmentTwo extends baseClass {
@Test(dataProvider="exceldata")
	
	public void salesforce(String fName, String lName , String Email ) {

	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/.")).click();
	driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/.")).sendKeys("contacts");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.findElement(By.xpath("//span[@class='slds-truncate label-display']//span//p")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//div[@title='New']")).click();
	driver.findElement(By.xpath("//button[@name='salutation']")).click();
	driver.findElement(By.xpath("(//span[@class='slds-media__body']/span)[2]")).click();
	
	WebElement typedFName = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[2]"));
	typedFName.sendKeys("fName");
	String firstName = typedFName.getAttribute("value");
	
	driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[3]")).sendKeys(lName);
	driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[10]")).sendKeys(Email);
	driver.findElement(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right']/input)[1]")).click();
	driver.findElement(By.xpath("//span[@title='New Account']")).click();
	driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input)[1]")).sendKeys("Credits");
	driver.findElement(By.xpath("//button[@title='Save']")).click();
	driver.findElement(By.xpath("//button[@title='Save']")).click();
	String contactName = driver.findElement(By.xpath("//span[@class='custom-truncate uiOutputText']")).getText();
	
	if (firstName.equals(contactName) ) {
		System.out.println("Given Name is "+contactName);
		
	} else {
		System.out.println("Entered name is not matched with the given name. Contact name is: "+contactName);
	}
	}
	@DataProvider(name="exceldata")
	public String[][] setData() throws IOException{
		return ReadDataExcel.readData();	
	
	}

}
