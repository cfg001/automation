package pages;

import org.openqa.selenium.By;

public class PassengerDetailsPage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "PassengerDetailsPage":
			by = By.xpath("//span[contains(@id,'lastName0')]//input");
			break;
		case "Lastname_1":
			by = By.xpath("//span[contains(@id,'lastName0')]//input");
			break;
		case "Firstname_1":
			by = By.xpath("//span[contains(@id,'firstName0')]//input");
			break;
		case "PTC_1":
			by = By.xpath("//span[contains(@id,'ptc0')]//input");
			break;
		case "Lastname_2":
			by = By.xpath("//span[contains(@id,'lastName1')]//input");
			break;
		case "Firstname_2":
			by = By.xpath("//span[contains(@id,'firstName1')]//input");
			break;
		case "PTC_2":
			by = By.xpath("//span[contains(@id,'ptc1')]//input");
		case "Lastname_3":
			by = By.xpath("//span[contains(@id,'lastName2')]//input");
			break;
		case "Firstname_3":
			by = By.xpath("//span[contains(@id,'firstName2')]//input");
			break;
		case "PTC_3":
			by = By.xpath("//span[contains(@id,'ptc2')]//input");	
			break;	
		case "Lastname_4":
			by = By.xpath("//span[contains(@id,'lastName3')]//input");
			break;
		case "Firstname_4":
			by = By.xpath("//span[contains(@id,'firstName3')]//input");
			break;
		case "PTC_4":
			by = By.xpath("//span[contains(@id,'ptc3')]//input");	
			break;		
		case "Email":
			by = By.xpath("//span[contains(@id,'mainContactTableTpl')]//input");
			break;
		case "Address1":
			by = By.xpath("//span[contains(@id,'Address1Input_0')]//input");
			break;
		case "City":
			by = By.xpath("//span[contains(@id,'CityInput_0')]//input");
			break;
		case "State":
			by = By.xpath("//span[contains(@id,'StateInput_0')]//input");
			break;
		case "Zipcode":
			by = By.xpath("//span[contains(@id,'ZipInput_0')]//input");
			break;
		case "Country":
			by = By.xpath("//span[contains(@id,'addressCoutrySelectInput_0')]//input");
			break;	
		case "ApplyandClose_Button":
			by = By.xpath("//span[contains(@id,'PopupApplyAndCloseButton')]//button");
			break;		
			// Add other locators specific to the PassengerDetailsPage class
		}
		return by;
	}

}
