package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    public Logger logger = LogManager.getLogger(this.getClass());  //универсальный предок всех логеров

    private SelenideElement header = $x("//div[@class='evnt-platform-header']"); //главная панель
    private By events = By.xpath(".//a[contains(text(), 'Events')]");
    private By calendar = By.xpath(".//a[contains(text(), 'Calendar')]");
    private By video = By.xpath(".//a[contains(text(), 'Video')]");
    private By logo = By.xpath(".//a[@class='evnt-brand-logo']");
    private By login = By.xpath(".//a[contains(text(), 'Login')]");

    @Step("Пользователь переходит на вкладку events")
    public EventsPage getEventsPage() {
        this.header.$(events).click();
        waitLoader();
        logger.info("Страница мероприятий открыта");
        return new EventsPage();
    }

    @Step("Пользователь переходит на вкладку VIDEO - TALKS LIBRARY")
    public VideoPage getVideoPage() {
        this.header.$(video).click();
        waitLoader();
        logger.info("Страница VIDEO - TALKS LIBRARY открыта");
        return new VideoPage();
    }

    @Step("Сохранение скриншота")
    public void takeScreenshotForAllure(String description) {
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }

    public void waitLoader() {
        $x("//div[@class='evnt-global-loader']").shouldBe(disappear, Duration.ofSeconds(10));
    }








}
