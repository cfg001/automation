package pages;

import org.openqa.selenium.By;


public class LoginPage  {

public static By getLocator(String locatorName) {
By by = null;

switch (locatorName) {
case "LoginPage":
by = By.xpath("//div[contains(text(),'Altéa Reservation Desktop')]");
break;
case "Username_textbox":
by = By.xpath("//label[text()='Login:']//preceding-sibling::input");
break;
case "LP_Next_Button":
by = By.xpath("//button[contains(text(),'Next')]");
break;
case "Password_textbox":
by = By.xpath("//input[@id='passwordInput']");
break;
case "LP_Next2_Button":
by = By.xpath("//button[@id='logi_confirmButton']");
break;
case "LP_PopupOK_Button":
by = By.xpath("//button[text()='Ok']");
break;
// Add other locators specific to the LoginPage class
}
return by;
}
}


