package com.epam.lab.core.util;

public class Constants {
    public static final String DRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
    public static final String LOGIN_PAGE_URL = "https://telescope.epam.com/";
    public static final String PROFILE_PAGE_URL = "https://telescope.epam.com/who/Yevhen_Hrafov";
    public static final String PERSONAL_PAGE_URL = "https://telescope.epam.com/who/?tab=profile";
    public static final String TRAINING_PAGE_URL = "https://telescope.epam.com/who/?tab=profile";
    public static final String START_CLASSNAME_PROFILE_PAGE = "e3sui";
    public static final String PROFILE_CLASSNAME = "ProfileContent__switcherNavLink active";
    public static final String WALL_CLASSNAME = "ProfileContent__switcherNavLink";
    public static final String TRAINING_BY_YEAR_CLASSNAME = "InformerQuickView-tabbedView__NavLink";
    public static final String TRAINING_BY_TYPE_CLASSNAME = "InformerQuickView-tabbedView__NavLink";
    public static final String ACTIVE_IN_CLASSNAME = "active";
    public static final String HOME_PAGE_URL = "https://telescope.epam.com/search/people";
    public static final String CREDENTIALS_CSV_PATH = "src/main/resources/user.csv";
    public static final String DATA_CSV_PATH = "src/main/resources/userData.csv";
    public static final String INVALID_LOGIN = "Vasia_Pupkind@epam.com";
    public static final String INVALID_PASSWORD = "IamVasia666";
    public static final String FEEDBACK_TITLE = "Send us a message";
    public static final int FEEDBACK_FRAME_NUMBER = 0;
    public static final int WAITING_TIME = 10;
    public static final int NEXT_WINDOW_NUMBER = 1;
    public static final int PREVIOUS_WINDOW_NUMBER = 0;
    public static final String PERSONAL_DATA_FOOTER = "Please visit UPSA if you?d like to update data.";
    public static final String PERSONAL_DATA_SECOND_FOOTER = "Contacts here are vitally important for emergency cases; they are visible only to your RM and HR.";
    public static final String INVALID_NAME_EMERGENCY_CONTACT = "NAME";
    public static final String INVALID_RELATIONSHIP_EMERGENCY_CONTACT = "RELATIONSHIP";
    public static final String INVALID_PHOME_EMERGENCY_CONTACT = "PHONE";
    public static final String VALID_NAME_EMERGENCY_CONTACT = "Slavko";
    public static final String VALID_RELATIONSHIP_EMERGENCY_CONTACT = "kum";
    public static final String VALID_PHOME_EMERGENCY_CONTACT = "+380505050505";
    public static final int ADDITIONAL_NUMBER = 1;

    private Constants() {
    }
}