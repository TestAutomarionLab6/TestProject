package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Cover image")
    @FindBy(xpath = "//*[@class=\"" + START_CLASSNAME_PROFILE_PAGE +
            "LocationCoverImage__imageBlock_image " + START_CLASSNAME_PROFILE_PAGE +
            "LocationCoverImage__imageBlock_image-loaded\"]")
    private PageElement coverImage;
    @LogMessage("Feedback button")
    @FindBy(xpath = "//*[@id=\"uservoice-custom-widget\"]")
    private PageElement feedbackButton;
    @LogMessage("Title label")
    @FindBy(xpath = "//h1[@class=\"pane-title\"]")
    private PageElement titleLabel;
    @LogMessage("UPSA button")
    @FindBy(xpath = "//*[@class=\"" + START_CLASSNAME_PROFILE_PAGE + "EntryLinks__adapters\"]")
    private PageElement upsaButton;
    @LogMessage("UPSA logo")
    @FindBy(id = "upsaLogo")
    private PageElement upsaLogo;
    @LogMessage("Heroes button")
    @FindBy(xpath = "//*[@class=\"" + START_CLASSNAME_PROFILE_PAGE + "EntryLinks__socialIconContainer\"]")
    private PageElement heroesButton;
    @LogMessage("Heroes logo")
    @FindBy(xpath = "//*[@id=\"profileBlock\"]/div/div[2]/img")
    private PageElement heroesLogo;
    @LogMessage("Profile button")
    @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-informers.wfep\"]")
    private PageElement profileButton;
    @FindBy(xpath = "//li[@role=\"presentation\"][1]")
    private PageElement profileView;
    @LogMessage("Wall button")
    @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-wallview.wfep\"]")
    private PageElement wallButton;
    @LogMessage("All Contacts button")    
    @FindBy(xpath = "//*[@class=\"v-eppplGeneralInfo__photoButtons e3suiGeneralInfo-stylishTemplate__entryInfoLeft\"]/div[2]/div[1]")    
    private WebElement allContactsButton;
    @LogMessage("All Contacts button list")    
    @FindBy(xpath = "//*[@class=\"v-eppplGeneralInfo__photoButtons e3suiGeneralInfo-stylishTemplate__entryInfoLeft\"]/div[2]/div[1]")    
    private List<WebElement> allContactsButtonList;
    @LogMessage("Phone")
    @FindBy(xpath = "//*[@id=\"popover-positioned-bottom\"]/div[2]/div/a[1]/span[2]")
    private PageElement phone;
    @LogMessage("Email")
    @FindBy(xpath = "//*[@id=\"popover-positioned-bottom\"]/div[2]/div/a[2]/span[2]")
    private PageElement email;
    @LogMessage("Skype")
    @FindBy(xpath = "//*[@id=\"popover-positioned-bottom\"]/div[2]/div/a[3]/span[2]")
    private PageElement skype;
    @LogMessage("Email2")
    @FindBy(xpath = "//*[@id=\"popover-positioned-bottom\"]/div[2]/div/a[4]/span[2]")
    private PageElement email2;
    @LogMessage("First And LastName")
    @FindBy(xpath = "//span[@class='v-eppplGeneralInfo__nameText false']")
    private PageElement firstAndLastName;
    @LogMessage("Job Title")
    @FindBy(xpath = "//div[contains(@class,'v-eppplGeneralInfo__jobTitle false e3suiGeneralInfo-stylishTemplate__entryDescriptionItem')]")
    private PageElement jobTitle;
    @LogMessage("Job Location")
    @FindBy(xpath = "//div[@class='v-eppplGeneralInfo__jobLocation e3suiGeneralInfo-stylishTemplate__entryDescriptionItem']")
    private PageElement jobLocation;
    @LogMessage("Production Category")
    @FindBy(xpath = "//*[@id=\"rgn___epam_people_profile_v-eppplGeneralInfo\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/p[1]")
    private PageElement productionCategory;
    @LogMessage("job Function")
    @FindBy(xpath = "//*[@id=\"rgn___epam_people_profile_v-eppplGeneralInfo\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/p[1]")
    private PageElement jobFunction;
    @LogMessage("Primary Skill")
    @FindBy(xpath = "//*[@id=\"rgn___epam_people_profile_v-eppplGeneralInfo\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/p[1]")
    private PageElement primarySkill;
    @LogMessage("Popover button")
    @FindBy(xpath = "//*[@id=\"rgn___epam_people_profile_v-eppplGeneralInfo\"]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h1[1]/span[2]")
    private PageElement popoverSign; 
    @LogMessage("Native Name")
    @FindBy(xpath = "//div[@class='popover-content']/div[2]")
    private PageElement nativeName; 

    public PageElement getUPSAButton() {
        return upsaButton;
    }

    public PageElement getUPSALogo() {
        return upsaLogo;
    }

    public PageElement getHeroesButton() {
        return heroesButton;
    }

    public PageElement getHeroesLogo() {
        return heroesLogo;
    }

    public PageElement getProfileButton() {
        return profileButton;
    }

    public PageElement getWallButton() {
        return wallButton;
    }

    public PageElement getProfileView() {
        return profileView;
    }
    
    public List<WebElement> getAllContactsButtonList() {    	
    	return allContactsButtonList;
    }   

    public PageElement getPhone() {
        return phone;
    }
    
    public PageElement getEmail() {
        return email;
    }
    
    public PageElement getSkype() {
        return skype;
    }
    
    public PageElement getEmail2() {
        return email2;
    }
    
    public PageElement getFirstAndLastName() {
        return firstAndLastName;
    }
    
    public PageElement getJobTitle() {
        return jobTitle;
    }
    
    public PageElement getJobLocation() {
        return jobLocation;
    }
    
    public PageElement getProductionCategory() {
        return productionCategory;
    }
    
    public PageElement getJobFunction() {
        return jobFunction;
    }
    
    public PageElement getPrimarySkill() {
        return primarySkill;
    }
    
    public PageElement getPopoverSign() {
        return popoverSign;
    }
    
    public PageElement getNativeName() {
        return nativeName;
    }

    public PageElement getCoverImage() {
        return coverImage;
    }

    public PageElement getFeedbackButton() {
        return feedbackButton;
    }

    public PageElement getTitleLabel() {
        return titleLabel;
    }

}
