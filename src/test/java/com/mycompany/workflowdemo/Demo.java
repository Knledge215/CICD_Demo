package com.mycompany.workflowdemo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo

{
	private WebDriver driver;
	 
    @BeforeTest
    public void setup()
    {
       
        
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--headless");               // run without GUI on the target platform
        options.addArguments("--no-sandbox");             // required in Docker/WSL
        options.addArguments("--disable-dev-shm-usage");  // prevent crashes on small /dev/shm        
        
        driver = new ChromeDriver(options);  //create ChromeDriver instance with options
        
        
    }
 
    @Test
    public void openGoogle()
    {
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title should contain Google");
        System.out.println("Today's date is: " + new java.util.Date());
        System.out.println("Felicia Tara Huda Rodney...our team");
        System.out.println("Our New Test Case....");
        System.out.println("Page title: " + driver.getTitle());
        System.out.println(" This test case passed");
        if(driver.getTitle().contains("Google"))
        {
			System.out.println("Test Passed: Title contains Google");
		}
        else
        {
			System.out.println("Test Failed: Title does not contain Google");
		}
    }
 
    @AfterTest
    public void teardown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}
