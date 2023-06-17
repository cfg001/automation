package pages;

import org.openqa.selenium.By;

public class HomePage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "HomePage":
		by = By.xpath("//span[contains(text(),'TEST (UAT)')]");
		break;
		case "PNRBookingFlow_link":
		by = By.xpath("//a[contains(text(),'PNR Booking Flow')][@aria-label='Create New PNR Booking Flow']");
		break;
		
		// Add other locators specific to the HomePage class
		}
		return by;
		}

}
