package pageObject;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	
	public WebDriver driver;

	private By orgId = By.id("oid");
	private By userName = By.id("uid");
	private By password = By.id("pwd");
	private By logIn = By.id("login-button");
	private By alert = By.cssSelector(".alert.alert-danger.ng-binding");
	//
	// login-button

	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getOrgId( ) {
		 WebElement wait=(WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
		    		.until(ExpectedConditions.visibilityOfElementLocated(orgId));
		return driver.findElement(orgId);

	}

	public WebElement getUserName( ) {
    WebElement wait=(WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
    		.until(ExpectedConditions.visibilityOfElementLocated(userName));
    
		return driver.findElement(userName);
	}

	public WebElement getPassword( ) {
		 WebElement wait=(WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
		    		.until(ExpectedConditions.visibilityOfElementLocated(password));
		return driver.findElement(password);
		 
	}

	public WebElement getLogIn() {
		 WebElement wait=(WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
		    		.until(ExpectedConditions.elementToBeClickable(logIn));
		return driver.findElement(logIn);
	}
	
	public WebElement getAlert() {
		 WebElement wait=(WebElement) new WebDriverWait(driver,Duration.ofSeconds(5))
		    		.until(ExpectedConditions.elementToBeClickable(logIn));
		return driver.findElement(alert);
	}
	
}


