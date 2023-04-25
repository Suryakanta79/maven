package maven;


	import org.testng.annotations.Test;
	import org.openqa.selenium.By;
	import org.testng.Reporter;
	import org.testng.annotations.Listeners;

	import UtilityPackage.BaseClass;
	//@Listeners(UtilityPackage.ListnerImplementationClass.class)
	public class ClickOnReelsTest extends BaseClass{
	@Test(groups = "Smoke")
		public void Reels()
		{
			driver.findElement(By.xpath("//a[@aria-label='Watch']")).click();
			Reporter.log("Click on Reels Successfully..!!!");

		}

	}
