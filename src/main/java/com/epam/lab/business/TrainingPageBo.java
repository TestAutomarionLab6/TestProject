package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.TrainingPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

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

    @Step("PageElementBO Step: Verify the functionality of Professional Training card....")
    public void verifyTrainingCard() {
        clickOnProfessionGrowth();
        clickOnTrainingCard();
        clickOnSeeMore();
        clickOnByType();
        verifyByType();
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

    @Step("PageElementBO Step: Click on 'By type' button...")
    public void clickOnByType() {
        trainingPagePo.getByTypeButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'By type' button......")
    public void verifyByType() {
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(trainingPagePo.getByTypeButton().isDisplayed(), true, "The information is not displayed");
        MyLogger.getLogger().info(trainingPagePo.getByTypeButton().isDisplayed() ?
                "All training information has been successfully loaded" : "The information is not displayed on page");
    }
}
