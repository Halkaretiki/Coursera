package TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;

	@BeforeSuite
	@Parameters({ "browser" })
	public void setup(String browser) throws IOException {
		logger = LogManager.getLogger(this.getClass());// Log4j
		// load properties file
		//FileReader file = new FileReader(".//src//test//resources//");
		//p = new Properties();
		//p.load(file);

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter Valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.coursera.org/");
	}

		@AfterSuite
		public void close() {
				driver.quit();
			}
//	public String captureScreen(String tname) throws IOException {
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//
//		File targetFilePath = new File("C:\\Users\\2304083\\eclipse-workspace\\Coursera\\ScreenShot" + tname +".png");
//		FileUtils.copyFile(sourceFile, targetFilePath);
//		return tname;
//		
//
//	}

}
