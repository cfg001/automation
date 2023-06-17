package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import reports.TestReport;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/Sample.feature"},
glue = "stepDefinitions",
monochrome=true,
plugin={"pretty","html:target/HTMLReports/report.html","json:target/JsonReports/report.json","junit:target/JunitReports/report.xml","me.jvt.cucumber.report.PrettyReports:target/cucumber"}
//,dryRun= true
				)


 /* **************Important notes***************
  *  Give the feature file location in Cucumber Options
  *  Use Encrypted Password
  *  Use Encrypted Credit cards. 
  *  How to encrypt the passwords/credit card
  	 * Give the original values EncryptDecrypt run it as Java get the output for encrypted values put them in the appropriate place
  * Whenever you add a new page add below steps in StepDef class under getLocator method this is used to find the locators in all the page class of the pages package 
  * 			by = "NewPageName".getLocator(locatorName);
					if (by != null) {
			return by;
		}
   */
public class TestRunner {


}