package StepDefinitions;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplyPage;
import pages.CareersPage;
import pages.HelperPage;
import pages.HomePage;
import pages.JobDetailsPage;
import pages.JobSearchResultsPage;

public class LabCorpJobSearch {
	
	 WebDriver driver= Hooks.driver;
	 WebDriverWait wait;
	 String jobTitleOnFirstPage="";
	 
	 public LabCorpJobSearch() {}
	 
	 HomePage homePage = new HomePage(driver);
	 CareersPage careerPage = new CareersPage(driver);
	 JobSearchResultsPage jobSearchPage = new JobSearchResultsPage(driver);
	 JobDetailsPage jobDetailPage = new JobDetailsPage(driver);
	 HelperPage helperPage= new HelperPage(driver);
	 ApplyPage applyPage = new ApplyPage(driver);
	 
		@Given("I open the browser and navigate to {string}")
		public void openBrowser(String url) {
			homePage.open(url);
		}

		@When("I click on the {string} link")
		public void clickLink(String linkText) {
			homePage.clickCareersLink(linkText);
		}

		@And("I search for job title {string}")
		public void searchJob(String jobTitle) {
			careerPage.searchJob(jobTitle);
		}

		@And("I select the job titled {string}")
		public void selectJob(String jobTitle) {
			jobSearchPage.selectJob(jobTitle);
		}

		@Then("I should see the Job Title as {string}")
		public void validateJobTitle(String expectedTitle) {
			jobTitleOnFirstPage = jobDetailPage.getJobTitle().trim();
			assertEquals(expectedTitle, jobTitleOnFirstPage);
		}

		@And("I should see the Job Location as {string}")
		public void validateLocation(String expectedLocation) {
			assertTrue(jobDetailPage.getLocation().contains(expectedLocation));
		}

		@And("I should see the Job ID as {string}")
		public void validateJobId(String expectedId) {
			assertTrue(jobDetailPage.getJobId().contains(expectedId));
		}

		@And("I should see the first sentence of the first paragraph in the Description\\/Introduction as {string}")
		public void validateIntroParagraph(String expectedText) {
			assertTrue(jobDetailPage.getIntroParagraph().startsWith(expectedText));
		}

		@And("I should see the second bullet point under Management Support as {string}")
		public void validateBulletPoint(String expectedText) {
			assertEquals(jobDetailPage.getManagementBullet().trim(), expectedText.trim());
		}

		@And("I should see the third requirement as {string}")
		public void validateRequirement(String expectedText) {
			assertEquals(jobDetailPage.getRequirement().trim(), expectedText.trim());
		}

		@And("I should see the first suggested education contains {string}")
		public void validateEducation(String expectedText) {
			assertTrue(jobDetailPage.getEducationBullets().contains(expectedText));
		}

		@When("I click on {string}")
		public void clickOn(String buttonText) {
			WebElement applyNowButton = jobDetailPage.getApplyNowElement(buttonText);
			applyNowButton.click();
			helperPage.switchTab(applyNowButton);
		}

		@Then("I should see the Job Title match with previous page")
		public void validateJobTitlewitPreviousPage() {
			assertEquals(jobTitleOnFirstPage, applyPage.getJobTitle().trim());
		}

		@When("I click to {string}")
		public void clickTo(String expectedLine) {
			applyPage.clickReturnToJobSearch();
		}

		@Then("I should be back on the Job Search Results page")
		public void verifyReturnToSearch() {
			assertTrue(applyPage.isOnSearchPage());
		}
	}
