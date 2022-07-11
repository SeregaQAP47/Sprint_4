package ru.yandex.scooter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cookieButton = By.id("rcc-confirm-button");

    //Вопрос 1. Сколько это стоит, и как оплатить?
//    private By questionCost = By.id("accordion__heading-8");
    private By questionCost = By.cssSelector(".accordion__item");
    //Ответ на первый вопрос "Сколько это стоит, и как оплатить?"
//    private By responseCost = By.id("accordion__panel-8");
    private By responseCost = By.cssSelector(".accordion__panel");

    //Вопрос 2. Хочу сразу несколько самокатов! Так можно?
    private By questionSeveralScooters = By.id("accordion__heading-1");
    //Ответ на второй вопрос "Хочу сразу несколько самокатов! Так можно?"
    private By responseSeveralScooters = By.id("accordion__panel-1");

    //Вопрос 3. Как рассчитывается время аренды?
    private By questionRentScooters = By.id("accordion__heading-2");
    //Ответ на третий вопрос "Как рассчитывается время аренды?"
    private By responseRentScooters = By.id("accordion__panel-2");

    //Вопрос 4. Можно ли заказать самокат прямо на сегодня?
    private By questionRentTodayScooters = By.id("accordion__heading-3");
    //Ответ на третий вопрос "Можно ли заказать самокат прямо на сегодня?"
    private By responseRentTodayScooters = By.id("accordion__panel-3");

    //Вопрос 5. Можно ли продлить заказ или вернуть самокат раньше?
    private By questionExtendOrRestore = By.id("accordion__heading-4");
    //Ответ на третий вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private By responseExtendOrRestore = By.id("accordion__panel-4");

    //Вопрос 6. Вы привозите зарядку вместе с самокатом?
    private By questionCharger = By.id("accordion__heading-5");
    //Ответ на третий вопрос "Вы привозите зарядку вместе с самокатом?"
    private By responseCharger = By.id("accordion__panel-5");

    //Вопрос 7. Можно ли отменить заказ?
    private By questionOrderCancellation = By.id("accordion__heading-6");
    //Ответ на третий вопрос "Можно ли отменить заказ?"
    private By responseOrderCancellation = By.id("accordion__panel-6");

    //Вопрос 8. Я живу за МКАДом, привезёте?
    private By questionMKAD = By.id("accordion__heading-7");
    //Ответ на третий вопрос "Я живу за МКАДом, привезёте?"
    private By responseMKAD = By.id("accordion__panel-7");

    public void toAcceptCookie() {
        driver.findElement(cookieButton).click();
    }

    //Метод осуществляет нажатие на вопрос, после чего получает текст ответа
    public String getTextResponseCost(int positionQuestion) {
        driver.findElement(questionCost).click();
        WebElement element = driver.findElements(questionCost).get(positionQuestion);
        element.click();

        WebElement elementResponse = driver.findElements(responseCost).get(positionQuestion);
        String text = elementResponse.getText();
        return text;
    }


}
