package com.sparta.badgerBytes.webTesting.pom.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.*;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver getDriver() {
        WebDriver driver = null;
        Properties properties = new Properties();

        try {
            properties.load(new FileReader(new File("src/test/resources/webTesting.properties")));
            boolean headless = properties.get("headless").equals("true");
            switch (properties.getProperty("driver")) {
                case "chrome":
                    ChromeDriverService service = WebAutomationUtil.getChromeDriverService(properties.getProperty("driverPath"));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    if(headless) options.addArguments("headless");
                    driver = new ChromeDriver(service, options);
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", properties.getProperty("driverPath"));
                    if(headless) {
                        FirefoxOptions ffoptions = new FirefoxOptions();
                        ffoptions.addArguments("-headless");
                        driver = new FirefoxDriver(ffoptions);
                        break;
                    }
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
            }
            return driver;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("There was an issue loading from the properties file or starting your web driver");
            System.out.println("Please ensure you have the correct properties settings and drivers");
            return null;
        }
    }
}
