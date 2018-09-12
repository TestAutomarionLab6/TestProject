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
