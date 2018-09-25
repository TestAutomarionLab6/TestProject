package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("UPSA button")
    @FindBy(xpath = "//*[@class=\""+START_CLASSNAME_PROFILE_PAGE+"EntryLinks__adapters\"]")
    private PageElement upsaButton;

    @LogMessage("UPSA logo")
    @FindBy(id = "upsaLogo")
    private PageElement upsaLogo;

    public PageElement getUPSAButton() {
        return upsaButton;
    }

    public PageElement getUPSALogo() {
        return upsaLogo;
    }
}
