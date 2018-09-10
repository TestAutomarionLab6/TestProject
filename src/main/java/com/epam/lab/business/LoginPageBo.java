package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.Constants;
import com.epam.lab.page.LoginPagePo;

public class LoginPageBo {

    private LoginPagePo loginPagePo;

    public LoginPageBo() {
        loginPagePo = new LoginPagePo();
        DriverManager.getDriver().get(Constants.LOGIN_PAGE_URL);

    }


    public void logIn(String login, String password) {
        loginPagePo.enterLogin(login);
        loginPagePo.enterPassword(password);
        loginPagePo.clickSubmit();
    }
}
