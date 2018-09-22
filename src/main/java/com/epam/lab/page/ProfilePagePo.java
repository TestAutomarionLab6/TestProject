package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

        @LogMessage("Wall button")
        @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-wallview.wfep\"]")
        private PageElement wallButton;

        public PageElement getWallButton() {
            return wallButton;
        }
}
