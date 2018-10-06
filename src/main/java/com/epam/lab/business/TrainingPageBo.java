package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.TrainingPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;
import static com.epam.lab.core.util.Constants.TRAINING_BY_YEAR_CLASSNAME;
import static com.epam.lab.core.util.Constants.TRAINING_PAGE_URL;

public class TrainingPageBo {

    private TrainingPagePo trainingPagePo;
    private MyLogger myLogger;
    private SoftAssert softAssertion;

    public TrainingPageBo() {
        trainingPagePo = new TrainingPagePo();
        DriverManager.getDriver().get(TRAINING_PAGE_URL);
        myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
        softAssertion = new SoftAssert();
    }

    @Step("PageElementBO Step: Verify the functionality of Professional Training card by year....")
    public void verifyCardByYear() {
        clickOnProfessionGrowth();
        clickOnTrainingCard();
        clickOnSeeMore();
        clickOnByYear();
        verifyByYear();
    }

    @Step("PageElementBO Step: Click on 'Professional Growth' informer....")
    public void clickOnProfessionGrowth() {
        trainingPagePo.getProfGrowthButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'Training card'...")
    public void clickOnTrainingCard() {
        trainingPagePo.getTrainingCard().click();
    }

    @Step("PageElementBO Step: Click on 'See More' button...")
    public void clickOnSeeMore() {
        trainingPagePo.getSeeMoreButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'By year' button...")
    public void clickOnByYear() {
        trainingPagePo.getByYearButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Verify if 'By year' button shows on page....")
    public void verifyByYear() {
        String expectedClassname = START_CLASSNAME_PROFILE_PAGE.concat(TRAINING_BY_YEAR_CLASSNAME);
        String currentlyClassname = trainingPagePo.getByYearButton().getAttribute("class");
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(currentlyClassname, expectedClassname, "The information is not displayed");
        MyLogger.getLogger().info(currentlyClassname.equals(expectedClassname) ?
                "All training information has been successfully loaded" : "The information is not displayed on page");
        softAssertion.assertAll();
    }
}
