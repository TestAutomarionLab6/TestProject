package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;

import static com.epam.lab.core.util.Constants.PROFILE_PAGE_URL;

public class ProfilePageBo {

    private ProfilePagePo profilePagePo;

    public ProfilePageBo() {
        profilePagePo = new ProfilePagePo();
        DriverManager.getDriver().get(PROFILE_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("PageElementBO Step: Verify Profile button...")
    public void verifyProfileButton() {
        if(profilePagePo.getProfileButton().isDisplayed()) {
            profilePagePo.getProfileButton().click();
        }
    }

}
