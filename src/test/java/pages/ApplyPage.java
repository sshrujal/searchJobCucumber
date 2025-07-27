package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ApplyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isJobDescriptionDisplayed()
    {
    	WebElement description = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Sub-Actions']/a")));
    	return description.isDisplayed();
    }
    
    public void clickReturnToJobSearch() {
        WebElement buttonReturnBack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Careers Home')]")));
        buttonReturnBack.click();
    }
    
    public String getJobTitle() {
    	return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='css-18mbozw']"))).getText();
    }

    public boolean isOnSearchPage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("typehead"))).isDisplayed(); 
    }

	
}
