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

    @Test(priority = 0, description = "Verify if button UPSA is active")
    @Description("ProfileTest Description: Verify if button UPSA is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyUPSAButton() {
        profilePageBo.clickOnUPSAButton();
        profilePageBo.switchToUPSA();
        profilePageBo.waitUPSALogo();
        profilePageBo.verifyUPSAButton();

    }

    @Test(priority = 0, description = "Verify if button Heroes is active")
    @Description("ProfileTest Description: Verify if button Heroes is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyHeroesButton() {
        profilePageBo.clickOnHeroesButton();
        profilePageBo.switchToHeroes();
        profilePageBo.waitHeroesLogo();
        profilePageBo.verifyHeroesButton();
    }

    @Test(priority = 0, description = "Verify if Profile button shows a profile page")
    @Description("ProfileTest Description: Verify if Profile button shows a profile page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyProfileButton() {
        profilePageBo.clickOnWallButton();
        profilePageBo.clickOnProfileButton();
        profilePageBo.verifyProfilePage();
    }

    @Test(priority = 0, description = "Verify if Wall button shows a wall")
    @Description("ProfileTest Description: Verify if Wall button shows a wall")
    @Severity(SeverityLevel.NORMAL)
    public void verifyWallButton() {
        profilePageBo.clickOnWallButton();
        profilePageBo.verifyWallPage();
    }

    @Test(priority = 0, description = "Verify if data on profile page comply with person data")
    @Description("ProfileTest Description: Verify if data on profile page comply with person data")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPersonalData() {
    	profilePageBo.verifyPersonalData(user.getFirstAndLastName(), user.getJobTitle(), user.getJobLocation(),
    		user.getProductionCategory(),  user.getJobFunction(), user.getPrimarySkill() );    	
    }
    
    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }

}
