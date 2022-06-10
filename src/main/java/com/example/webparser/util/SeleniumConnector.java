package com.example.webparser.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class SeleniumConnector {


    public WebDriver connect() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        return new ChromeDriver(options);
    }
}
