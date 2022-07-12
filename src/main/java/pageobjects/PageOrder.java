package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageOrder {

    private WebDriver driver;

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Заказать" вверху
    private By buttonOrderUp = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    //кнопка "Заказать" внизу страницы
    private By buttonOrderDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Форма заполнения для заказа
    //Всплывающее окно формы для оформления заказа заголовок "Для кого самокат"
    private By headerOrder = By.cssSelector(".Order_Header__BZXOb");
    //поле формы заказа "Имя"
    private By name = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Имя\"]");
    //поле формы заказа "Фамилия"
    private By lastName = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Фамилия\"]");
    //поле формы заказа "Адрес.Куда привезти заказ"
    private By address = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Адрес: куда привезти заказ\"]");
    //поле формы заказа "Телефон"
    private By phone = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Телефон: на него позвонит курьер\"]");
    //поле формы заказа "Станция метро"
    private By metro = By.cssSelector("input.select-search__input");
    //Кнопка "Далее"
    private By further = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Список станций
    private By listStation = By.cssSelector(".select-search__select .select-search__options");
    //Станция
    private By Station = By.cssSelector("ul li button.Order_SelectOption__82bhS.select-search__option[value=\"2\"]");
    //Куда привезти самокат?
    private By when = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");
    //Срок аренды
    //поле
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //Срок
    private By twoDay = By.xpath("//div[@role=\"option\" and text()=\"двое суток\"]");
    //Цвет самоката(черный)
    private By colorBlack = By.id("black");
    //Кнопка заказать во второй форме для заполнения
    private By orderButtonTwoForm = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Заказать\"]");
    //Кнопка "Да", подтверждение оформления заказа
    private By buttonYes = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" and text()=\"Да\"]");
    //Сообщение заказ оформлен
    private By orderOk = By.className("Order_ModalHeader__3FDaJ");

    //Нажать кнопку заказать на главной странице
    public void clickButtonOrder() {
        driver.findElement(buttonOrderUp).click();
    }
    //метод заполняет поля ввода Имя
    public void setName(String username) {
        driver.findElement(name).sendKeys(username);
    }
    //метод заполняет поля ввода Фамилия
    public void setLastName(String userLastName) {
        driver.findElement(lastName).sendKeys(userLastName);
    }
    //метод заполняет поля ввода Адрес
    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }
    //метод заполняет поля ввода Телефон
    public void setPhone(String userPhone) {
        driver.findElement(phone).sendKeys(userPhone);
    }
    //метод выбирает станцию метро
    public void setMetro() {
        WebElement element = driver.findElement(metro);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(listStation));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Station));
        driver.findElement(Station).click();
    }
    //нажатие кнопки далее
    public void clickFurther() {
        driver.findElement(further).click();
    }
    //Когда привезти
    public void setWhen(String date) {
        driver.findElement(when).sendKeys(date + Keys.ENTER);
    }
    //Выбор срока аренды
    public void selectRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(twoDay));
        driver.findElement(twoDay).click();
    }
    public void selectBlackColor() {
        driver.findElement(colorBlack).click();
    }
    public void clickOrderButtonTwoForm() {
        driver.findElement(orderButtonTwoForm).click();
    }
    public void clickButtonYes() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        driver.findElement(buttonYes).click();
    }
    public String orderGetText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderOk));
        String status = driver.findElement(orderOk).getText();
        return status;
    }
}

