package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("UPSA button")
    @FindBy(xpath = "//*[@id=\"rgn___epam_people_profile_v-eppplGeneralInfo\"]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/span")
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
