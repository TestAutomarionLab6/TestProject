package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.BrowserUtils;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.Assert;

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
    public void clickOnHeroesButton() {
        if (profilePagePo.getHeroesButton().isDisplayed()) {
            profilePagePo.getHeroesButton().click();
        }
    }

    @Step("PageElementBO Step: Switch to next Heroes window in browser...")
    public void switchToHeroes() {
        BrowserUtils.switchToWindow(NEXT_WINDOW_NUMBER);
    }

    @Step("PageElementBO Step: wait Heroes logo...")
    public void waitHeroesLogo() {
        profilePagePo.getHeroesLogo().waitUntilVisible().isDisplayed();
    }

    @Step("PageElementBO Step: Verify Heroes button...")
    public void verifyHeroesButton() {
        boolean displayedLogo = profilePagePo.getHeroesLogo().isDisplayed();
        Assert.assertEquals(displayedLogo, true, "The Heroes logo are not displayed");
        MyLogger.getLogger().info(displayedLogo ?
                "Successfully goes to the UPSA page" : "The Heroes logo are not displayed");
    }

}
