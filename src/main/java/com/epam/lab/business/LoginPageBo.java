package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.Constants;
import com.epam.lab.page.LoginPagePo;
import io.qameta.allure.Step;

public class LoginPageBo {

    private LoginPagePo loginPagePo;

    public LoginPageBo() {
        loginPagePo = new LoginPagePo();
        DriverManager.getDriver().get(Constants.LOGIN_PAGE_URL);

    }

    @Step("LoginPageBO with login: {0}, password: {1} for method: {logIn} step...")
    public void logIn(String login, String password) {
        loginPagePo.enterLogin(login);
        loginPagePo.enterPassword(password);
        loginPagePo.clickSubmit();
    }
}
