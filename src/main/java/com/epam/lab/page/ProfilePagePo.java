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

    @LogMessage("Heroes button")
    @FindBy(xpath = "//*[@class=\""+START_CLASSNAME_PROFILE_PAGE+"EntryLinks__socialIconContainer\"]")
    private PageElement heroesButton;

    @LogMessage("Heroes logo")
    @FindBy(xpath = "//*[@id=\"profileBlock\"]/div/div[2]/img")
    private PageElement heroesLogo;

    public PageElement getHeroesButton() {
        return heroesButton;
    }

    public PageElement getHeroesLogo() {
        return heroesLogo;
    }

public class ProfilePagePo extends AbstractPage {

        @LogMessage("Profile button")
        @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-informers.wfep\"]")
        private PageElement profileButton;

       @FindBy(xpath = "//li[@role=\"presentation\"][1]")
        private PageElement profileView;

        public PageElement getProfileButton() {
                return profileButton;

        @LogMessage("Wall button")
        @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-wallview.wfep\"]")
        private PageElement wallButton;

        @FindBy(xpath = "//li[@role=\"presentation\"][1]")
        private PageElement profileView;

        public PageElement getWallButton() {
            return wallButton;
        }

        public PageElement getProfileView() {
                return profileView;
        }
}
