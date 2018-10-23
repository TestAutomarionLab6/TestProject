package com.epam.lab.business;

import com.epam.lab.core.driver.DriverManager;
import com.epam.lab.core.util.MyLogger;
import com.epam.lab.page.PersonalPagePo;
import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.testng.asserts.SoftAssert;

import static com.epam.lab.core.util.Constants.*;

public class PersonalPageBo {

    private PersonalPagePo personalPagePo;
    private MyLogger myLogger;
    private SoftAssert softAssertion;
    private int initialNumberRows;
    private int newInitialNumberRows;

    public PersonalPageBo() {
        personalPagePo = new PersonalPagePo();
        DriverManager.getDriver().get(PERSONAL_PAGE_URL);
        myLogger = new MyLogger();
        myLogger.setLevel(Level.INFO);
        softAssertion = new SoftAssert();
    }

    @Step("PageElementBO Step: Verify the functionality of Personal card by general info....")
    public void verifyCardByGeneralInfo() {
        clickOnPersonalData();
        clickOnPersonalCard();
        clickOnSeeMore();
        clickOnGeneralInfo();
        verifyGeneralInfo();
    }

    @Step("PageElementBO Step: Click on 'Personal Data' informer....")
    public void clickOnPersonalData() {
        personalPagePo.getPersonalDataButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'Personal card'...")
    public void clickOnPersonalCard() {
        personalPagePo.getPersonalCard().click();
    }

    @Step("PageElementBO Step: Click on 'See More' button...")
    public void clickOnSeeMore() {
        personalPagePo.getSeeMoreButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Click on 'General Info' button...")
    public void clickOnGeneralInfo() {
        personalPagePo.getGeneralInfoButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Verify if 'footer' label shows same text...")
    public void verifyGeneralInfo() {
        String footerLabelText = personalPagePo.getFooterLabel().getText();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertNotEquals(footerLabelText, PERSONAL_DATA_FOOTER, "The information is not displayed");
        MyLogger.getLogger().info(footerLabelText.equals(PERSONAL_DATA_FOOTER) ?
                "The information is not displayed on page" : "All personal information has been successfully loaded");
        softAssertion.assertAll();
    }

    @Step("PageElementBO Step: Verify the functionality of Personal card by valid emergency contacts....")
    public void verifyCardByValidEmergencyContacts() {
        clickOnEmergencyContacts();
        verifyEmergencyContacts();
        initialNumberRows = calcInitialNumberRows();
        inputFirstName(VALID_NAME_EMERGENCY_CONTACT);
        inputRelationship(VALID_RELATIONSHIP_EMERGENCY_CONTACT);
        inputPhone(VALID_PHOME_EMERGENCY_CONTACT);
        clickOnAdd();
        newInitialNumberRows = calcInitialNumberRows();
        verifyContactTable();
        verifyDeletingEmergencyContacts();
    }

    @Step("PageElementBO Step: Verify the functionality of Personal card by invalid emergency contacts....")
    public void verifyCardByInvalidEmergencyContacts() {
        clickOnEmergencyContacts();
        verifyEmergencyContacts();
        initialNumberRows = calcInitialNumberRows();
        inputFirstName(INVALID_NAME_EMERGENCY_CONTACT);
        inputRelationship(INVALID_RELATIONSHIP_EMERGENCY_CONTACT);
        inputPhone(INVALID_PHOME_EMERGENCY_CONTACT);
        clickOnAdd();
        newInitialNumberRows = calcInitialNumberRows();
        verifyContactTable();
        verifyDeletingEmergencyContacts();
    }

    @Step("PageElementBO Step: Click on 'Emergency Contacts' button...")
    public void clickOnEmergencyContacts() {
        personalPagePo.getEmergencyContactsButton().waitUntilVisible().click();
    }

    @Step("PageElementBO Step: Enter first name {0} in Name input field. ...")
    public void inputFirstName(String name) {
        personalPagePo.getNameInput().sendKeys(name);
    }

    @Step("PageElementBO Step: Enter {0} relationship status of person in Relationship input field. ...")
    public void inputRelationship(String relationship) {
        personalPagePo.getDescriptionInput().sendKeys(relationship);
    }

    @Step("PageElementBO Step: Enter {0} phone number including country code in Phone input field. ...")
    public void inputPhone(String phone) {
        personalPagePo.getPhoneInput().sendKeys(phone);
    }

    @Step("PageElementBO Step: Click on add button....")
    public void clickOnAdd() {
        personalPagePo.getAddButton().click();
    }

    @Step("PageElementBO Step: Calculate the initial number of rows in the contact table...")
    public int calcInitialNumberRows() {
        return personalPagePo.getContactTableRow().size();
    }

    @Step("PageElementBO Step: Verify if the data is added to the table...")
    public void verifyContactTable() {
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(newInitialNumberRows, initialNumberRows + ADDITIONAL_NUMBER,
                "The information is not displayed on table");
        MyLogger.getLogger().info((newInitialNumberRows == initialNumberRows + ADDITIONAL_NUMBER) ?
                "All personal information has been successfully loaded on table" : "The information is not displayed on page");
        softAssertion.assertAll();
    }

    @Step("PageElementBO Step: Verify if 'footer' label shows same text on emergency contacts...")
    public void verifyEmergencyContacts() {
        String footerLabelText = personalPagePo.getSecondFooterLabel().getText();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(footerLabelText, PERSONAL_DATA_SECOND_FOOTER, "The information is not displayed");
        MyLogger.getLogger().info(footerLabelText.equals(PERSONAL_DATA_SECOND_FOOTER) ?
                "All personal information has been successfully loaded" : "The information is not displayed on page");
        softAssertion.assertAll();
    }

    @Step("PageElementBO Step: Verify the removal of the emergency contact....")
    public void verifyDeletingEmergencyContacts() {
        initialNumberRows = calcInitialNumberRows();
        clickOnDelete();
        newInitialNumberRows = calcInitialNumberRows();
        verifyTableAfterDeletingData();
    }

    @Step("PageElementBO Step: Click on delete button....")
    public void clickOnDelete() {
        personalPagePo.getDeleteButton().click();
    }

    @Step("PageElementBO Step: Verify if the data is removed to the table...")
    public void verifyTableAfterDeletingData() {
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(newInitialNumberRows, initialNumberRows - ADDITIONAL_NUMBER,
                "The information is not displayed on table");
        MyLogger.getLogger().info((newInitialNumberRows == initialNumberRows - ADDITIONAL_NUMBER) ?
                "All personal information has been successfully deleted from table" : "The information is not displayed on page");
        softAssertion.assertAll();
    }
}
