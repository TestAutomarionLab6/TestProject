package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;

public class TrainingPagePo extends AbstractPage {

    @LogMessage("Professional Growth button")
    @FindBy(xpath = "//*[@data-filter=\"Professional Growth\"]")
    private PageElement profGrowthButton;

    @LogMessage("Personal Training card button")
    @FindBy(xpath = "//*[starts-with(@class,'"+START_CLASSNAME_PROFILE_PAGE+"StylishInformer-lightBottomLine__text')]")
    private PageElement trainingCard;

    @LogMessage("'See more' button")
    @FindBy(xpath = "(//*[starts-with(@class,'Informer---index---disDraggableButton')])[1]")
    private PageElement seeMoreButton;

    @LogMessage("'By year' button")
    @FindBy(xpath = "//*[@class='"+START_CLASSNAME_PROFILE_PAGE+"InformerQuickView-tabbedView__NavLink']")
    private PageElement byYearButton;

    @LogMessage("'By type' button")
    @FindBy(xpath = "//*[@class='active "+START_CLASSNAME_PROFILE_PAGE+"InformerQuickView-tabbedView__NavLink']")
    private PageElement byTypeButton;

    public PageElement getProfGrowthButton() {
        return profGrowthButton;
    }

    public PageElement getTrainingCard() {
        return trainingCard;
    }

    public PageElement getSeeMoreButton() {
        return seeMoreButton;
    }

    public PageElement getByYearButton() {
        return byYearButton;
    }
  
    public PageElement getByTypeButton() {
        return byTypeButton;
    }
}
