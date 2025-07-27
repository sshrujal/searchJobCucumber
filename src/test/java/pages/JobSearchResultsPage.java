package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class JobSearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public JobSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectJob(String jobTitle) {
		WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(jobTitle)));
        jobLink.click();
	}
}
