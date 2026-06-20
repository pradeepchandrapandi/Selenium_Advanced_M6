package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress_Page {
	
	public AddNewAddress_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id = "Address_LastName")
	private WebElement lastNameTextField;
	
	@FindBy(id = "Address_Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Address_CountryID")
	private WebElement countryDropdown;
	
	@FindBy(id = "Address_City")
	private WebElement cityTextField;
	
	@FindBy(id = "Address_Address1")
	private WebElement address1TextField;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipPostalCodeTextField;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement phoneNumberTextField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddress1TextField() {
		return address1TextField;
	}

	public WebElement getZipPostalCodeTextField() {
		return zipPostalCodeTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	

}
