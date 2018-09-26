package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.LoginPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;

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
        keepMeSignedIn();
        clickSubmit();
    }

    @Step("PageElementBO Step: Enter login: {0} in login input field in method: {enterLogin}...")
    public void enterLogin(String login) {
        loginPagePo.getLoginField().clear();
        loginPagePo.getLoginField().sendKeys(login);
    }

    @Step("PageElementBO Step: Enter password: {0} in password input field in method: {enterPassword}...")
    public void enterPassword(String password) {
        loginPagePo.getPasswordField().clear();
        loginPagePo.getPasswordField().sendKeys(password);
    }

    @Step("PageElementBO Step: Submit login form in login page in method: {clickSubmit}...")
    public void clickSubmit() {
        loginPagePo.getSubmitButton().click();
    }

    @Step("PageElementBO Step: click on checkbox Keep me logged in system...")
    public void keepMeSignedIn() {
        loginPagePo.getKeepMeSignedIn().click();
    }


    @Step("PageElementBO Step: click on link password.epam.com...")
    public void passwordEpamComLink() {
        loginPagePo.getPasswordEpamComLink().click();
    }

    @Step("PageElementBO Step: go back...")
    public void goBack() {
        DriverManager.getDriver().navigate().back();
    }

    @Step("PageElementBO Step: go to Privacy Policy link...")
    public void privacyPolicyLink() {
        loginPagePo.getPrivacyPolicyLink().click();
    }

    @Step("PageElementBO Step: go to Self Service link...")
    public void selfServiceLink() {
        loginPagePo.getSelfServiceLink().click();
    }

    @Step("PageElementBO Step: get href attribute for link...")
    public String hrefLink() {
        return loginPagePo.getLink().getAttribute("href");
    }

}
