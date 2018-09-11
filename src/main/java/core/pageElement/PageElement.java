package core.pageElement;

import core.util.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;

public class PageElement implements WebElement {

    private final static Logger LOG = MyLogger.getLogger();

    private WebElement webElement;
    private String name;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void click() {
        webElement.click();
        LOG.info("Click on [" + name + "]");
    }


    public void submit() {
        webElement.submit();
        LOG.info("Click on [" + name + "]");
    }

    public void sendKeys(CharSequence... keysToSend) {
        LOG.info("Sending keys to [" + name + "] value [" + Arrays.toString(keysToSend) + "]");
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        LOG.info("Clear [" + name + "]");
        webElement.clear();
    }

    public String getTagName() {
        LOG.info("Getting name of tag [" + name + "]");
        return webElement.getTagName();
    }

    public String getAttribute(String name) {
        LOG.info("Getting attribute [" + name + "]");
        return webElement.getAttribute(name);
    }

    public boolean isSelected() {
        LOG.info("Checking if element is selected [" + name + "]");
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        LOG.info("Checking if element is enabled [" + name + "]");
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        LOG.info("Finding elements [" + name + "]");
        return webElement.findElements(by);
    }

    public WebElement findElement(By by) {
        LOG.info("Finding element [" + name + "]");
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        LOG.info("Checking if element is displayed [" + name + "]");
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        LOG.info("Getting element location [" + name + "]");
        return webElement.getLocation();
    }

    public Dimension getSize() {
        LOG.info("Getting size of element [" + name + "]");
        return webElement.getSize();
    }

    public Rectangle getRect() {
        LOG.info("Getting rect of element [" + name + "]");
        return webElement.getRect();
    }

    public String getCssValue(String propertyName) {
        LOG.info("Getting css value [" + name + "]");
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

