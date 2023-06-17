package pages;

import org.openqa.selenium.By;

public class PricingPage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "PricingPage":
			by = By.xpath("//li[contains(@class,'current')][contains(text(),'Pricing')]");
			break;
		case "AllPrices_Tab":
			by = By.xpath("//em[text()='All Prices']");
			break;
		case "UpdateFares_Button":
			by = By.xpath("//button[contains(@title,'Click to update fares')]");
			break;	
		case "ConfirmPrice_Button":
			by = By.xpath("//button[contains(@title,'Confirm the price')]");
			break;		
				}
		return by;
	}

}
