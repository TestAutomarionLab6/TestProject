package com.epam.lab.core.util;

import com.opencsv.bean.CsvBindByName;

public class UserData {

    @CsvBindByName
    private String phone;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String skype;
    @CsvBindByName
    private String email2;
    @CsvBindByName
    private String firstAndLastName;
    @CsvBindByName
    private String jobTitle;
    @CsvBindByName
    private String jobLocation;
    @CsvBindByName
    private String productionCategory;
    @CsvBindByName
    private String jobFunction;
    @CsvBindByName
    private String primarySkill;
    @CsvBindByName
    private String nativeName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSkypeForBusiness() {
        return email2;
    }

    public void setSkypeForBusiness(String email2) {
        this.email2 = email2;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getProductionCategory() {
        return productionCategory;
    }

    public void setProductionCategory(String productionCategory) {
        this.productionCategory = productionCategory;
    }

    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
}
