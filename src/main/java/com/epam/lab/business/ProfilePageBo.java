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
  	public void clickOnPopoverButton() {
  		profilePagePo.getPopoverSign().click();
  	}
    
    @Step("PageElementBO Step: Verify the wall page")
    public void verifyNativeName( String nativeName ) {        
        softAssertion.assertEquals(nativeName, profilePagePo.getNativeName().getText(), "Native name is't correct");
        MyLogger.getLogger().info( nativeName.equals(profilePagePo.getNativeName().getText()) ?
        		"native name is correct" : "native name is't correct");
        
    }
    
    @Step("PageElementBO Step: Verify All Contacts")
    public void verifyPersonalData(String firstAndLastName, String jobTitle, String jobLocation,
    		                       String productionCategory,String jobFunction, String primarySkill ) { 
    	
        softAssertion.assertEquals(firstAndLastName, profilePagePo.getFirstAndLastName().getText(), "First And Last Name is't correct");
        MyLogger.getLogger().info( firstAndLastName.equals(profilePagePo.getFirstAndLastName().getText()) ? 
        		                   "FirstAndLastName is correct" : "FirstAndLastName is't correct");
        
        softAssertion.assertEquals(jobTitle, profilePagePo.getJobTitle().getText(), "jobTitle is't correct");
        MyLogger.getLogger().info( jobTitle.equals(profilePagePo.getJobTitle().getText()) ? 
        		                   "jobTitle number is correct" : "jobTitle number is't correct");
        
        softAssertion.assertEquals(jobLocation, profilePagePo.getJobLocation().getText(), "jobLocation is't correct");
        MyLogger.getLogger().info( jobLocation.equals(profilePagePo.getJobLocation().getText()) ?
        		                   "jobLocation is correct" : "jobLocation is't correct");
        
        softAssertion.assertEquals(productionCategory, profilePagePo.getProductionCategory().getText(), "productionCategory is't correct");
        MyLogger.getLogger().info( productionCategory.equals(profilePagePo.getProductionCategory().getText()) ?
        		                   "productionCategory is correct" : "productionCategory is't correct");
        
        softAssertion.assertTrue( isJobFunctionCorrect(jobFunction), "jobFunction is't correct");
        MyLogger.getLogger().info( isJobFunctionCorrect(jobFunction) ?
        		                   "jobFunction is correct" : "jobFunction is't correct");
        
        softAssertion.assertEquals(primarySkill, profilePagePo.getPrimarySkill().getText(), "primarySkill is't correct");
        MyLogger.getLogger().info( primarySkill.equals(profilePagePo.getPrimarySkill().getText()) ?
        		                   "primarySkill is correct" : "primarySkill is't correct");
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
