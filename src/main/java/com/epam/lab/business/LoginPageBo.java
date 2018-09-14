package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import org.apache.log4j.Level;
import com.epam.lab.page.LoginPagePo;

import static com.epam.lab.core.util.Constants.LOGIN_PAGE_URL;

public class LoginPageBo {

    private LoginPagePo loginPagePo;

    public LoginPageBo() {
        loginPagePo = new LoginPagePo();
        DriverManager.getDriver().get(LOGIN_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    public void logIn(String login, String password) {
        loginPagePo.enterLogin(login);
        loginPagePo.enterPassword(password);
        loginPagePo.clickSubmit();
    }
}
