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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.core.util.Constants.CSV_PATH;

@Listeners({TestListener.class})
public class PersonalPageTest implements ITestNGListener {

    private PersonalPageBo personalPageBo;
    private LoginPageBo loginPageBo;
    private User user;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        personalPageBo = new PersonalPageBo();
    }

    @Test(description = "Verify the functionality of Personal card....")
    @Description("TrainingPageTest Description: Verify the functionality of Personal card....")
    @Severity(SeverityLevel.NORMAL)
    public void verifyTrainingCard() {
        personalPageBo.verifyCardByGeneralInfo();
        personalPageBo.verifyDeletingEmergencyContacts();
    }

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
