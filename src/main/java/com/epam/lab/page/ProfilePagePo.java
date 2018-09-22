package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Feedback button")
    @FindBy(xpath = "//*[@id=\"uservoice-custom-widget\"]")
    private PageElement feedbackButton;

    @LogMessage("Close button")
    @FindBy(xpath = "//button[@aria-label=\"Close Feedback Widget\"]")
    private PageElement closeFeedbackButton;

    public PageElement getFeedbackButton() {
        return feedbackButton;
    }

    public PageElement getCloseFeedback() {
        return closeFeedbackButton;
    }
}
