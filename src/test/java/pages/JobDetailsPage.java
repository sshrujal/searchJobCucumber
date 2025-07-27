package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class JobDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getJobTitle() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).getText();
    }

    public String getLocation() {
    	return driver.findElement(By.cssSelector(".job-location")).getText();
    }

    public String getJobId() {
        return driver.findElement(By.cssSelector(".jobId")).getText();
    }

    public String getIntroParagraph() {
        return driver.findElement(By.cssSelector(".jd-info p")).getText();
    }

    public String getManagementBullet(){
    	return driver.findElements(By.xpath("//div[@class='jd-info au-target']/div/ul/li")).get(1).getText();
    }

    public String getRequirement() {
    	return driver.findElement(By.xpath("//div[@class='jd-info au-target']/div/ul/following-sibling::ul/li[contains(text(),'multi-year')]")).getText();
    }

    public String getEducationBullets() {
        return driver.findElement(By.xpath("//div[@class='jd-info au-target']/div/ul/following-sibling::ul/li[contains(text(),'Scrum Master Certification')]")).getText();
    }

   	public WebElement getApplyNowElement(String buttonText) {
		 WebElement applyNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Sub-Actions']/a")));	      
	     return applyNow;
	}
}