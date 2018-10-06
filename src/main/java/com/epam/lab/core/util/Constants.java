package com.epam.lab.core.util;

public class Constants {
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
    public static final String LOGIN_PAGE_URL = "https://telescope.epam.com/";
    public static final String PROFILE_PAGE_URL = "https://telescope.epam.com/who/Yevhen_Hrafov";
    public static final String TRAINING_PAGE_URL = "https://telescope.epam.com/who/?tab=profile";
    public static final String START_CLASSNAME_PROFILE_PAGE = "e3sui";
    public static final String PROFILE_CLASSNAME = "ProfileContent__switcherNavLink active";
    public static final String WALL_CLASSNAME = "ProfileContent__switcherNavLink";
    public static final String TRAINING_BY_YEAR_CLASSNAME = "InformerQuickView-tabbedView__NavLink";
    public static final String HOME_PAGE_URL = "https://telescope.epam.com/search/people";
    public static final String CSV_PATH = "src/main/resources/user.csv";
    public static final String INVALID_LOGIN = "Vasia_Pupkind@epam.com";
    public static final String INVALID_PASSWORD = "IamVasia666";
    public static final String ALERT_TITLE_OF_FEEDBACK = "Send us a message";
    public static final int FEEDBACK_FRAME_NUMBER = 0;
    public static final int WAITING_TIME = 10;
    public static final int NEXT_WINDOW_NUMBER = 1;
    private Constants() {
    }
}