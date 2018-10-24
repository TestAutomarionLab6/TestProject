package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.ProfilePageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.UserData;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CREDENTIALS_CSV_PATH;
import static com.epam.lab.core.util.Constants.DATA_CSV_PATH;

@Listeners({TestListener.class})
public class ProfilePageTest implements ITestNGListener {

    private LoginPageBo loginPageBo;
    private ProfilePageBo profilePageBo;
    private User user;
    private UserData userData;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
        userData = CsvParser.createObjectsFromDataCsv(DATA_CSV_PATH);
        loginPageBo = new LoginPageBo();
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        profilePageBo = new ProfilePageBo();
    }

    @Test(description = "Verify if Cover image is displayed")
    @Description("ProfileTest Description: Verify if Cover image is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCoverImage() {
        profilePageBo.verifyDisplayedImage();
    }

    @Test(description = "Verify if button UPSA is active")
    @Description("ProfileTest Description: Verify if button UPSA is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyUPSAButton() {
        profilePageBo.clickOnUPSAButton();
        profilePageBo.switchToUPSA();
        profilePageBo.waitUPSALogo();
        profilePageBo.verifyUPSAButton();
        profilePageBo.switchToTelescope();
    }

    @Test(description = "Verify if Profile button shows a profile page")
    @Description("ProfileTest Description: Verify if Profile button shows a profile page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyProfileButton() {
        profilePageBo.clickOnProfileButton();
        profilePageBo.verifyProfilePage();
    }

    @Test(description = "Verify if Wall button shows a wall")
    @Description("ProfileTest Description: Verify if Wall button shows a wall")
    @Severity(SeverityLevel.NORMAL)
    public void verifyWallButton() {
        profilePageBo.clickOnWallButton();
        profilePageBo.verifyWallPage();
    }

    @Test(description = "Verify if PAST PROJECTS button shows past projects")
    @Description("ProfileTest Description: Verify if PAST PROJECTS button shows past projects")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPastProjectsButton() {
        profilePageBo.clickOnPastProjectsButton();
        profilePageBo.verifyPastProjectsPage();
    }

    @Test(description = "Verify if Feedback button shows feedback window")
    @Description("ProfileTest Description: Verify if Feedback button shows feedback window")
    @Severity(SeverityLevel.NORMAL)
    public void verifyFeedbackButton() {
        profilePageBo.verifyFeedbackButton();
    }

    @Test(description = "Verify if data on profile page comply with person data")
    @Description("ProfileTest Description: Verify if data on profile page comply with person data")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPersonalData() {
        profilePageBo.verifyFirstAndLastName(userData.getFirstAndLastName());
        profilePageBo.verifyJobTitle(userData.getJobTitle());
        profilePageBo.verifyJobLocation(userData.getJobLocation());
        profilePageBo.verifyProductionCategory(userData.getProductionCategory());
        profilePageBo.verifyJobFunction(userData.getJobFunction());
        profilePageBo.verifyPrimarySkill(userData.getPrimarySkill());
    }

    @Test(description = "Verify if data on profile page comply with contacts")
    @Description("ProfileTest Description: Verify if data on profile page comply with contacts")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPersonalContacts() {
        profilePageBo.clickOnContacts();
        profilePageBo.verifyPersonalMobilePhone(userData.getMobilePhone());
        profilePageBo.verifyPersonalPhoneNumber(userData.getPhone());
        profilePageBo.verifyPersonalEmail(userData.getEmail());
        profilePageBo.verifyPersonalSkype(userData.getSkype());
        profilePageBo.verifyPersonalSkypeForBusiness(userData.getSkypeForBusiness());
        profilePageBo.clickOnContacts();
    }

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
