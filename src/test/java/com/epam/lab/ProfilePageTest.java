package com.epam.lab;

import com.epam.lab.business.LoginPageBo;
import com.epam.lab.business.ProfilePageBo;
import com.epam.lab.core.util.CsvParser;
import com.epam.lab.core.util.User;
import com.epam.lab.core.util.reportListeners.TestListener;
import io.qameta.allure.Description;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.epam.lab.core.util.Constants.CSV_PATH;

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


}
