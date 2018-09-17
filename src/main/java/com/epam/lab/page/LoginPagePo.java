package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class LoginPagePo extends AbstractPage {
    @LogMessage("Username")
    @FindBy(id = "userNameInput")
    private PageElement loginField;
    @LogMessage("Password")
    @FindBy(id = "passwordInput")
    private PageElement passwordField;
    @LogMessage("Submit")
    @FindBy(id = "submitButton")
    private PageElement submitButton;


    public PageElement getLoginField() {
        return loginField;
    }

    public PageElement getPasswordField() {
        return passwordField;
    }

    public PageElement getSubmitButton() {
        return submitButton;
    }
}
