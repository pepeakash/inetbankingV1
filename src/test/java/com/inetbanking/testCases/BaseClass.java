package com.inetbanking.testCases;





import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
//	public String baseURL="http://www.demo.guru99.com/V4/";
//	public String username="mngr246519";
//	public String password="hypepuz";
	
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();  
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//		driver=new ChromeDriver();
//		driver=new FirefoxDriver();
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
			
		}else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			
		}
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
