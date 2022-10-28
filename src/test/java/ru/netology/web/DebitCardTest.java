package ru.netology.web;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardTest {


    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        WebDriverManager.chromedriver().setup();
    }


//        if (System.getProperty("os.name").contains("Linux")) {
//            System.setProperty("webdriver.chrome.driver", "driver/linux/chromedriver");
//        } else {
//            System.setProperty("webdriver.chrome.driver", "driver/win10/chromedriver.exe");
//        }


    @BeforeEach
    void setUp(){
        driver=new ChromeDriver();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver=null;
    }

    @Test
    void shouldTestPositiveDataForm() throws InterruptedException {
        driver.get("http://localhost:9999/");
        List<WebElement> list = driver.findElements(By.className("input__control"));
        list.get(0).sendKeys("Безменов Никита");
        sleep(800);
        list.get(1).sendKeys("+79145556677");
        sleep(800);

        driver.findElement(By.className("checkbox__box")).click();
        sleep(800);
        driver.findElement(By.className("button__content")).click();
        sleep(800);

        String text = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        sleep(800);
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }



}
