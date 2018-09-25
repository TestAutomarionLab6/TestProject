package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class HomePagePo extends AbstractPage {

    @LogMessage("dropDownMenu")
    @FindBy(xpath = "//div[starts-with(@class, 'UserMenu')]/div[starts-with(@class,'DropDownMenu')]/div[starts-with(@class,'DropDownMenu')]/div[starts-with(@class,'DropDownMenu')]")
    private PageElement dropDownMenu;
    @LogMessage("logout")
    @FindBy(xpath = "//div[starts-with(@class,'DropDownMenu')]/div[starts-with(@class,'UserMenu')]/a[@class and @href]")
    private PageElement logout;

    public PageElement getDropDownMenu() {
        return dropDownMenu;
    }

    public PageElement getLogout() {
        return logout;
    }

}
