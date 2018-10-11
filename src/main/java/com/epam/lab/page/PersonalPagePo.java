package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    @FindBy(xpath = "//*[starts-with(@class,'QuickViewSideTabs---index---menuItemActive')][@data-tab='0']")
    private PageElement generalInfoButton;

    @LogMessage("footer label")
    @FindBy(xpath = "(//*[starts-with(@class,'QuickView---index---tableFooter')])[1]")
    private PageElement footerLabel;

    @LogMessage("'Emergency Contacts' button")
    @FindBy(xpath = "//*[starts-with(@class,'QuickViewSideTabs---index---menuItemUnActive')][@data-tab='1']")
    private PageElement emergencyContactsButton;

    @LogMessage("'Name' input")
    @FindBy(xpath = "//*[@name='name']")
    private PageElement nameInput;

    @LogMessage("'Relationship' input")
    @FindBy(xpath = "//*[@name='description']")
    private PageElement descriptionInput;

    @LogMessage("'Phone' input")
    @FindBy(xpath = "//*[@name='phone']")
    private PageElement phoneInput;

    @LogMessage("'Add' button")
    @FindBy(xpath = "//*[@class=\"btn btn-primary\"]")
    private PageElement addButton;

    @LogMessage("'Emergency contacts' table row")
    @FindBy(xpath = "//*[starts-with(@class,'TableRow---index---tableRow')]")
    private List<PageElement> contactTableRow;


    @LogMessage("footer label on emergency contacts")
    @FindBy(xpath = "(//*[starts-with(@class,'QuickView---index---tableFooter')])[2]")
    private PageElement secondFooterLabel;

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

    public PageElement getEmergencyContactsButton(){ return emergencyContactsButton; }

    public PageElement getSecondFooterLabel(){ return secondFooterLabel; }

    public PageElement getNameInput() { return nameInput; }

    public PageElement getDescriptionInput() {
        return descriptionInput;
    }

    public PageElement getPhoneInput() {
        return phoneInput;
    }

    public PageElement getAddButton() {
        return addButton;
    }

    public List<PageElement> getContactTableRow() {
        return contactTableRow;
    }
}
