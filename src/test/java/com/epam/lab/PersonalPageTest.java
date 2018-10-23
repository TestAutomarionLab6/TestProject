package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.PersonalPageBo;
import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CREDENTIALS_CSV_PATH;

@Listeners({TestListener.class})
public class PersonalPageTest implements ITestNGListener {

    private PersonalPageBo personalPageBo;
    private LoginPageBo loginPageBo;
    private User user;

    @BeforeMethod
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCredCsv(CREDENTIALS_CSV_PATH);
        loginPageBo = new LoginPageBo();
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        personalPageBo = new PersonalPageBo();
    }

    @Test(description = "Verify the functionality of Personal card with invalid data....")
    @Description("PersonalPageTest Description: Verify the functionality of Personal card with invalid data....")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPersonalCardWithValidData() {
        personalPageBo.verifyCardByGeneralInfo();
        personalPageBo.verifyCardByInvalidEmergencyContacts();
    }

    @Test(description = "Verify the functionality of Personal card with valid data....")
    @Description("PersonalPageTest Description: Verify the functionality of Personal card with valid data....")
    @Severity(SeverityLevel.NORMAL)
    public void verifyTrainingCardWithInvalidData() {
        personalPageBo.verifyCardByGeneralInfo();
        personalPageBo.verifyCardByValidEmergencyContacts();
    }

    @AfterMethod
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
