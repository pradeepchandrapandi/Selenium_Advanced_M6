package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sdriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility = new FileUtility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_page homePage;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();
	public WebDriverWait wait;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite --- Database Connection");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test --- Report Generation");

		spark = new ExtentSparkReporter(FrameworkConstants.extentReportPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop Address Module");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class --- Browser Setup");

		String browser = fileUtility.readDataFromPropertyFile("browserName");
		String url = fileUtility.readDataFromPropertyFile("url");
		
	//	String browser = System.getProperty("browserName");
	//	String url = System.getProperty("baseUrl");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome Browser");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Edge Browser");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Firefox Browser");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invaild Browser");
		}
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method --- Login to Application");
		
		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginlink().click();
		
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginButton().click();
		
		homePage = new Home_page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Before Suite --- Database Connection");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("Before Suite --- Database Connection");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Before Suite --- Database Connection");
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Before Suite --- Database Connection");
	}

}
