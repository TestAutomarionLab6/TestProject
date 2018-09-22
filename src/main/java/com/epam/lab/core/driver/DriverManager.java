package com.epam.lab.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static com.epam.lab.core.util.Constants.DRIVER;
import static com.epam.lab.core.util.Constants.DRIVER_PATH;
import static com.epam.lab.core.util.Constants.TIME_FOR_WAITING;

public class DriverManager {


    /**
     * Initialize driver
     */
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        System.setProperty(DRIVER, DRIVER_PATH);
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

    public static WebDriverWait newWait () {
        return new WebDriverWait(getDriver(), TIME_FOR_WAITING);
    }

    public static void switchToWindow(int windowNumber)
    {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(windowNumber).toString());
    }
}
