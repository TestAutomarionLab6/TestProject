package com.epam.lab.core.driver;

import com.epam.lab.core.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    /**
     * Initialize driver
     */
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH_WIN);
        return new ChromeDriver();
    });

    private DriverManager() {
    }

    /**
     * This method gets driver
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * This method close driver and quit
     */
    public static void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
