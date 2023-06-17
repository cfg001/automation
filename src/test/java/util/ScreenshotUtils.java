package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
	private WebDriver driver;
	private String screenshotFolderPath;

	public ScreenshotUtils(WebDriver driver, String screenshotFolderPath) {
		this.driver = driver;
		this.screenshotFolderPath = screenshotFolderPath;
	}

	public void captureAndSaveScreenshot() {
		String screenshotName = generateScreenshotName();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(screenshotFolderPath + File.separator + screenshotName);
		try {
			Files.copy(screenshotFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			String s= targetFile.getAbsolutePath();
			System.out.println("Screenshot saved: " + targetFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String generateScreenshotName() {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		return "screenshot_" + timestamp + ".png";
	}
}