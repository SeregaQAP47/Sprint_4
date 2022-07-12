package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка принятия Cookie
    private By cookieButton = By.id("rcc-confirm-button");
    //Локатор для множественного поиска вопросов  на главной странице
    private By questionCost = By.cssSelector(".accordion__item");
    //Локатор для множественного поиска ответов на главной странице
    private By responseCost = By.cssSelector(".accordion__panel");

    //Нжатие кнопки принятия Cookie
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
