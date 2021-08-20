package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class EventsPage extends BasePage {

    final ElementsCollection eventsList = $x("//div[@class='evnt-cards-container']").$$x(".//div[@class='evnt-card-wrapper']");
    final SelenideElement eventsCount = $x("//span[contains(text(),'Upcoming events')]/following-sibling::span[2]");

    public EventsPage(){
        super();
    }

    @Step("Получение списка предстоящих метроприятий")
    public ElementsCollection getEventsList() {
        logger.info("Найдено карточек мероприятий: {}", eventsList.size());
        return eventsList;
    }

    @Step("Получение колличества мероприятий")
    public Integer getEventsCount() {
        int i = Integer.parseInt(eventsCount.getText());
        takeScreenshotForAllure("Страница мероприятий");
        logger.info("Получен cчётчик мероприятий: {}", i);
        return i;
    }

    @Step("Проверка отображения колличества мероприятий")
    public void isEventsCountCorrect() {
        getEventsList()
                .shouldHaveSize(
                        getEventsCount());
    }






}
