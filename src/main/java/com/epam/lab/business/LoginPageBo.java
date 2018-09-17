package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import org.apache.log4j.Level;
import com.epam.lab.page.LoginPagePo;
import io.qameta.allure.Step;

import static com.epam.lab.core.util.Constants.LOGIN_PAGE_URL;

public class LoginPageBo {

    private LoginPagePo loginPagePo;

    public LoginPageBo() {
        loginPagePo = new LoginPagePo();
        DriverManager.getDriver().get(LOGIN_PAGE_URL);
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("LoginPageBO with login: {0}, password: {1} for method: {logIn} step...")
    public void logIn(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        clickSubmit();
    }

    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterLogin}...")
    public void enterLogin(String login) {
        loginPagePo.getLoginField().sendKeys(login);
    }

    @Step("PageElementBO Step: Enter password: {0} in password input field in method: {enterPassword}...")
    public void enterPassword(String password) {
        loginPagePo.getPasswordField().sendKeys(password);
    }

    @Step("PageElementBO Step: Submit login form in login page in method: {clickSubmit}...")
    public void clickSubmit() {
        loginPagePo.getSubmitButton().click();
    }
}
