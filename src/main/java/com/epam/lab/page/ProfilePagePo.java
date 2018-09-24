package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Feedback button")
    @FindBy(xpath = "//*[@id=\"uservoice-custom-widget\"]")
    private PageElement feedbackButton;

    @LogMessage("")
    @FindBy(xpath = "//h1[@class=\"pane-title\"]")
    private PageElement titleLabel;

    public PageElement getFeedbackButton() {
        return feedbackButton;
    }

    public PageElement getTitleLabel() {
        return titleLabel;
    }
}
