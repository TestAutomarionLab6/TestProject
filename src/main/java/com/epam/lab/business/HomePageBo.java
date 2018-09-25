package com.epam.lab.business;

import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.HomePagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;

public class HomePageBo {

    private HomePagePo homePagePo;


    public HomePageBo() {
        homePagePo= new HomePagePo();
        MyLogger myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
    }

    @Step("PageElementBO Step: logout...")
    public void logout() {
        homePagePo.waitElement(homePagePo.getDropDownMenu());
        homePagePo.getDropDownMenu().click();
        homePagePo.getLogout().click();
    }
}
