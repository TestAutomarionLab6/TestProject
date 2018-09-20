package com.epam.lab.page;

import com.epam.lab.core.pageElement.PageElement;
import com.epam.lab.core.util.LogMessage;
import org.openqa.selenium.support.FindBy;

public class HomePagePo {

    @LogMessage("dropDownMenu")
    @FindBy(xpath = "//*[@id=\"rgn_pageBody_e3suiHeaderNav\"]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]")
    private PageElement dropDownMenu;
    @LogMessage("logout")
    @FindBy(xpath = "//*[@id=\"rgn_pageBody_e3suiHeaderNav\"]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[2]/div[1]/a[1]")
    private PageElement logout;

    public PageElement getDropDownMenu() {
        return dropDownMenu;
    }

    public PageElement getLogout() {
        return logout;
    }

}
