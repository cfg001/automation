package pages;

import org.openqa.selenium.By;


public class PNRPage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "PNRPage":
			by = By.xpath("//table[contains(@class,'pnrInfoTable')]");
			break;
		case "PNR_tab":
			by = By.xpath("//a[contains(@id,'pnrLink')]");
			break;
		case "Eticket_link":
			by = By.xpath("//a[@title='Click to show E-ticket details']");
			break;		




			// Add other locators specific to the PNRPage class
		}
		return by;
	}
}


