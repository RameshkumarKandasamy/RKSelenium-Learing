package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class ContentPage extends ProjectSpecificMethods {
		
		public ChatterPage clickChatter() {
			
			clickUsingJs(locateElement(Locators.XPATH, "//span[text()='Chatter']"));
			reportStep("Chatter tab is clicked successfully","pass");
			return new ChatterPage();
		}


}
