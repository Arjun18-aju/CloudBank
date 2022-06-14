package tasks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObject.ClientPage;
import pageObject.LogInPage;
import pageObject.WelcomePage;
import resources.Constants;
import resources.base;

public class ValidationPage extends base {

	LogInPage page;
	WelcomePage wPage;
	ClientPage cPage;
	String expectedText = "Welcome, cb_admin";
	String actualText;
	String expectedVal = "Enter a valid mobile Number";

	// public WebDriver driver;
	@BeforeSuite
	public void intialize() {
		try {
			driver = initailizeDriver();
			driver.get(prop.getProperty("url"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test(priority = 0)
	public void ValidlogIn() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		page = new LogInPage(driver);
		wPage = new WelcomePage(driver);
		cPage = new ClientPage(driver);

		try {
			page.getOrgId().sendKeys(Constants.orgId);

			page.getUserName().sendKeys(Constants.userName);

			page.getPassword().sendKeys(Constants.Password);

			Thread.sleep(2000);
			page.getLogIn().click();

			actualText = wPage.getText().getText();

			Assert.assertEquals(actualText, expectedText);

			wPage.getActions(driver).moveToElement(wPage.getClientElement()).build().perform();
			wPage.getClientList("Clients");

			// Thread.sleep(5000);
			cPage.getCreateClient().click();

			cPage.getFirstName().sendKeys(Constants.FirstName);
			cPage.getLastName().sendKeys(Constants.LastName);
			cPage.getMobNo().sendKeys(Constants.MobNo);
			cPage.getMobNo().clear();
			cPage.getMobNo().sendKeys(Constants.MobNo + "578");
			String len = cPage.getMobNo().getText();

			if (len.length() > 10 || len.length() < 10) {
				String actualvalidate = cPage.getMobError().getText();
				Assert.assertEquals(actualvalidate, expectedVal);
			}
			cPage.getMobNo().clear();
                        cPage.getMobNo().sendKeys(Constants.MobNo);
			cPage.getDob().sendKeys(Constants.dob);
			cPage.getGenderBox().click();
			cPage.getGeneralList("Male");
			cPage.getClientType().click();
			cPage.getGeneralList("Salaried");
			cPage.getClientClassi().click();
			cPage.getGeneralList("class1");

			cPage.getAddress().click();

			wPage.getActions(driver).click(cPage.getAddressType());

			cPage.getGeneralList("Current");
			cPage.getStreet().sendKeys(Constants.Street);
			cPage.getCountry().click();
			cPage.getGeneralList("India");
			cPage.getState().click();
			cPage.getGeneralList("Tamil Nadu");
			cPage.getCity().sendKeys("Chennai");
			cPage.getSubmit().click();

			cPage.getActivate();

			cPage.getActivateDate().sendKeys(Constants.ActivationDate);

			cPage.getActivateDateSubmit().click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(wPage.getClientElement())));

			wPage.getActions(driver).moveToElement(wPage.getClientElement()).build().perform();
			wPage.getClientList("Clients");

			cPage.getClientSearch().sendKeys(Constants.FirstName + Constants.LastName);

			List<WebElement> eleme = cPage.getColumnName();

			List<WebElement> text = eleme.stream().filter(e -> e.getText().contains("Test s"))
					.collect(Collectors.toList());
			Assert.assertEquals(cPage.getColumnName().size(), text.size());

			List<WebElement> status = cPage.getColumnStatus();

			List<WebElement> filteredStatus = status.stream().filter(e -> e.getText().equalsIgnoreCase("Active"))
					.collect(Collectors.toList());

			Assert.assertEquals(cPage.getColumnStatus().size(), filteredStatus.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void TearDown() {

		driver.quit();
	}

}
