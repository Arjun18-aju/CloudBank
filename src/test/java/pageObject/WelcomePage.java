package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

//import java.time.Duration;

//import org.framework.practise.Hybridframework.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

	public WebDriver driver;

	private By text = By.xpath("//h3/strong[@class='ng-binding']");
	private By signOut = By.xpath("//a[@id='user-dropdown']"); 
	private By clientDrop = By.xpath("//a[@id='client-dropdown']");
	private By clientDropMenus = By.xpath("//ul[@id='swatch-menu']/li");
	
	//dropdown-menu
	////a[@id='client-dropdown']

	// login-button

	public WelcomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getText() {

		return driver.findElement(text);

	}

	public WebElement getUserName() {

		 WebElement drop=driver.findElement(signOut);
		 return drop;
	}
	
	public Actions getActions(WebDriver driver) {

		
		Actions acts=new Actions(driver);
		return acts;
		
	}
	public WebElement getClientElement() {
		
		 return driver.findElement(clientDrop);
		
	}
	
	public List<WebElement> getClientList(String source) {
		
		List<WebElement> list=   driver.findElements(clientDropMenus);
		for (WebElement list1 : list) {
			String text = list1.getText();
			if (text.contains(source)) {
				list1.click();
				break;
			}
		}
		return list;
	}


}
