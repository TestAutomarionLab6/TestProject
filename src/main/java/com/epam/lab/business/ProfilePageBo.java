package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;

import static com.epam.lab.core.util.Constants.*;

public class ProfilePageBo {

    private ProfilePagePo profilePagePo;

    public ProfilePageBo() {
        profilePagePo = new ProfilePagePo();
        DriverManager.getDriver().get(PROFILE_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("PageElementBO Step: Verify Heroes button...")
    public void verifyHeroesButton() {
        if (profilePagePo.getHeroesButton().isDisplayed()) {
            profilePagePo.getHeroesButton().click();
        }
    }

    @Step("PageElementBO Step: Switch to next Heroes window in browser...")
    public void switchToHeroes() {
        DriverManager.switchToWindow(NEXT_WINDOW_NUMBER);
    }

    @Step("PageElementBO Step: wait Heroes logo...")
    public void waitHeroesLogo() {
        profilePagePo.getHeroesLogo().waitUntilVisible().isDisplayed();
    }

    @Step("PageElementBO Step: Switch to previous telescope page in browser...")
    public void switchToTelescope() {
        DriverManager.getDriver().close();
        DriverManager.switchToWindow(PREVIOUS_WINDOW_NUMBER);
    }

}
