package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	public HomePage verifyHomePage() {
		verifyDisplayed(locateElement(Locators.CLASS_NAME, "slds-icon-waffle"));
		reportStep("Homepage is loaded", "pass");
		return this;
		
	}
	public HomePage clickIcon() {
		click(locateElement(Locators.CLASS_NAME, "slds-icon-waffle"));
		reportStep("Icon is clicked", "pass");
		return this;
		
	}
	public HomePage clickViewAll() {
		click(locateElement(Locators.XPATH, "//button[text()='View All']"));
		reportStep("View All is clicked successfully","pass");
		return this;
	}
	
	public HomePage searchContent() {
		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Search apps or items...']"), "Content");
		reportStep("Content is entered successfully","pass");
		return this;
	}
	
	public ContentPage clickContent() {
		click(locateElement(Locators.XPATH, "//mark[text()='Content']"));
		reportStep("Content is clicked successfully","pass");
		return new ContentPage();
	}
	
}
