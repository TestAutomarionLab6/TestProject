package com.epam.lab.core.util;

import com.epam.lab.core.driver.DriverManager;

import java.util.ArrayList;

public class BrowserUtils {

    public static void switchToWindow(int windowNumber) {
        ArrayList tabs = new ArrayList(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(windowNumber).toString());
    }
}
