package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.ProfilePageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.CSV_PATH;

@Listeners({TestListener.class})
public class ProfilePageTest implements ITestNGListener {

    private LoginPageBo loginPageBo;
    private ProfilePageBo profilePageBo;
    private User user;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        profilePageBo = new ProfilePageBo();
    }

    @Test(priority = 0, description = "Verify if Cover image is displayed")
    @Description("ProfileTest Description: Verify if Cover image is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCoverImage() {
        profilePageBo.verifyDisplayedImage();
    }
  
    @Test(priority = 1, description = "Verify if button UPSA is active")
    @Description("ProfileTest Description: Verify if button UPSA is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyUPSAButton() {
        profilePageBo.clickOnUPSAButton();
        profilePageBo.switchToUPSA();
        profilePageBo.waitUPSALogo();
        profilePageBo.verifyUPSAButton();

    }

    @Test(priority = 2, description = "Verify if button Heroes is active")
    @Description("ProfileTest Description: Verify if button Heroes is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyHeroesButton() {
        profilePageBo.clickOnHeroesButton();
        profilePageBo.switchToHeroes();
        profilePageBo.waitHeroesLogo();
        profilePageBo.verifyHeroesButton();
    }

    @Test(priority = 3, description = "Verify if Profile button shows a profile page")
    @Description("ProfileTest Description: Verify if Profile button shows a profile page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyProfileButton() {
        profilePageBo.clickOnWallButton();
        profilePageBo.clickOnProfileButton();
        profilePageBo.verifyProfilePage();
    }

    @Test(priority = 4, description = "Verify if Wall button shows a wall")
    @Description("ProfileTest Description: Verify if Wall button shows a wall")
    @Severity(SeverityLevel.NORMAL)
    public void verifyWallButton() {
        profilePageBo.clickOnWallButton();
        profilePageBo.verifyWallPage();
    }
    
    @Test(priority = 0, description = "Verify if button All Contacts is active and with right info")		
    @Description("ProfileTest Description: Verify if data in All Contacts comply with personal data")
    @Severity(SeverityLevel.NORMAL)
    public void verifyAllContacts() {
    	profilePageBo.getAndClickAllContactsButton();
    	Assert.assertEquals( user.getPhone(), profilePageBo.getPhone());    	
    	Assert.assertEquals( user.getEmail(), profilePageBo.getEmail());    	
    	Assert.assertEquals( user.getSkype(), profilePageBo.getSkype());    	
    	Assert.assertEquals( user.getEmail2(), profilePageBo.getEmail2());
    	profilePageBo.getAndClickAllContactsButton();
    } 
  
    @Test(priority = 5, description = "Verify if Feedback button shows feedback window")
    @Description("ProfileTest Description: Verify if Feedback button shows feedback window")
    @Severity(SeverityLevel.NORMAL)
    public void verifyFeedbackButton() {
        profilePageBo.verifyFeedbackButton();
    }

    @Test(priority = 0, description = "Verify Native Name")
    @Description("ProfileTest Description: Verify Native Name after click on popover sign near First and Last Name")
    @Severity(SeverityLevel.NORMAL)
    public void verifyNativeName() { 
    	profilePageBo.clickOnPopoverButton();
    	profilePageBo.verifyNativeName( user.getNativeName() );
    	profilePageBo.clickOnPopoverButton();    	
    }
    
    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
