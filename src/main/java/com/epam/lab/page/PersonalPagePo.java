package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;

public class PersonalPagePo extends AbstractPage {

    @LogMessage("Personal data tab button")
    @FindBy(xpath = "//*[@data-filter=\"Personal Data\"]")
    private PageElement personalDataButton;

    @LogMessage("Personal card button")
    @FindBy(xpath = "//img[starts-with(@class,\"Image---index---image\")]")
    private PageElement personalCard;

    @LogMessage("'See more' button")
    @FindBy(xpath = "(//*[starts-with(@class,'Informer---index---disDraggableButton')])[1]")
    private PageElement seeMoreButton;

    @LogMessage("'General info' button")
    @FindBy(xpath = "(//*[starts-with(@class,'QuickViewSideTabs---index---menuItemActive')])[1]")
    private PageElement generalInfoButton;

    @LogMessage("footer label")
    @FindBy(xpath = "(//*[starts-with(@class,'QuickView---index---tableFooter')])[1]")
    private PageElement footerLabel;

    public PageElement getPersonalDataButton() {
        return personalDataButton;
    }

    public PageElement getPersonalCard() {
        return personalCard;
    }

    public PageElement getSeeMoreButton() {
        return seeMoreButton;
    }

    public PageElement getGeneralInfoButton() {
        return generalInfoButton;
    }

    public PageElement getFooterLabel() {
        return footerLabel;
    }
}
