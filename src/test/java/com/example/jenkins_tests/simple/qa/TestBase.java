package com.example.jenkins_tests.simple.qa;

import com.codeborne.selenide.Configuration;
import helper.attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

    protected static WebDriver driver;

    @BeforeAll
    static void configure() {
        // Set up SafariDriver
        driver = new SafariDriver();

        // Configure Selenide to use the SafariDriver
        Configuration.browser = "safari";
        Configuration.driverManagerEnabled = false;  // Disable WebDriverManager auto setup

        // Open the desired URL
        driver.get("https://demoqa.com");

        // Maximize the browser window
        driver.manage().window().maximize();
    }
    @AfterEach
     void addAttachments() {
        attach.screenshotAs("Last screenshot");
        attach.pageSource();
        attach.browserConsoleLogs();
    }
}

