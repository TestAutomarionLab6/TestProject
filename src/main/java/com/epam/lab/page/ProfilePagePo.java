package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Cover image")
    @FindBy(xpath = "//div[@theme=\"stylishGeneralInfo\"]/div/div/img")
    private PageElement coverImage;

    public PageElement getCoverImage() {
        return coverImage;
    }
}
