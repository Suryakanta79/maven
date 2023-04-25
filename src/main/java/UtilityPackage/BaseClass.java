package UtilityPackage;

	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;	
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;	
	import org.testng.annotations.Parameters;

	public class BaseClass {

		public WebDriver driver;
		PropertyFile p=new PropertyFile();

		@BeforeSuite
		public void Launch_database()
		{
			System.out.println("Database is Launched....!!!");

		}
		@Parameters("browser")
		//@BeforeTest
		@BeforeClass
		public void Launch_Browser(String browser) throws Exception
		{
			//String browser=p.ReaddataFromProperty("Browser");
			String url=p.ReaddataFromProperty("URL");

			if(browser.equalsIgnoreCase("Chrome"))
			{
				//WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\chromedriver.exe");
				ChromeOptions o=new ChromeOptions();
				o.addArguments("--disable-notifications");
				driver=new ChromeDriver(o);

			}
			else if(browser.equalsIgnoreCase("Edge"))
			{
				//System.setProperty("webdriver.edge.driver", "D:\\Development TFS Project\\msedgedriver.exe");	
				EdgeOptions o=new EdgeOptions();
				o.addArguments("--disable-notifications");
				driver=new EdgeDriver(o);

			}
			else
			{
				System.out.println("no browser launched");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@BeforeMethod
		public void login() throws Exception
		{
			FacebookLoginPage f=new FacebookLoginPage(driver);
			f.login(p.ReaddataFromProperty("Username"), p.ReaddataFromProperty("Password"));
		}
		@AfterMethod
		public void logout()
		{
			FacebookLogoutPage f=new FacebookLogoutPage(driver);

			f.logout();
		}
		//@AfterTest
		@AfterClass
		public void Close_Browser()
		{
			driver.quit();
		}
		@AfterSuite
		public void close_database()
		{
			System.out.println("Database is Closed....!!!");

		}
	}


