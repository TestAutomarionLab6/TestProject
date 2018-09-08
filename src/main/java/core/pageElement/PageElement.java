package core.pageElement;

import org.openqa.selenium.*;

import java.util.List;

public class PageElement implements WebElement {

   // final static Logger log = Logger.getLogger(PageElement.class);

    private WebElement webElement;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }


    public void click() {
        webElement.click();
    }


    public void submit() {
        webElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

    public String getTagName() {
        return webElement.getTagName();
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        return webElement.getLocation();
    }

    public Dimension getSize() {
        return webElement.getSize();
    }

    public Rectangle getRect() {
        return webElement.getRect();
    }

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

