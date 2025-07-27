package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchJob(String jobTitle) {
    	 WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("typehead"))); 
	     searchBox.sendKeys(jobTitle);
	     searchBox.sendKeys(Keys.ENTER);
    }
}