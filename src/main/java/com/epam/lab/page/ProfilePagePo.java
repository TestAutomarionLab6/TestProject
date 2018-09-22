package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Heroes button")
    @FindBy(xpath = "//*[@data-type=\"hero.epam.com\"]")
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
}
