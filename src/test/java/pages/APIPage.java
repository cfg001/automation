package pages;

import org.openqa.selenium.By;

public class APIPage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "APIPage":
			by = By.xpath("//h2[text()='API']");
			break;
		case "Gender_Dropdown":
			by = By.xpath("//select[@name='apiGender']");
			break;	
		case "DateofBirth":
			by = By.xpath("//input[@name='apiDateOfBirth']");
			break;
		case "BookServicesButton":
			by = By.xpath("//button[contains(@title,'Click to book services')]");
			break;	
		case "DOCS":
			by = By.xpath("//span[contains(text(),'DOCS')]");
			break;
		case "Pax_select":
			by= By.xpath("//select[@id='epnrBookingGuidedFlowServicess1_servicesAssociations_paxSelect_id_input']");
			break;
			// Add other locators specific to the APIPage class
		}
		return by;
	}
}
