package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public Home_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Log Out")
	private WebElement logOutButton;
	
	@FindBy(partialLinkText = "Addresses")
	private WebElement addressesLink;

	public WebElement getLogOutButton() {
		return logOutButton;
	}

	public WebElement getAddressesLink() {
		return addressesLink;
	}
	
	

}
