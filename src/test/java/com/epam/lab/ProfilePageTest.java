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
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CSV_PATH;
import static com.epam.lab.core.util.Constants.PROFILE_PAGE_UPSA_URL;

@Listeners({ TestListener.class })
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

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
