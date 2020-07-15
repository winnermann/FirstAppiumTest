package org.example.appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
/*    WebDriver driver;*/
    static AppiumDriver<MobileElement> driver;
/*    AndroidDriver driver;*/
    public static void main(String[] args) {
        try {
            openCalculator();
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public static void openCalculator() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //взято из настроек телефона: Настройки -> О телефоне -> Модель устройства
//        capabilities.setCapability("deviceName", "Redmi 6");
//        capabilities.setCapability("deviceName", "AOSP on IA Emulator");
        capabilities.setCapability("deviceName", "Y6_Piano");
        //набрать в командной строке adb devices и появится e00590b97d28
//        capabilities.setCapability("udid", "e00590b97d28"); //Redmi 6
//        capabilities.setCapability("udid", "emulator-5554"); //AOSP on IA Emulator
        capabilities.setCapability("udid", "0123456789ABCDEF"); //Y6_Piano
        capabilities.setCapability("platformName", "Android");
        //взято из настроек телефона: Настройки -> О телефоне -> Версия Android
//        capabilities.setCapability("platformVersion", "9 PPR1.180610.011"); //Redmi 6
//        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformVersion", "6.0"); //Y6_Piano

        //Установить на телефон Apk info
        //Apk info -> Calculator -> Package
//        capabilities.setCapability("appPackage", "com.miui.calculator"); //Redmi 6
        capabilities.setCapability("appPackage", "com.google.android.calculator"); //Y6_Piano
        //Apk info -> Calculator -> Activities
//        capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorTabActivity"); //Redmi 6
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); //Y6_Piano

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, capabilities);

        System.out.println("Application Started.....");

//        MobileElement da = driver.findElement(By.id("android:id/button1"));
//        da.click();

//        MobileElement one = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
//        one.click();

        MobileElement oneY6_Piano = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        oneY6_Piano.click();

//        MobileElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
//        plus.click();

        MobileElement plusY6_Piano = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        plusY6_Piano.click();

//        MobileElement two = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
//        two.click();

        MobileElement twoY6_Piano = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        twoY6_Piano.click();

//        MobileElement ravno = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
//        ravno.click();

        MobileElement ravnoY6_Piano = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        ravnoY6_Piano.click();

        MobileElement resultY6_Piano = driver.findElement(By.className("android.widget.TextView"));
        resultY6_Piano.click();

        String res = resultY6_Piano.getText();
        System.out.println("\n Result is: " + res);

        System.out.println("Completed.....");

    }
}
