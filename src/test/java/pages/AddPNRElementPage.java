package pages;

import org.openqa.selenium.By;

public class AddPNRElementPage {
	
	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "AddPNRElementPage":
			by = By.xpath("//li[contains(@class,'current')][contains(text(),'Add PNR Element')]");
			break;
		case "SSR_API":
			by = By.xpath("//a[text()='API']");
			break;	
		case "NextStep_Button":
			by = By.xpath("//button[@title='Move to the next step of the flow.']");
			break;		
			
			// Add other locators specific to the AddPNRElementPage class
		}
		return by;
	}

}
