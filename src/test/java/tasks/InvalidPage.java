package tasks;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObject.LogInPage;
import resources.Constants;
import resources.base;

public class InvalidPage extends base {

	String alertExpected = "Please try again, your credentials are not valid.";
	String alertText;

	@BeforeSuite
	public void intialize() throws IOException {

		driver = initailizeDriver();

	}

	@Test

	public void invalidLogin() {

		try {

			driver.get(prop.getProperty("url"));
			LogInPage page = new LogInPage(driver);
			// WelcomePage wPage = new WelcomePage(driver);
			page.getOrgId().sendKeys(Constants.orgId);

			page.getUserName().sendKeys(Constants.userName);

			page.getPassword().sendKeys(Constants.Password1);

			Thread.sleep(2000);
			page.getLogIn().click();

			alertText = page.getAlert().getText();

			Assert.assertEquals(alertText, alertExpected);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void TearDown() {

		driver.quit();
	}
}
