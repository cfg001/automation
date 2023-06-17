package pages;

import org.openqa.selenium.By;

public class SearchFlightPage {

	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "SearchFlightPage":
			by = By.xpath("//li[contains(@class,'current')][contains(text(),'Flight Search')]");
			break;
		case "Searchtype_dropdown":
			by = By.xpath("//select[@id='epnrBookingGuidedFlowAirshoppers1_searchType_searchType_id_input']");
			break;
		case "Origin_1":
			by = By.xpath("//input[contains(@id,'id_0_from')]");
			break;
		case "Destination_1":
			by = By.xpath("//input[contains(@id,'id_0_to')]");
			break;
		case "Date_1":
			by = By.xpath("//input[contains(@id,'id_0_date')]");
			break;
		case "Origin_2":
			by = By.xpath("//input[contains(@id,'id_1_from')]");
			break;
		case "Destination_2":
			by = By.xpath("//input[contains(@id,'id_1_to')]");
			break;
		case "Date_2":
			by = By.xpath("//input[contains(@id,'id_1_date')]");
			break;
		case "Serach_Button":
			by = By.xpath("//button[contains(@id,'airSearch_search_id')]");
			break;	
		case "Book_Button":
			by = By.xpath("//button[contains(@id,'_buttonBook_')]");
			break;	
		case "Segment_1":
			by = By.xpath("//div[@class='segmentDisplay']");
			break;
		case "Segment_2":
			by = By.xpath("(//div[@class='segmentDisplay'])[2]");
			break;	
		case "flighttab_2":
			by = By.xpath("//a[@href='#avResult_bound1_id']");
			break;	
		case "AddorUpdate_link":
			by = By.xpath("//a[text()='Add/Update']");
			break;
		case "Pax1_Details":
			by = By.xpath("//div[contains(@class,'paxId-1')]");
			break;
		case "Price_Button":
			by = By.xpath("//span[contains(@id,'priceButton')]//button");
			break;		
		case "NoofSeats":
			by= By.xpath("//input[contains(@id,'seats')][@class='seats']");
			break;
			// Add other locators specific to the SearchFlightPage class
		}
		return by;
	}


}
