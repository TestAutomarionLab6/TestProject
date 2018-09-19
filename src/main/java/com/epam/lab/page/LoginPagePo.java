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
    //TODO this is PageElement for home page not login page
    @LogMessage("dropDownMenu")
    @FindBy(xpath = "//*[@id=\"rgn_pageBody_e3suiHeaderNav\"]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]")
    private PageElement dropDownMenu;
    //TODO this is PageElement for home page not login page
    @LogMessage("logout")
    @FindBy(xpath = "//*[@id=\"rgn_pageBody_e3suiHeaderNav\"]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/a[1]")
    private PageElement logout;
    @LogMessage("checkbox Keep me signed in")
    @FindBy(id = "kmsiInput")
    private PageElement keepMeSignedIn;
    @LogMessage("password.epam.com link")
    @FindBy(xpath = "//*[@id=\"introduction\"]/a[1]")
    private PageElement passwordEpamCom;
    @LogMessage("Privacy Policy link")
    @FindBy(xpath = "//*[@id=\"home\"]")
    private PageElement privacyPolicyLink;
    @LogMessage("Self Service Link")
    @FindBy(xpath = "//*[@id=\"helpDesk\"]")
    private PageElement selfServiceLink;
    @LogMessage("Support Link")
    @FindBy(xpath = "//*[@id=\"privacy\"]")
    private PageElement supportLink;
    
    public PageElement getLoginField() {
        return loginField;
    }

    public PageElement getPasswordField() {
        return passwordField;
    }

    public PageElement getSubmitButton() {
        return submitButton;
    }   
    
    public PageElement getDropDownMenu() {
        return dropDownMenu;
    }
    
    public PageElement getLogout() {
        return logout;
    }
    
    public PageElement getKeepMeSignedIn() {
        return keepMeSignedIn;
    }
    
    public PageElement getPasswordEpamComLink()  {
    	return passwordEpamCom;
    }
    
    public PageElement getPrivacyPolicyLink()  {
    	return privacyPolicyLink;
    }
    
    public PageElement getSelfServiceLink()  {
    	return selfServiceLink;
    }
    
    public PageElement getLink()  {
    	return supportLink;
    }
    
}
