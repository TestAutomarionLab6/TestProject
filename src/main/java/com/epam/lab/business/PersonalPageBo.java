package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.PersonalPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.PERSONAL_DATA_FOOTER;
import static com.epam.lab.core.util.Constants.PERSONAL_PAGE_URL;

public class PersonalPageBo {

    private PersonalPagePo personalPagePo;
    private MyLogger myLogger;
    private SoftAssert softAssertion;

    public PersonalPageBo() {
        personalPagePo = new PersonalPagePo();
        DriverManager.getDriver().get(PERSONAL_PAGE_URL);
        myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
        softAssertion = new SoftAssert();
    }

    @Step("PageElementBO Step: Verify the functionality of Personal card by general info....")
    public void verifyCardByGeneralInfo() {
        clickOnPersonalData();
        clickOnPersonalCard();
        clickOnSeeMore();
        clickOnGeneralInfo();
        verifyGeneralInfo();
    }

    @Step("PageElementBO Step: Click on 'Personal Data' informer....")
    public void clickOnPersonalData() {
        personalPagePo.getPersonalDataButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'Personal card'...")
    public void clickOnPersonalCard() {
        personalPagePo.getPersonalCard().click();
    }

    @Step("PageElementBO Step: Click on 'See More' button...")
    public void clickOnSeeMore() {
        personalPagePo.getSeeMoreButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'General Info' button...")
    public void clickOnGeneralInfo() {
        personalPagePo.getGeneralInfoButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Verify if 'footer' label shows same text...")
    public void verifyGeneralInfo() {
        String footerLabelText = personalPagePo.getFooterLabel().getText();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertNotEquals(footerLabelText, PERSONAL_DATA_FOOTER,"The information is not displayed");
        MyLogger.getLogger().info(footerLabelText.equals(PERSONAL_DATA_FOOTER)?
                "The information is not displayed on page":"All personal information has been successfully loaded");
        softAssertion.assertAll();
    }
}
