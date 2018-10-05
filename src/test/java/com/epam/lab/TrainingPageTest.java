package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.TrainingPageBo;
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
public class TrainingPageTest implements ITestNGListener {

    private TrainingPageBo trainingPageBo;
    private LoginPageBo loginPageBo;
    private User user;

    @BeforeTest
    @Description("Loading configurations before test")
    public void setup() {
        user = CsvParser.createObjectsFromCsv(CSV_PATH);
        loginPageBo = new LoginPageBo();
        loginPageBo.logIn(user.getLogin(), user.getPassword());
        trainingPageBo = new TrainingPageBo();
    }

    @Test(description = "Verify the functionality of Professional Training card....")
    @Description("TrainingPageTest Description: Verify the functionality of Professional Training card....")
    @Severity(SeverityLevel.NORMAL)
    public void verifyTrainingCard() {
        trainingPageBo.verifyTrainingCard();
    }

    @AfterTest
    @Description("Exit from program")
    public void quit() {
        DriverManager.removeDriver();
    }
}
