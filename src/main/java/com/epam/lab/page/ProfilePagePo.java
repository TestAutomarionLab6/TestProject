package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class ProfilePagePo extends AbstractPage {

        @LogMessage("Profile button")
        @FindBy(xpath = "//*[@data-id=\"~/epam/people/controls/profile/eppplGenericPersonalProfile-informers.wfep\"]")
        private PageElement profileButton;

       @FindBy(xpath = "//li[@role=\"presentation\"][1]")
        private PageElement profileView;

        public PageElement getProfileButton() {
                return profileButton;
        }

        public PageElement getProfileView() {
                return profileView;
        }
}
