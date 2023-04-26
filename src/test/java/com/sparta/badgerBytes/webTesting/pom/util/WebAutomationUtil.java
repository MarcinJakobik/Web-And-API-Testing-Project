package com.sparta.badgerBytes.webTesting.pom.util;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class WebAutomationUtil {
  public static void setDriverLocation(String driverPath) {
    System.setProperty("webdriver.chrome.driver", driverPath);
  }

  public static ChromeDriverService getChromeDriverService(String driverPath) {
    return new ChromeDriverService
        .Builder()
        .usingDriverExecutable(new File(driverPath))
        .usingAnyFreePort()
        .build();
  }
}
