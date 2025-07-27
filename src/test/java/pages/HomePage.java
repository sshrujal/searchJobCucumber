package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
    	 this.driver = driver;
    	 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

   	public void clickCareersLink(String linkText) {
   		WebElement careersLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        careersLink.click();
	}
}
