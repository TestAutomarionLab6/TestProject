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
import static com.epam.lab.core.util.Constants.PROFILE_PAGE_WALL_URL;

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

    @Test(priority = 0, description = "Verify if button Wall is active")
    @Description("ProfileTest Description: Verify if button Wall is active")
    @Severity(SeverityLevel.NORMAL)
    public void verifyWallButton() {
        profilePageBo.verifyWallButton();
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(DriverManager.getDriver().getCurrentUrl(), PROFILE_PAGE_WALL_URL);
    }

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }

}
