package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.scooter.page.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class testMainPage {

    private WebDriver driver;
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";
    private String question1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String question2 =
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String question3 =
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String question4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String question5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String question6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String question7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String question8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/60116013/WebDriver/bin/chromedriver.exe");
    }

    @Test
    public void testOneQuestion() {
        //Сколько это стоит? И как оплатить?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();

        //Получаем текс ответа на первый вопрос
        //Сколько это стоит? И как оплатить?
        String responseOne = mainPage.getTextResponseCost(0);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question1, responseOne);
    }

    @Test
    public void testTwoQuestion() {
        //Хочу сразу несколько самокатов! Так можно?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на второй вопрос
        //Хочу сразу несколько самокатов! Так можно?
        String response = mainPage.getTextResponseCost(1);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question2, response);
    }

    @Test
    public void testThreeQuestion() {
        //Как рассчитывается время аренды?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на третий вопрос
        //Как рассчитывается время аренды?
        String response = mainPage.getTextResponseCost(2);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question3, response);
    }

    @Test
    public void testFourQuestion() {
        //Можно ли заказать самокат прямо на сегодня?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на четвертый вопрос
        //Можно ли заказать самокат прямо на сегодня?
        String response = mainPage.getTextResponseCost(3);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question4, response);
    }

    @Test
    public void testFiveQuestion() {
        //Можно ли продлить заказ или вернуть самокат раньше?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на пятый вопрос
        //Можно ли продлить заказ или вернуть самокат раньше?
        String response = mainPage.getTextResponseCost(4);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question5, response);
    }

    @Test
    public void testSixQuestion() {
        //Вы привозите зарядку вместе с самокатом?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на шестой вопрос
        //Вы привозите зарядку вместе с самокатом?
        String response = mainPage.getTextResponseCost(5);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question6, response);
    }

    @Test
    public void testSevenQuestion() {
        //Можно ли отменить заказ?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на седьмой вопрос
        //Можно ли отменить заказ?
        String response = mainPage.getTextResponseCost(6);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question7, response);
    }

    @Test
    public void testEightQuestion() {
        //Я живу за МКАДом, привезёте?

        driver = new ChromeDriver();
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        //Ожидаем загрузки главной страницы
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
        //Скролл до панели с вопросами
        WebElement element = driver.findElement(By.cssSelector(".accordion__panel"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Нажатие кнопки принятия Cookie
        mainPage.toAcceptCookie();
        //Получаем текс ответа на восьмой вопрос
        //Я живу за МКАДом, привезёте?
        String response = mainPage.getTextResponseCost(7);
        //Проверяем сто текст ответа соответствует ожидаемому результату
        assertEquals(question8, response);
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
