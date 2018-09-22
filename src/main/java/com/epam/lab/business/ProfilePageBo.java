package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;

import static com.epam.lab.core.util.Constants.FEEDBACK_FRAME_NUMBER;
import static com.epam.lab.core.util.Constants.PROFILE_PAGE_URL;

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
        clickOnButton();
        switchToFeedback();
        closeAlert();
    }

    @Step("PageElementBO Step: Verify click on Feedback button...")
    public void clickOnButton() {
        if (profilePagePo.getFeedbackButton().isDisplayed()) {
            profilePagePo.getFeedbackButton().click();
        }
    }

    @Step("PageElementBO Step: Switch to Feedback alert...")
    public void switchToFeedback() {
        DriverManager.switchToFrame(FEEDBACK_FRAME_NUMBER);
    }

    @Step("PageElementBO Step: Verify close Feedback alert...")
    public void closeAlert() {
        if (profilePagePo.getCloseFeedback().isDisplayed())
            profilePagePo.getCloseFeedback().click();
    }

}
