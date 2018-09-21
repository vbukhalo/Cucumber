package com.ust.gluecode;

import static com.ust.gluecode.UltimateQADriverUtility.driver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UltimateQAGlueCode {
	
	@Given("^I am on the landing page$")
	public void i_am_on_the_landing_page() throws Throwable {
		assertEquals("Fake landing page - Ultimate QA", driver.getTitle());
		assertEquals("https://www.ultimateqa.com/fake-landing-page/", driver.getCurrentUrl());
	}

	@When("^I click the logo in the upper right corner$")
	public void i_click_the_logo_in_the_upper_right_corner() throws Throwable {
	    driver.findElement(By.id("logo")).click();
	}

	@Then("^I am redirected to the Ultimate QA home page$")
	public void i_am_redirected_to_the_Ultimate_QA_home_page() throws Throwable {
	    assertEquals("Home - Ultimate QA", driver.getTitle());
	    assertEquals("https://www.ultimateqa.com/", driver.getCurrentUrl());
	}

	@When("^I click the Video tutorials link$")
	public void i_click_the_Video_tutorials_link() throws Throwable {
	    driver.findElement(By.id("menu-item-504")).click();
	}

	@Then("^I am redirected to the cources page$")
	public void i_am_redirected_to_the_cources_page() throws Throwable {
	    assertEquals("Ultimate QA", driver.getTitle());
	    assertEquals("https://courses.ultimateqa.com/", driver.getCurrentUrl());
	}

	@When("^I click the Best Selenium Resouces link$")
	public void i_click_the_Best_Selenium_Resouces_link() throws Throwable {
	    driver.findElement(By.id("menu-item-6838")).click();;
	}

	@Then("^I am redirected to the Selenium resouces page$")
	public void i_am_redirected_to_the_Selenium_resouces_page() throws Throwable {
	    assertEquals("Best Resources to Learn Selenium WebDriver in 2018 - Ultimate QA", driver.getTitle());
	    assertEquals("https://www.ultimateqa.com/best-selenium-webdriver-resources/", driver.getCurrentUrl());
	}
	
	@When("^I click the Automation Exercises Link$")
	public void i_click_the_Automation_Exercises_Link() throws Throwable {
		driver.findElement(By.id("menu-item-587")).click();;
	}

	@Then("^I am redirected to the Automation Exercises page$")
	public void i_am_redirected_to_the_Automation_Exercises_page() throws Throwable {
	    assertEquals("Automation Practice - Ultimate QA", driver.getTitle());
	    assertEquals("https://www.ultimateqa.com/automation/", driver.getCurrentUrl());
	}

	@When("^I click the Blog link$")
	public void i_click_the_Blog_link() throws Throwable {
	    driver.findElement(By.id("menu-item-477")).click();
	}

	@Then("^I am redirected to the Blog page$")
	public void i_am_redirected_to_the_Blog_page() throws Throwable {
	    assertEquals("Blog - Ultimate QA", driver.getTitle());
	    assertEquals("https://www.ultimateqa.com/blog/", driver.getCurrentUrl());
	}

	@When("^I click the Work with Us link$")
	public void i_click_the_Work_with_Us_link() throws Throwable {
		driver.findElement(By.id("menu-item-4768")).click();
	}

	@Then("^I am redirected to the Work with Us page$")
	public void i_am_redirected_to_the_Work_with_Us_page() throws Throwable {
		assertEquals("Work with us - Ultimate QA", driver.getTitle());
		assertEquals("https://www.ultimateqa.com/work-with-us/", driver.getCurrentUrl());
	}
	
	@When("^I enter my first name and email$")
	public void i_enter_my_first_name_and_email() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ck_firstNameField")));
		name.sendKeys("bob");
	    driver.findElement(By.id("ck_emailField")).sendKeys("bob@bob.com");
	}

	@When("^Click submit$")
	public void click_submit() throws Throwable {
	    driver.findElement(By.className("tve-froala")).click();
	    Thread.sleep(5000);
	}

	@Then("^I am redirected to the sign up confirmation page$")
	public void i_am_redirected_to_the_sign_up_confirmation_page() throws Throwable {
	    assertEquals("Sign Up Confirmation", driver.getTitle());
	}
	

}
