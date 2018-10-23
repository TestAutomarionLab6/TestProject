package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class HomePagePo extends AbstractPage {

    @LogMessage("dropDownMenu")
    @FindBy(xpath = "(//*[@class='DropDownMenu---index---angle---2M5f1 fa fa-angle-down'])[2]")
    private PageElement dropDownMenu;
    @LogMessage("logout")
    @FindBy(xpath = "//*[starts-with(@class,'UserMenu---index---logout')]")
    private PageElement logout;

    public PageElement getDropDownMenu() {
        return dropDownMenu;
    }

    public PageElement getLogout() {
        return logout;
    }

}
