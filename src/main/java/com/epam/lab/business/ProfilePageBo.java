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
        softAssertion.assertEquals(isDisplayed(), true, "The cover image is not displayed");
        MyLogger.getLogger().info(isDisplayed() ?
                "The cover image has been successfully loaded" : "The cover image is not displayed");
        softAssertion.assertAll();
    }

    @Step("PageElementBO Step: Check image display...")
    public boolean isDisplayed() {
        return profilePagePo.getCoverImage().isDisplayed();
    }

    @Step("PageElementBO Step: Verify Feedback button...")
    public void verifyFeedbackButton() {
        openFeedback();
        checkFeedbackButton();
        closeFeedback();
    }

    @Step("PageElementBO Step: open Feedback button...")
    public void openFeedback() {
        profilePagePo.getFeedbackButton().click();
        BrowserUtils.switchToFrame(FEEDBACK_FRAME_NUMBER);
        profilePagePo.getTitleLabel().waitUntilVisible().isDisplayed();
    }

    @Step("PageElementBO Step: Verify Feedback button...")
    public void checkFeedbackButton() {
        String titleText = profilePagePo.getTitleLabel().getText();
        Assert.assertEquals(titleText, FEEDBACK_TITLE, "The titles are not equal!");
        MyLogger.getLogger().info(titleText.equals(FEEDBACK_TITLE) ?
                "Successfully goes to the Feedback" : "The titles are not equal!");
    }

    @Step("PageElementBO Step: close Feedback button...")
    public void closeFeedback() {
        profilePagePo.getFeedbackCloseButton().click();
        DriverManager.getDriver().switchTo().defaultContent();
    }

    @Step("PageElementBO Step: Verify Heroes button...")
    public void clickOnHeroesButton() {
        profilePagePo.getHeroesButton().click();
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

    @Step("PageElementBO Step: Switch to previous telescope page in browser...")
    public void switchToTelescope() {
        BrowserUtils.switchToWindow(PREVIOUS_WINDOW_NUMBER);
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


    @Step("PageElementBO Step: Click on Profile button...")
    public void clickOnProfileButton() {
        profilePagePo.getProfileButton().click();
    }

    @Step("PageElementBO Step: Verify profile page")
    public void verifyProfilePage() {
        String profileClassName = profilePagePo.getProfileView().getAttribute("class");
        softAssertion.assertEquals(profileClassName, getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME),
                "Classname is same");
        MyLogger.getLogger().info(profileClassName.equals(getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME)) ?
                "Classname is not same!" : "Successfully goes to the profile page");
        softAssertion.assertAll();
    }

    @Step("PageElementBO Step: Click on Wall button...")
    public void clickOnWallButton() {
        profilePagePo.getWallButton().click();
    }

    @Step("PageElementBO Step: Verify the wall page")
    public void verifyWallPage() {
        String profileClassName = profilePagePo.getProfileView().getAttribute("class");
        softAssertion.assertEquals(profileClassName, getFullClassname(START_CLASSNAME_PROFILE_PAGE, WALL_CLASSNAME),
                "Classname is same");
        MyLogger.getLogger().info(profileClassName.equals(getFullClassname(START_CLASSNAME_PROFILE_PAGE, WALL_CLASSNAME)) ?
                "Classname is not same!" : "Successfully goes to the wall page");
        softAssertion.assertAll();
    }

    public String getFullClassname(String firstPart, String secondPart) {
        return String.format("%s%s", firstPart, secondPart);
    }

    @Step("PageElementBO Step:  Click on PAST PROJECTS Button...")
    public void clickOnPastProjectsButton() {
        profilePagePo.getPastProjectsButton().click();
    }

    @Step("PageElementBO Step: Verify PAST PROJECTS")
    public void verifyPastProjectsPage() {
        String pastProjectClassName = profilePagePo.getPastProjectsView().getAttribute("class");
        softAssertion.assertEquals(pastProjectClassName, getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME),
                "Classname is the same");
        MyLogger.getLogger().info(pastProjectClassName.equals(getFullClassname(START_CLASSNAME_PROFILE_PAGE, PROFILE_CLASSNAME)) ?
                "Successfully goes to the PAST PROJECTS view" : "Classname is not the same!");
    }

    @Step("PageElementBO Step:  get and click All Contacts Button...")
    public void clickOnPopoverButton() {
        profilePagePo.getPopoverSign().click();
    }

    @Step("PageElementBO Step: Verify the native name")
    public void verifyNativeName(String nativeName) {
        softAssertion.assertEquals(nativeName, profilePagePo.getNativeName().getText(), "Native name is't correct");
        MyLogger.getLogger().info(nativeName.equals(profilePagePo.getNativeName().getText()) ?
                "native name is correct" : "native name is't correct");
    }

    @Step("PageElementBO Step: Click on contacts")
    public void clickOnContacts() {
       profilePagePo.getAllContactsButton().click();
    }

    @Step("PageElementBO Step: Check the user mobile phone")
    public void verifyPersonalMobilePhone(String phone) {
        softAssertion.assertEquals(phone, profilePagePo.getMobilePhone().getText(), "Phone number is't correct");
        MyLogger.getLogger().info(phone.equals(profilePagePo.getMobilePhone().getText()) ?
                "mobile phone number is correct" : "mobile phone number is't correct");
    }

    @Step("PageElementBO Step: Check the user phone")
    public void verifyPersonalPhoneNumber(String phone) {
        softAssertion.assertEquals(phone, profilePagePo.getPhone().getText(), "Phone number is't correct");
        MyLogger.getLogger().info(phone.equals(profilePagePo.getPhone().getText()) ?
                "phone number is correct" : "phone number is't correct");
    }

    @Step("PageElementBO Step: Check the user email")
    public void verifyPersonalEmail(String email) {
        softAssertion.assertEquals(email, profilePagePo.getEmail().getText(), "Email is't correct");
        MyLogger.getLogger().info(email.equals(profilePagePo.getEmail().getText()) ?
                "email number is correct" : "email number is't correct");
    }

    @Step("PageElementBO Step: Check the user Skype")
    public void verifyPersonalSkype(String skype) {
        softAssertion.assertEquals(skype, profilePagePo.getSkype().getText(), "Skype is't correct");
        MyLogger.getLogger().info(skype.equals(profilePagePo.getSkype().getText()) ?
                "The Skype is correct" : "The Skype is't correct");
    }

    @Step("PageElementBO Step: Check the user Skype for business")
    public void verifyPersonalSkypeForBusiness(String skype) {
        softAssertion.assertEquals(skype, profilePagePo.getSkypeForBusiness().getText(), "Skype for business is't correct");
        MyLogger.getLogger().info(skype.equals(profilePagePo.getSkypeForBusiness().getText()) ?
                "The Skype for business is correct" : "The Skype for business is't correct");
    }

    @Step("PageElementBO Step: Check the user name and surname")
    public void verifyFirstAndLastName(String firstAndLastName) {
        softAssertion.assertEquals(firstAndLastName, profilePagePo.getFirstAndLastName().getText(),
                "First and last name is't correct");
        MyLogger.getLogger().info(firstAndLastName.equals(profilePagePo.getFirstAndLastName().getText()) ?
                "First and last name is correct" : "First and last name is't correct");
    }

    @Step("PageElementBO Step: Check the user job title")
    public void verifyJobTitle(String jobTitle) {
        softAssertion.assertEquals(jobTitle, profilePagePo.getJobTitle().getText(), "The job title is't correct");
        MyLogger.getLogger().info(jobTitle.equals(profilePagePo.getJobTitle().getText()) ?
                "The job title is correct" : "The job title is't correct");
    }

    @Step("PageElementBO Step: Check the user job location")
    public void verifyJobLocation(String jobLocation) {
        softAssertion.assertEquals(jobLocation, profilePagePo.getJobLocation().getText(), "The job location is't correct");
        MyLogger.getLogger().info(jobLocation.equals(profilePagePo.getJobLocation().getText()) ?
                "The job location is correct" : "The job location is't correct");
    }

    @Step("PageElementBO Step: Check the user production category")
    public void verifyProductionCategory(String productionCategory) {
        softAssertion.assertEquals(productionCategory, profilePagePo.getProductionCategory().getText(),
                "productionCategory is't correct");
        MyLogger.getLogger().info(productionCategory.equals(profilePagePo.getProductionCategory().getText()) ?
                "The Production category is correct" : "The production category is't correct");
    }

    @Step("PageElementBO Step: Check the user job function")
    public void verifyJobFunction(String jobFunction) {
        softAssertion.assertTrue(isJobFunctionCorrect(jobFunction), "The job function is't correct");
        MyLogger.getLogger().info(isJobFunctionCorrect(jobFunction) ?
                "The job function is correct" : "The job function is't correct");
    }

    @Step("PageElementBO Step: Check the user primary skill")
    public void verifyPrimarySkill(String primarySkill) {
        softAssertion.assertEquals(primarySkill, profilePagePo.getPrimarySkill().getText(),
                "The primary skill is't correct");
        MyLogger.getLogger().info(primarySkill.equals(profilePagePo.getPrimarySkill().getText()) ?
                "The primary skill is correct" : "The primary skill is't correct");
        softAssertion.assertAll();
    }

    public boolean isJobFunctionCorrect(String jobFunction) {
        String strFromProfile = profilePagePo.getJobFunction().getText();
        if (jobFunction.length() - 1 == strFromProfile.length()) {
            for (int i = 0; i < strFromProfile.length(); i++) {
                if (jobFunction.charAt(i) == '\\')
                    continue;
                if (jobFunction.charAt(i) != strFromProfile.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else
            return false;
    }
}

