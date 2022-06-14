package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
//import java.net.URL;
import java.time.Duration;
//import java.time.Duration;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.io.FileHandler;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initailizeDriver() throws IOException {
		prop = new Properties();
		FileReader fis = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\BrowserData");

		prop.load(fis);
		String bN = prop.getProperty("browser");
		/*
		 * orgId=default Username=cb_admin Password=password
		 */
		Constants.orgId = prop.getProperty("orgId");
		Constants.userName = prop.getProperty("Username");
		Constants.Password = prop.getProperty("Password");
		Constants.Password1 = prop.getProperty("Password1");
		Constants.FirstName = prop.getProperty("FirstName");
		Constants.LastName = prop.getProperty("LastName");
		Constants.MobNo = prop.getProperty("MobNo");
		Constants.dob = prop.getProperty("dob");
		Constants.ActivationDate = prop.getProperty("ActivationDate");
		Constants.Street = prop.getProperty("Street");

		if (bN.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (bN.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} else if (bN.contains("edge")) {

			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	/*
	 * public String getScreenShotPath(String testCaseName, WebDriver driver) throws
	 * IOException { TakesScreenshot ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); String destinationFile =
	 * System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	 * FileUtils.copyFile(source, new File(destinationFile)); return
	 * destinationFile;
	 * 
	 * }
	 */
}
