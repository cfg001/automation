package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.*;
import reports.TestReport;
import util.*;
public class StepDef {

	WebDriver driver;
	private String screenshotFolderPath = System.getProperty("user.dir")+"/Screenshots";
	private ScreenshotUtils screenshotUtils;
	

	@Given("user is opens ARDWEB")
	public void user_is_opens_ARDWEB() {
		try{driver = new ChromeDriver();
		driver.get("https://uat.accounts.amadeus.com/LoginService/authorizeAngular?service=ARD_HA&client_id=1ASIXARDU&LANGUAGE=GB&redirect_uri=https%3A%2F%2Fuat5.resdesktop.altea.amadeus.com%2Fapp_ard%2Fapf%2Finit%2Flogin%3FSITE%3DAHABAHAB%26LANGUAGE%3DGB%26MARKETS%3DARDW_UAT_WBP%26ACTION%3DclpLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Opens ARDWEB");
		TestReport.logStatus(Status.PASS, "Opens ARDWEB");
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL, "did not open ARDWEB" + e);

		}


	}

	@Then("^verify user is on \"(.*)\" Page$")
	public void verify_user_is_on_login_page(String Pagename) throws IOException {
		try{By by= getLocator(Pagename);
		WebElement ele= driver.findElement(by);
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.isDisplayed();
		TestReport.logStatus(Status.PASS, "User is on "+Pagename);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"Page failed" +e);

		}

	}

	@Given("^user enters \"(.*)\" in (.*)$")
	public void user_enter_in_textbox(String string,String loc) throws IOException {
		try{
			By by= getLocator(loc);
			WebElement ele= driver.findElement(by);
			ele.clear();
			ele.sendKeys(string);
			TestReport.logStatus(Status.PASS,"Entered in "+loc);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"did not Entered in"+loc+e);

		}

	}

	@Given("^user enters excrypted \"(.*)\" in (.*)$")
	public void user_enter_in_textbox_cryptic(String string,String loc) throws Exception {
		try {
			EncryptDecrypt crypt =new EncryptDecrypt();
			By by= getLocator(loc);
			WebElement ele= driver.findElement(by);
			ele.clear();
			ele.sendKeys(crypt.decrypt(string));
			TestReport.logStatus(Status.PASS,"Entered decrypted value in "+loc);
			System.out.println("Entered in"+loc);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"did not Entered in"+loc+e);

		}
	}

	@And("^user clicks (.*)$")
	public void user_clicks(String loc) {
		try{
			By by= getLocator(loc);

			WebElement ele= driver.findElement(by);
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));

			wait.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			TestReport.logStatus(Status.PASS,"Clicked on "+loc);
			System.out.println("Clicked on"+loc);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"did not click in"+loc+e);

		}

	}

	@And("^user selects \"(.*)\" from (.*)$")
	public void user_selectsbyvisbiletext(String string,String loc) {
		try{
			By by= getLocator(loc);

			WebElement ele= driver.findElement(by);
			Select select = new Select(ele);
			select.selectByVisibleText(string);
			TestReport.logStatus(Status.PASS,"Selected the visible value from the dropdown"+ string);
			System.out.println("Selected the visible value from the dropdown"+ string);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"did not select"+string+e);

		}

	}
	
	@And("^user selects id \"(.*)\" from (.*)$")
	public void user_selectbyvalue(String string,String loc) {
		try{
			By by= getLocator(loc);

			WebElement ele= driver.findElement(by);
			Select select = new Select(ele);
			select.selectByValue(string);
			TestReport.logStatus(Status.PASS,"Selected the  value from the dropdown"+ string);
			System.out.println("Selected the visible value from the dropdown"+ string);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"did not select"+string+e);

		}

	}

	@Then("^user selects \"(.*)\" class from the flight in row \"(.*)\"$")
	public void user_selects_class_from_the_flight_in_row(String bkgclass, String fligtrow) {
		try{
			By by = By.xpath("(//tbody//tr//td[contains(text(),'"+fligtrow+"')]//following-sibling::td[@class='bkgClass'])[1]/span[contains(text(),'"+bkgclass+"')]");

			WebElement ele= driver.findElement(by);
			ele.click();
			TestReport.logStatus(Status.PASS,"selected class"+ bkgclass +"from"+fligtrow+"row");
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"Class is not available"+e);

		}

	}

	@Then("^verify (.*) is displayed$")
	public void verify_is_displayed(String loc) {
		try {
			By by= getLocator(loc);
			WebElement ele= driver.findElement(by);
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",ele);
			if (ele.isDisplayed()==true)
			TestReport.logStatus(Status.PASS,loc+" is displayed");
			else
				{TestReport.logStatus(Status.FAIL,loc+" is not displayed");
				}
			System.out.println(loc+" is displayed");
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,loc+"is not displayed"+e);

		}
	}
	@And("^user jclicks (.*)$")
	public void user_jclicks(String loc) {
		try {
			By by= getLocator(loc);
			WebElement ele= driver.findElement(by);
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));

			wait.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(ele));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",ele);
			TestReport.logStatus(Status.PASS,"jClicked on "+loc);
			System.out.println("jClicked on"+loc);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,loc+"is not clickable"+e);

		}

	}

	@When("^user perform payment type using (.*)$")
	public void user_perform_payment_type_using_Check(String PaymentType) throws Exception {   
		try {
			EncryptDecrypt crypt =new EncryptDecrypt();
			WebElement ele= driver.findElement(FormOfPaymentPage.getLocator("PaymentType_Dropdown"));
			Select select = new Select(ele);

			if(PaymentType.equalsIgnoreCase("check"))
			{	select.selectByValue("CHCK");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("AMEX_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("AX");
			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("FBSJCp/kd/x3/bzVPN6M9Q=="));
			driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("1234");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			//************************************************************
			//Using cryptic Cards for security reasons. Please create you cryptic card by placing the full card details in EncryptDecrypt
			//************************************************************
			else if(PaymentType.equalsIgnoreCase("Master_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("CA");
			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("+dr0AqL2HWTe42gT+2bHc4klKlCX19Qm"));
			driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("123");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("Visa_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("VI");

			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("28RLC+A3svK5eHbDCah6eIklKlCX19Qm"));
			driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("123");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("Diners_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("DC");

			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("28RLC+A3svK5eHbDCah6eIklKlCX19Qm"));
			driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("123");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("Discover_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("DS");

			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("7gsWkMA+dKrIXzWsuztHjoklKlCX19Qm"));
			driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0124");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("999");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("JCB_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("JC");

			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("28RLC+A3svK5eHbDCah6eIklKlCX19Qm"));
			//		driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("123");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("UATP_CreditCard"))
			{	select.selectByValue("CC");
			WebElement e= 	driver.findElement(FormOfPaymentPage.getLocator("CreditCardType_Dropdown"));
			Select sel = new Select(e);
			sel.selectByValue("TP");

			driver.findElement(FormOfPaymentPage.getLocator("CreditCardNumber_textbox")).sendKeys(crypt.decrypt("28RLC+A3svK5eHbDCah6eIklKlCX19Qm"));
			//		driver.findElement(FormOfPaymentPage.getLocator("ExipryDate_textbox")).sendKeys("0330");
			driver.findElement(FormOfPaymentPage.getLocator("CardHoldersName_textbox")).sendKeys("Test");
			driver.findElement(FormOfPaymentPage.getLocator("CVV_textbox")).sendKeys("123");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			else if(PaymentType.equalsIgnoreCase("HA_Giftcard"))
			{	select.selectByValue("MSGC");
			driver.findElement(FormOfPaymentPage.getLocator("CalculatePayment_Button")).click();
			driver.findElement(FormOfPaymentPage.getLocator("ApplyPaymentButton")).click();
			driver.findElement(AddPNRElementPage.getLocator("NextStep_Button")).click();
			}
			TestReport.logStatus(Status.PASS,"Payement is sucessfull using "+PaymentType);
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"Payement is unsucessfull using "+PaymentType+" "+e);


		}
	}

	@And("^user gettext of (.*) and save the value$")
	public void user_gettext_of_and_saves(String loc) {
		try {
			By by= getLocator(loc);
			WebElement ele= driver.findElement(by);
			String value =ele.getText();

			Properties properties= new Properties();
			String FeatureFilename =ScenarioContext.getFeatureFileName();
			String str = FeatureFilename.replaceAll("\\s", "");
			System.out.println("******************************************************"+str);
			String path1=System.getProperty("user.dir")+"/Results/"+str+".properties";
			//			String path1=System.getProperty("user.dir")+"/Results/Result.properties";
			TestReport.logStatus(Status.PASS,loc+"saved value is "+value);
			try (InputStream input = new FileInputStream(path1)) {
				// Load existing properties file
				properties.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Update or add the key-value pair
			properties.setProperty(loc, value);

			try (OutputStream output = new FileOutputStream(path1)) {
				// Save the updated properties file
				properties.store(output, null);


			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			TestReport.logStatus(Status.FAIL,"failed to save value"+e);

		}
	}

	@And("^user selects \"(.*)\" Officeid$")
	public void user_selects_officeis(String officeid) {

		driver.findElement(By.xpath("//div[contains(text(),'Office ID')]/following-sibling::a[contains(@id,'changeOffice')]")).click();
		Select Officeid = new Select(driver.findElement(By.xpath("//select[contains(@name,'OFFICE_ID')]")));
		Officeid.selectByValue(officeid);
		driver.findElement(By.xpath("//button[contains(@title,'OK')][contains(@class,'save')]")).click();
		driver.findElement(By.xpath("//button[contains(@title,'OK')][contains(@id,'uicAlertBox_ok')]")).click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.getLocator("HomePage"))));
	}



	@Then("^user take a screenshot$")
	public void takeScreenshot() {
		screenshotUtils = new ScreenshotUtils(driver, screenshotFolderPath);
		screenshotUtils.captureAndSaveScreenshot();
		TestReport.logScreenshot(Status.INFO, "screenshot", screenshotFolderPath);
	}

	private By getLocator(String locatorName)
	{
		By by = null;

		// Search for the locator in different classes

		// Example: Search in LoginPage class
		by = LoginPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}

		//		 Example: Search in HomePage class
		by = HomePage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		//		 Example: Search in SearchFlightPage class
		by = SearchFlightPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		//		 Example: Search in PassengerDetailsPage class
		by = PassengerDetailsPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		//		 Example: Search in PricingPage class
		by = PricingPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		by = AddPNRElementPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		by = APIPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		by = FormOfPaymentPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		by = PNRPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}
		by = EticketPage.getLocator(locatorName);
		if (by != null) {
			return by;
		}



		// Add other classes as needed

		throw new IllegalArgumentException("Locator not found: " + locatorName);
	}

	
	public void screenshot() throws IOException 
	{
		
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshots/";
		File DestFile=new File(path+"Final.png");
		FileUtils.copyFile(SrcFile, DestFile);


	}
	@After
	public void closereport() throws IOException
	{
		TestReport.flush();
	}

	@Before
	public void startreport() throws IOException
	{
		TestReport.initialize();
		TestReport.startTest("Test");
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		ScenarioContext.setScenario(scenario);
	}

	@After
	public void closebrowers() 
	{
		driver.quit();
	}


}


