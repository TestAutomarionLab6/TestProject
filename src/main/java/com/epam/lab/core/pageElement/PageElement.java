package com.epam.lab.core.pageElement;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;

public class PageElement implements WebElement {

   // final static Logger log = Logger.getLogger(PageElement.class);

    private WebElement webElement;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    @Step("PageElement Step: Click on page element...")
    public void click() {
        webElement.click();
    }

    @Step("PageElement Step: Submit form...")
    public void submit() {
        webElement.submit();
    }

    @Step("PageElement Step: Send keys: {0}...")
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Step("PageElement Step: Clear input field...")
    public void clear() {
        webElement.clear();
    }

    @Step("PageElement Step: Get tag name...")
    public String getTagName() {
        return webElement.getTagName();
    }

    @Step("PageElement Step: Get attribute by name: {0}...")
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Step("PageElement Step: Verifying selecting of element...")
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Step("PageElement Step: Verifying enabling of element...")
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Step("PageElement Step: Get text from element...")
    public String getText() {
        return webElement.getText();
    }

    @Step("PageElement Step: Find elements by: {0}...")
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Step("PageElement Step: Find element by: {0}...")
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Step("PageElement Step: Verifying displaying of element...")
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Step("PageElement Step: Get location of element...")
    public Point getLocation() {
        return webElement.getLocation();
    }

    public Dimension getSize() {
        return webElement.getSize();
    }

    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Step("PageElement Step: Get css value of element: {0}...")
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void tagShouldBeEqualTo(String tag) {
        if (!getText().contains(tag)) {
          //  log.error("Not all results have tag " + tag);
        }
    }
}

