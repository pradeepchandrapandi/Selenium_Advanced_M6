package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddNewAddress_Page;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC001_VerifyUserIsAbleToAddAddressOrNot_Test extends BaseTest {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {

		webDriverUtility.javascriptScrollTillElement(driver, homePage.getAddressesLink());
		homePage.getAddressesLink().click();

		Addresses_Page addressesPage = new Addresses_Page(driver);
		webDriverUtility.javascriptScrollTillElement(driver, addressesPage.getAddNewButton());
		addressesPage.getAddNewButton().click();

		AddNewAddress_Page newAddressPage = new AddNewAddress_Page(driver);
		newAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		newAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		newAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));

		webDriverUtility.selectByVisibleText(newAddressPage.getCountryDropdown(),
				fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		newAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		newAddressPage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		newAddressPage.getZipPostalCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		newAddressPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		newAddressPage.getSaveButton().click();

		Thread.sleep(3000);
		webDriverUtility.webPageScreenshot(driver);

	}

}
