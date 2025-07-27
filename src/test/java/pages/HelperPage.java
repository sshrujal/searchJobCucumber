package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperPage {

	private WebDriver driver;
    private WebDriverWait wait;

    public HelperPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	public void switchTab(WebElement applyNowButton) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyNowButton);
        String originalWindow = driver.getWindowHandle();
          	
    	// Wait for the new tab to open
    	new WebDriverWait(driver, Duration.ofSeconds(10))
    	    .until(driver -> driver.getWindowHandles().size() > 1);

    	// Switch to the new tab
    	for (String windowHandle : driver.getWindowHandles()) {
    	    if (!windowHandle.equals(originalWindow)) {
    	        driver.switchTo().window(windowHandle);
    	        break;
    	    }
    	}    
	}
}
