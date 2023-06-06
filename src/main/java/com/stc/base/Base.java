package com.stc.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
	
    public static WebDriver driver;
    public static Properties prop = new Properties();
    

    public Base() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\properties\\config.properties");
        prop.load(fis);
    }


    public static void launchBrowser() {
        if (prop.getProperty("browser").contentEquals("chrome"))  //properties file
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").contentEquals("firefox"))   //properties file
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").contentEquals("edge"))   //properties file
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            throw new Error("browser not supported");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        driver.get(prop.getProperty("url"));
    }
    
    public void clickOnElement(By locator) {
    	WebElement element = driver.findElement(locator);
    	element.click();
    }
    
    public String getElementText(By locator) {
    	WebElement element = driver.findElement(locator);
    	return element.getText();
    }
}