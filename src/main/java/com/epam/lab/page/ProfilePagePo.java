package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.core.util.Constants.START_CLASSNAME_PROFILE_PAGE;

public class ProfilePagePo extends AbstractPage {

    @LogMessage("Cover image")
    @FindBy(xpath = "//*[@class=\"" + START_CLASSNAME_PROFILE_PAGE +
            "LocationCoverImage__imageBlock_image " + START_CLASSNAME_PROFILE_PAGE +
            "LocationCoverImage__imageBlock_image-loaded\"]")
    private PageElement coverImage;

    public PageElement getCoverImage() {
        return coverImage;
    }
}
