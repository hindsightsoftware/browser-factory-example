package com.hindsightsoftware;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class BrowserFactory {

    // We want to create a list of browser sizes that can be controlled from a
    // single location
    private HashMap<String, Dimension> browserSize = new HashMap<String, Dimension>();

    // When the object is created, we set our custom browser sizes here
    public BrowserFactory() {
        browserSize.put("desktop", new Dimension(1024, 768));
        browserSize.put("mobile", new Dimension(400, 530));
    }

    // Create driver can then be called with a browser type and size. Depending on the browser,
    // parameter we choose a private method to create our browser
    public WebDriver createDriver(String browser, String size){
        if(browser.equals("chrome")){
            return prepareChromeDriver(size);
        } else if (browser.equals("firefox")){
            return prepareFirefoxDriver(size);
        } else {
            return prepareChromeDriver(size);
        }
    }

    // This method will create us an instance of Chrome to use and set it's view size based on the
    // size parameter
    private WebDriver prepareChromeDriver(String size){
        // To run this, download and store the ChromeDriver executable on your path
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(browserSize.get(size));

        return chromeDriver;
    }

    // This method will create us an instance of Firefox to use and set it's view size based on the
    // size parameter
    private WebDriver prepareFirefoxDriver(String size){
        // To run this, download and store the GeckoDriver executable on your path
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().setSize(browserSize.get(size));

        return new FirefoxDriver();
    }

}
