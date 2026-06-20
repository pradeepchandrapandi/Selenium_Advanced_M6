package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC002_VerifyUserIsAbleToDeleteAddressOrNot_Test extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		
		webDriverUtility.javascriptScrollTillElement(driver, homePage.getAddressesLink());
		homePage.getAddressesLink().click();
		
		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getDeleteButton().click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		webDriverUtility.switchToAlertAccept(driver);
		
		Thread.sleep(3000);
		webDriverUtility.webPageScreenshot(driver);
		
	
	}

}
