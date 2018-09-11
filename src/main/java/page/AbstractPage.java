package page;

import core.decorator.CustomFieldDecorator;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public abstract class AbstractPage {
    private WebDriver driver;

    public AbstractPage() {
        driver = DriverManager.getDriver();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    public void waitElement(WebElement webElement) {
        Wait wait = new FluentWait(driver).withTimeout(ofSeconds(20)).pollingEvery(ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
