package com.crmpro.crmselenium.constants;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static String usedir = System.getProperty("user.dir");
	public static String url;

	public static String username;
	public static String password;
	public static String browser;
	public static WebDriver driver;
	public static int IMPLICITWAIT;

	public void init() {
		try {
			prop = new Properties();
			prop.load(new FileReader(usedir + "/src/test/resources/config/config.properties"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			IMPLICITWAIT = Integer.parseInt(prop.getProperty("implicitWait"));

			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + browser);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
