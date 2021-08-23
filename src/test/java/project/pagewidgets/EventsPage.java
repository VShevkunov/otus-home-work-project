package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EventsPage extends BasePage {

    SelenideElement currentEventsCategory = $x("//a[@class='evnt-tab-link nav-link active']");

    ElementsCollection eventsList = $x("//div[@class='evnt-cards-container']").$$x(".//div[@class='evnt-card-wrapper']");
    By eventDate = By.xpath(".//div[@class='evnt-dates-cell dates']//span");
    By eventName = By.xpath(".//div[@class='evnt-event-name']//span");

    SelenideElement filtersHeading = $x("//div[@class='evnt-filters-heading']");
    By filterByLocation = By.xpath(".//span[contains(text(), 'Location')]");

    SelenideElement eventCardLoader = $x("//div[@class='evnt-loader']");


    public EventsPage(){
        super();
    }

    @Step("На странице отображаются карточки мероприятий")
    public EventsPage checkVisabilityOfEventsCards() {
        eventsList.first().shouldBe(visible);
        logger.info("Отбразились карточки мероприятий");
        takeScreenshotForAllure("Карточки мероприятий");
        return this;
    }

    @Step("Количество карточек равно счетчику на кнопке Events")
    public EventsPage isEventsNumberEqualsCounter() {
        eventsList
                .shouldHave(size(
                        Integer.parseInt(currentEventsCategory.$x(".//span[3]").getText())));
        logger.info("Всего {} карточек", eventsList.size());
        Allure.addAttachment("Всего карточек", ""+eventsList.size());
        return this;
    }

    @Step("Пользователь нажимает на Past Events")
    public EventsPage getPastEvents() {
        $x("//span[contains(text(), 'Past Events')]").click();
        waitLoader();
        logger.info("Открыта страница прошедших мероприятий");
        return this;
    }

    @Step("Пользователь нажимает на Upcoming Events")
    public EventsPage getUpcomingEvents() {
        $x("//span[contains(text(), 'Upcoming events')]").click();
        waitLoader();
        logger.info("Открыта страница грядущих мероприятий");
        return this;
    }

    @Step("На карточке указана необходимая информация о мероприятии")
    public EventsPage checkEventCardInfo(){
        String notEmptyRegEx = "^(?!\\s*$).+";

        for (SelenideElement event : eventsList) {

            event.$x(".//p[@class='language']")
                    .shouldBe(visible).$x("./span")
                    .should(matchText(notEmptyRegEx));
            logger.info("Присутствует язык");

            event.$(eventName)
                    .should(matchText(notEmptyRegEx));
            logger.info("Присутствует название");

            event.$(eventDate)
                    .should(matchText(notEmptyRegEx));
            logger.info("Присутствует дата");

            event.$x(".//div[@class='evnt-dates-cell dates']")
                    .shouldBe(visible).$x(".//span/following-sibling::span")
                    .should(matchText("Registration"));
            logger.info("Присутствует информация о регистрации");

            event.$x(".//div[@class='speakers-wrapper']")
                    .shouldBe(visible).$$x("./div")
                    .shouldHave(sizeGreaterThan(0));
            logger.info("Присутствуют спикеры");
        }
        return this;
    }

    @Step("Даты мероприятий в рамках категорий валидны относительно текущей даты")
    public EventsPage validateAllEventsDates(EventTimeType eventTimeType) {
        for (SelenideElement event : eventsList){
            eventDateValidation(event.$(eventDate).getText(), eventTimeType);
            logger.info("Мероприятие " + event.$(eventName).getText() + " имеет вадидную дату");
        }
        return this;
    }

    @Step("Пользователь нажимает на Location в блоке фильтров и выбирает Canada в выпадающем списке")
    public EventsPage filterEventLocation(String location) {

        filtersHeading.$(filterByLocation).click();
        filtersHeading.$x(".//label[@data-value='" + location + "']").click();
        waitLoader();
        logger.info("Выбрано {} в фильтре Locations", location);

        return this;
    }





    public void eventDateValidation(String date, EventTimeType switcher) {

        String d = date.trim(); //лишние пробелы за ошибку не считаем
        Locale US = new Locale("us", "US"); //US Locale на сайте
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", US); //паттерн даты на сайте
        formatter.setLenient(false); //не пропускать невалидные даты

        Date currentDate = null;     //текущая дата без времени 00:00:00 MSK
        Date beginDate = null;      //дата начала (если есть)
        Date lastDate = null;      //дата окончания  и основная дата, если мероприятие многодневное

        List<String> dates = Arrays.asList(d.split(" - "));

        try {
            currentDate = formatter.parse(formatter.format(new Date()));
            lastDate = formatter.parse(dates.get(dates.size()-1));
            if (dates.size()>1) {
                beginDate =
                        dates.get(0).length()<=2 ?
                                formatter.parse(dates.get(0) + " " + new SimpleDateFormat("MMM", US).format(lastDate) + " " + new SimpleDateFormat("yyyy", US).format(lastDate)) :
                                formatter.parse(dates.get(0) + " " + new SimpleDateFormat("yyyy", US).format(lastDate));
                Assertions.assertTrue(
                        beginDate.before(lastDate), "Ошибка в диапазоне дат мероприятия"
                );
            }

        }catch (ParseException e){
            Assertions.fail("Невалидная дата " + e.getLocalizedMessage());
        }

        switch (switcher){
            case FUTURE:  Assertions.assertTrue(
                    currentDate.before(lastDate) || currentDate.equals(lastDate), "Диапазон дат мероприятия в прошлом");
            break;
            case PAST:  Assertions.assertTrue(
                    currentDate.after(lastDate), "Диапазон дат мероприятия не в прошлом");
            break;
        }

    }







}
