package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class LoginPagePo extends AbstractPage {
    @FindBy(id = "userNameInput")
    private PageElement loginField;
    @FindBy(id = "passwordInput")
    private PageElement passwordField;
    @FindBy(id = "submitButton")
    private PageElement submitButton;


    @Step("PageElementPO Step: Enter login: {0} in login input field in method: {enterLogin}...")
    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("PageElementPO Step: Enter password: {0} in password input field in method: {enterPassword}...")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("PageElementPO Step: Submit login form in login page in method: {clickSubmit}...")
    public void clickSubmit() {
        submitButton.click();
    }
}
