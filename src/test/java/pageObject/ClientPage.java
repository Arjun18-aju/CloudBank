package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPage {

	public WebDriver driver;

	private By createClient = By.xpath("//a[@id='client_createbutton']");
	private By firstName = By.xpath("//input[@id='firstname']");
	private By lastName = By.xpath("//input[@id='lastname']");
	private By mobNo = By.xpath("//input[@id='mobileNo']");
	private By dob = By.xpath("//input[@id='dateofbirth']");
	private By genderBox = By.xpath("//div[@id='genderId_chosen']");
	private By clientType = By.xpath("//div[@id='clienttypeId_chosen']");
	private By clientClassi = By.xpath("//div[@id='clientClassificationId_chosen']");
	private By generalList = By.xpath("//ul[@class='chosen-results']/li");
	private By address = By.xpath("//button[@ng-click='addAddress()']");
	private By addressType = By.xpath("//span[contains(text(),'Select Address Type')]");
//	private By addressDrop = By.xpath("//div[@class='chosen-container chosen-container-single']/div/child::ul/li");	
	private By street = By.xpath("//input[@name='street0']");
	private By country = By.xpath("//select[@id='clientcountry']/following-sibling::div");
	private By state = By.xpath("//select[@id='clientstate']/following-sibling::div");
	private By city = By.xpath("//input[@name='city']");
	private By submit = By.xpath("//button[@id='save']");
	private By activate= By.xpath("//a[@has-permission='ACTIVATE_CLIENT']");
	private By activeDate=By.xpath("//body/div[2]/div[2]/div[2]/div[3]/div[1]"
			+ "/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
	private By activeSubmit = By.xpath("//button[@has-permission='ACTIVATE_CLIENT']");
	private By clientSearch= By.xpath("//input[@data-ng-model='searchText']");
	private By columnName= By.xpath("//tr/td[1]");
	private By columnStatus=By.xpath("//tr/td[3]/following-sibling::td[1]");
	private By mobError=By.xpath("//small[@ng-show='mobilenumbererror']");
		////small[@ng-show='mobilenumbererror']
	
	
	
	
	//ACTIVATE_CLIENT
	

	public ClientPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getMobError() {
		return driver.findElement(mobError);
	}
	
	
	
	public List<WebElement> getColumnStatus() {
		return driver.findElements(columnStatus);
	}
	
	public List<WebElement> getColumnName() {
		return driver.findElements(columnName);
	}
	
	public WebElement getClientSearch() {
		return driver.findElement(clientSearch);
	}
	
	public WebElement getActivateDateSubmit() {
		return driver.findElement(activeSubmit);
	}
	
	public WebElement getActivateDate() {
		return driver.findElement(activeDate);
	}
	
	public WebElement getActivate() {
		return driver.findElement(activate);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getMobNo() {
		return driver.findElement(mobNo);
	}

	public WebElement getDob() {
		return driver.findElement(dob);
	}

	public WebElement getGenderBox() {
		return driver.findElement(genderBox);
	}

	public WebElement getClientType() {
		return driver.findElement(clientType);
	}

	public WebElement getClientClassi() {
		return driver.findElement(clientClassi);
	}

	public List<WebElement> getGeneralList(String name) {
		List<WebElement> gList = driver.findElements(generalList);

		for (WebElement ele : gList) {
			String gText = ele.getText();
			if (gText.contains(name)) {
				 ele.click();
				break;
			}
		}
		return gList;
	}
	
	

	public WebElement getCreateClient() {
		return driver.findElement(createClient);

	}

	public WebElement getAddress() {
		
		return driver.findElement(address);

	}

	public WebElement getAddressType() {
		
		
		  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait .until(ExpectedConditions.visibilityOfElementLocated(addressType));
		 
	return	driver.findElement(addressType);
		

	}
	
	/*
	 * public WebElement getAddressDrop() {
	 * 
	 * return driver.findElement(addressDrop);
	 * 
	 * }
	 */

	public WebElement getStreet() {

		return driver.findElement(street);

	}

	public WebElement getCountry() {

		return driver.findElement(country);

	}

	public WebElement getState() {

		return driver.findElement(state);

	}

	public WebElement getCity() {

		return driver.findElement(city);

	}

	public WebElement getSubmit() {

		return driver.findElement(submit);

	}

}
