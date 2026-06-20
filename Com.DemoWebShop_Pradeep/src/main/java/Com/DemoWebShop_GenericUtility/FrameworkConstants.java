package Com.DemoWebShop_GenericUtility;

public interface FrameworkConstants {

	JavaUtility jutil = new JavaUtility();

	String propertyFilePath = "./src/test/resources/testData/commonData.properties";

	String excelFilePath = "./src/test/resources/testData/addressData.xlsx";

	String screenshotPath = "./screenshots/" + jutil.dateAndTime() + ".png";
	
	String extentReportPath = "./reports/" + jutil.dateAndTime() + ".html";

}
