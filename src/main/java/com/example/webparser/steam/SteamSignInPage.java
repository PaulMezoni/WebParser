package com.example.webparser.steam;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Data
@Component
public class SteamSignInPage  {
    @Value("${steamLogin}")
    private static String steamLogin;
    @Value("${steamPassword}")
    private static String steamPassword;
    @Value("${steamLoginFieldXpath}")
    private static String steamLoginFieldXpath;
    @Value("${steamPasswordFieldXpath}")
    private static String steamPasswordFieldXpath;
    @Value("${signInXpath}")
    private static String signInXpath;





    public static void signIn(WebDriver webDriver) {
        WebElement loginField = webDriver.findElement(By.xpath(steamLoginFieldXpath));
        WebElement passwordField = webDriver.findElement(By.xpath(steamPasswordFieldXpath));
        loginField.sendKeys(steamLogin);
        passwordField.sendKeys(steamPassword);
        webDriver.findElement(By.xpath(signInXpath)).click();//клик подтверждает ввод кредов
        WebElement verificationField = webDriver.findElement(By.xpath("//*[@id=\"twofactorcode_entry\"]"));
        Scanner scanner = new Scanner(System.in);
        String verificationCode = scanner.nextLine();
        verificationField.sendKeys(verificationCode, Keys.ENTER);
    }
}
