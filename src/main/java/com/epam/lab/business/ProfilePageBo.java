package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.PROFILE_PAGE_CLASSNAME;
import static com.epam.lab.core.util.Constants.PROFILE_PAGE_URL;

public class ProfilePageBo {

    private ProfilePagePo profilePagePo;
    private MyLogger myLogger;
    private SoftAssert softAssertion;

    public ProfilePageBo() {
        profilePagePo = new ProfilePagePo();
        DriverManager.getDriver().get(PROFILE_PAGE_URL);
        myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
        softAssertion = new SoftAssert();
    }

    @Step("PageElementBO Step: Click on Profile button...")
    public void clickOnProfileButton() {
        if(profilePagePo.getProfileButton().isDisplayed()) {
            profilePagePo.getProfileButton().click();
        }
    }

    @Step("PageElementBO Step: Verify profile page")
    public void verifyProfilePage()
    {
        String profileClassName = profilePagePo.getProfileView().getAttribute("class");
        softAssertion.assertEquals(profileClassName, PROFILE_PAGE_CLASSNAME, "Classname is same");
        MyLogger.getLogger().info(profileClassName!=PROFILE_PAGE_CLASSNAME ?
                "Successfully goes to the profile page" : "Classname is not same!");
    }

}
