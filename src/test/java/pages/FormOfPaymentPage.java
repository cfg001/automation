package pages;

import org.openqa.selenium.By;

public class FormOfPaymentPage {
	
	public static By getLocator(String locatorName) {
		By by = null;

		switch (locatorName) {
		case "FormOfPaymentPage":
			by = By.xpath("//li[contains(@class,'current')][contains(text(),'Form of Payment')]");
			break;
		case "PaymentType_Dropdown":
			by = By.xpath("//select[@aria-label='Payment Type']");
			break;	
		case "CalculatePayment_Button":
			by = By.xpath("//button[@title='Calculate the form of payment dispatch solution']");
			break;
		case "ApplyPaymentButton":
			by = By.xpath("//button[@title='Apply the payment to PNR']");
			break;	
		case "IssueDocuments_Button":
			by = By.xpath("//button[@title='Issue Document(s)']");
			break;	
		case "SuccessfullMessage":
			by = By.xpath("//h2[text()='Success Message']");
			break;
		case "GotoPNRDetails_Button":
			by = By.xpath("//button[@title='Exit the PNR Booking Flow.']");
			break;
		case "CreditCardType_Dropdown":
			by = By.xpath("//label[text()='Credit Card Type']/following-sibling::select");
			break;	
		case "CreditCardNumber_textbox":
			by = By.xpath("//label[text()='Credit Card Number']/following-sibling::span//input");
			break;	
		case "ExipryDate_textbox":
			by = By.xpath("//label[text()='Expiry Date']/following-sibling::span//input");
			break;	
		case "CardHoldersName_textbox":
			by = By.xpath("//label[contains(text(),'Cardholder')]/following-sibling::span//input");
			break;	
		case "CVV_textbox":
			by = By.xpath("//label[text()='CVV']/following-sibling::span//input");
			break;	
		case "CallerDetailsid_textbox":
			by = By.xpath("//input[contains(@id,'callerDetails_id_input')]");
			break;		
			
			
			
			// Add other locators specific to the FormOfPaymentPage class
		}
		return by;
	}

}
