package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.BrowserUtils;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.ProfilePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.*;

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
  
    @Step("PageElementBO Step: Verify Feedback button...")
    public void verifyFeedbackButton() {
        openFeedback();
        checkFeedbackButton();
    }

    @Step("PageElementBO Step: open Feedback button...")
    public void openFeedback() {
        profilePagePo.getFeedbackButton().click();
        BrowserUtils.switchToFrame(FEEDBACK_FRAME_NUMBER);
    }

    @Step("PageElementBO Step: Verify Feedback button...")
    public void checkFeedbackButton() {
        String titleText = profilePagePo.getTitleLabel().getText();
        Assert.assertEquals(titleText, ALERT_TITLE_OF_FEEDBACK, "The titles are not equal!");
        MyLogger.getLogger().info(titleText.equals(ALERT_TITLE_OF_FEEDBACK) ?
                "The titles are not equal!" : "Successfully goes to the Feedback");
    }

    @Step("PageElementBO Step: Verify Heroes button...")
    public void clickOnHeroesButton() {
        profilePagePo.getHeroesButton().click();
    }

    @Step("PageElementBO Step: Switch to next Heroes window in browser...")
    public void switchToHeroes() {
        BrowserUtils.switchToWindow(NEXT_WINDOW_NUMBER);
    }

    @Step("PageElementBO Step: Click on UPSA button...")
    public void clickOnUPSAButton() {
        profilePagePo.getUPSAButton().click();
    }

    @Step("PageElementBO Step: Switch to next UPSA window in browser...")
    public void switchToUPSA() {
        BrowserUtils.switchToWindow(NEXT_WINDOW_NUMBER);
    }

    @Step("PageElementBO Step: Wait UPSA logo...")
    public void waitUPSALogo() {
        profilePagePo.getUPSALogo().waitUntilVisible().isDisplayed();
    }

    @Step("PageElementBO Step: Verify UPSA button...")
    public void verifyUPSAButton() {
        boolean displayedLogo = profilePagePo.getUPSALogo().isDisplayed();
        Assert.assertEquals(displayedLogo, true, "The UPSA logo are not displayed");
        MyLogger.getLogger().info(displayedLogo ?
                "Successfully goes to the UPSA page" : "The UPSA logo are not displayed");
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

    @Step("PageElementBO Step: Click on Profile button...")
    public void clickOnProfileButton() {
        profilePagePo.getProfileButton().click();
    }

    @Step("PageElementBO Step: Verify profile page")
    public void verifyProfilePage() {
        String profileClassName = profilePagePo.getProfileView().getAttribute("class");
        softAssertion.assertEquals(profileClassName, getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME), "Classname is same");
        MyLogger.getLogger().info(profileClassName.equals(getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME)) ?
                "Classname is not same!" : "Successfully goes to the profile page");
    }

    @Step("PageElementBO Step: Click on Wall button...")
    public void clickOnWallButton() {
        profilePagePo.getWallButton().click();
    }

    @Step("PageElementBO Step: Verify the wall page")
    public void verifyWallPage() {
        String profileClassName = profilePagePo.getProfileView().getAttribute("class");
        softAssertion.assertEquals(profileClassName, getFullClassname(START_CLASSNAME_PROFILE_PAGE, WALL_CLASSNAME), "Classname is same");
        MyLogger.getLogger().info(profileClassName.equals(getFullClassname(START_CLASSNAME_PROFILE_PAGE, WALL_CLASSNAME)) ?
                "Classname is not same!" : "Successfully goes to the wall page");
    }

    public String getFullClassname(String firstPart, String secondPart) {
        return String.format("%s%s", firstPart, secondPart);
    }
    
    @Step("PageElementBO Step:  get and click All Contacts Button...")
    public void getAndClickAllContactsButton() {		
	JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    	js.executeScript("arguments[0].click();", profilePagePo.getAllContactsButton());
    }
    
    @Step("PageElementBO Step: Verify All Contacts")
    public void verifyAllContacts(String phone, String email, String skype, String email2 ) {    	
        softAssertion.assertEquals(phone, profilePagePo.getPhone().getText(), "Phone number is't correct");
        MyLogger.getLogger().info( phone.equals(profilePagePo.getPhone().getText()) ? 
        		                   "phone number is correct" : "phone number is't correct");
        softAssertion.assertEquals(email, profilePagePo.getEmail().getText(), "Email is't correct");
        MyLogger.getLogger().info( email.equals(profilePagePo.getEmail().getText()) ? 
        		                   "email number is correct" : "email number is't correct");
        softAssertion.assertEquals(skype, profilePagePo.getSkype().getText(), "Skype is't correct");
        MyLogger.getLogger().info( skype.equals(profilePagePo.getSkype().getText()) ?
        		                   "skype number is correct" : "skype number is't correct");
        softAssertion.assertEquals(email2, profilePagePo.getEmail2().getText(), "Email2 number is't correct");
        MyLogger.getLogger().info( email2.equals(profilePagePo.getEmail2().getText()) ?
        		                   "email2 number is correct" : "email2 number is't correct");
    } 

}
