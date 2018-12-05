package com.hindsightsoftware;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BrowserDemoStepDefs {

    private WebDriver driver;

//    @Before
//    public void getDriverFromBrowserFactory(){
//        driver = new ChromeDriver();
//    }

    @Before("@desktop-view")
    public void createDesktopViewDriver(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.createDriver("chrome", "desktop");
    }

    @Before("@mobile-view")
    public void createMobileViewDriver(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.createDriver("firefox", "desktop");
    }

    @Given("I am on the home page")
    public void navigateToHomePage() {
        driver.navigate().to( "https://www.mwtestconsultancy.co.uk");
    }

    @When("I click on the read more button")
    public void clickReadMore() {
        driver.findElement(By.cssSelector(".read-more")).click();
    }

    @Then("the browser scrolls to the start of the article")
    public void confirmScroll() {
        Boolean dateIsDisplayed = driver.findElement(By.cssSelector("#date")).isDisplayed();

        assertThat(dateIsDisplayed, is(true));
    }

    @After
    public void closeBrowser(){
        driver.close();
    }


}
