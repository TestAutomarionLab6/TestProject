package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
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

    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
