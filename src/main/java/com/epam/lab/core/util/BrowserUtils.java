package com.epam.lab.core.util;

import com.epam.lab.core.driver.DriverManager;

import java.util.ArrayList;

public class BrowserUtils {

    public static void switchToFrame(int frameNumber) {
        DriverManager.getDriver().switchTo().frame(frameNumber);
    }
}
