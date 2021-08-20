package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());  //универсальный предок всех логеров

    private SelenideElement header = $x("//div[@class='evnt-platform-header']"); //главная панель
    private By events = By.xpath(".//a[contains(text(), 'Events')]");
    private By calendar = By.xpath(".//a[contains(text(), 'Calendar')]");
    private By video = By.xpath(".//a[contains(text(), 'Video')]");
    private By logo = By.xpath(".//a[@class='evnt-brand-logo']");
    private By login = By.xpath(".//a[contains(text(), 'Login')]");


    @Step("Открытие страницы мероприятий")
    public EventsPage getEventsPage() {
        this.header.$(events).click();
        logger.info("Страница мероприятий открыта");
        return new EventsPage();
    }


    @Step("Сохранение скриншота")
    public void takeScreenshotForAllure(String description) {
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }







}
