package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addresses_Page {
	
	public Addresses_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//input[@value='Add new']")
	private WebElement addNewButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

}
