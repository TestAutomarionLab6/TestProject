package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.PROFILE_PAGE_URL;

public class ProfilePageBo {

    private ProfilePagePo profilePagePo;

    public ProfilePageBo() {
        profilePagePo = new ProfilePagePo();
        DriverManager.getDriver().get(PROFILE_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("PageElementBO Step: Verify if cover image is displayed...")
    public void verifyDisplayedImage() {
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(isDisplayed(), true, "The cover image is not displayed");
        MyLogger.getLogger().info(isDisplayed() ?
                "The cover image has been successfully loaded" : "The cover image is not displayed");
    }

    @Step("PageElementBO Step: Check image display...")
    public boolean isDisplayed() {
        return profilePagePo.getCoverImage().isDisplayed();
    }
}
