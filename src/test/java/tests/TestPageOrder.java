package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageOrder;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestPageOrder {

    private static final String URL_MAIN = "https://qa-scooter.praktikum-services.ru/";
    private static final String DRIVER_PATH = "C:/Users/60116013/WebDriver/bin/chromedriver.exe";
    private String message;
    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    @Test
    public void testOrderChrome() {
        driver = new ChromeDriver();
        driver.get(URL_MAIN);
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
        PageOrder pageOrder = new PageOrder(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Нажатие кнопки "Заказать" в верхней части страницы
        pageOrder.clickButtonOrder();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_Header__BZXOb")));
        //Заполнение формы заказа
        //Ввод имени
        pageOrder.setName("Иван");
        //Ввод фамилии
        pageOrder.setLastName("Иванов");
        //Ввод адреса
        pageOrder.setAddress("Москва");
        //Выбор станции метро
        pageOrder.setMetro();
        //Ввод номера телефона
        pageOrder.setPhone("89557001010");
        //Нажатие кнопки "Далее"
        pageOrder.clickFurther();
        //вторая часть формы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_Header__BZXOb")));
        //Когда привезти
        pageOrder.setWhen("10.05.2022");
        //Срок аренды "двое суток"
        pageOrder.selectRentalPeriod();
        //Выбор черного цвета самоката
        pageOrder.selectBlackColor();
        //Нажать кнопку "Заказать"
        pageOrder.clickOrderButtonTwoForm();
        // Нажать кнопку "Да"
        pageOrder.clickButtonYes();
        message = pageOrder.orderGetText();
        assertEquals("Заказ оформлен", message.substring(0, 14));
    }

    @Test
    public void testOrderMozilla() {
        driver = new FirefoxDriver();
        driver.get(URL_MAIN);
        driver.findElement(By.cssSelector(".App_CookieButton__3cvqF")).click();
        PageOrder pageOrder = new PageOrder(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Нажатие кнопки "Заказать" в верхней части страницы
        pageOrder.clickButtonOrder();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_Header__BZXOb")));
        //Заполнение формы заказа
        //Ввод имени
        pageOrder.setName("Семён");
        //Ввод фамилии
        pageOrder.setLastName("Семёнов");
        //Ввод адреса
        pageOrder.setAddress("Москва");
        //Выбор станции метро
        pageOrder.setMetro();
        //Ввод номера телефона
        pageOrder.setPhone("89559201010");
        //Нажатие кнопки "Далее"
        pageOrder.clickFurther();
        //вторая часть формы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_Header__BZXOb")));
        //Когда привезти
        pageOrder.setWhen("02.06.2022");
        //Срок аренды "двое суток"
        pageOrder.selectRentalPeriod();
        //Выбор черного цвета самоката
        pageOrder.selectBlackColor();
        //Нажать кнопку "Заказать"
        pageOrder.clickOrderButtonTwoForm();
        // Нажать кнопку "Да"
        pageOrder.clickButtonYes();
        message = pageOrder.orderGetText();
        assertEquals("Заказ оформлен", message.substring(0, 14));
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
