package pages;

import org.openqa.selenium.By;

public class EticketPage {
	
	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "EticketPage":
			by = By.xpath("//h2[@class='ticketId']");
			break;
		case "EticketNumber":
			by = By.xpath("//h2[@class='ticketId']");
			break;
		case "PNRNumber":
			by = By.xpath("//a[@id='eticketings1_recLocLink']");
			break;		




			// Add other locators specific to the PNRPage class
		}
		return by;
	}

}
