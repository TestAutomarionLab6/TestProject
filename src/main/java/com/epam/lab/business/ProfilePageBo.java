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

    @Step("PageElementBO Step: Verify Feedback button...")
    public void verifyFeedbackButton() {
        openFeedback();
        checkFeedbackButton();
    }

    @Step("PageElementBO Step: open Feedback button...")
    public void openFeedback() {
        if (profilePagePo.getFeedbackButton().isDisplayed())
            profilePagePo.getFeedbackButton().click();
        BrowserUtils.switchToFrame(FEEDBACK_FRAME_NUMBER);
    }

    @Step("PageElementBO Step: Verify Feedback button...")
    public void checkFeedbackButton() {
        String titleText = profilePagePo.getTitleLabel().getText();
        Assert.assertEquals(titleText, ALERT_TITLE_OF_FEEDBACK, "The titles are not equal!");
        MyLogger.getLogger().info(titleText != ALERT_TITLE_OF_FEEDBACK ?
                "Successfully goes to the Feedback" : "The titles are not equal!");
    }

}
