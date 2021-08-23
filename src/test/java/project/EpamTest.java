package project;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.pagewidgets.EventTimeType;
import project.pagewidgets.MainPage;


@Epic("Тесты проектной работы OTUS")
@Feature("Тестирование сайта EPAM")
public class EpamTest extends BaseHook {

    @BeforeEach
    public void setUp() {}

    @Description("Сравнение колличества карточек и счётчика мероприятий")
    @DisplayName("Просмотр предстоящих мероприятий")
    @Test
    public void futureEventsCheck() {

        new MainPage()
                .getEventsPage()
                .checkVisabilityOfEventsCards()
                .isEventsNumberEqualsCounter();

    }

    @Description("Проверка информации на карточках прошедших мероприятий мероприятий")
    @DisplayName("Просмотр карточек мероприятий")
    @Test
    public void eventsCardsInfoCheck() {

        new MainPage()
                .getEventsPage()
                .getPastEvents()
                .checkVisabilityOfEventsCards()
                .checkEventCardInfo();

    }

    @Description("Проверка валидности дат предстоящих мероприятий")
    @DisplayName("Валидация дат предстоящих мероприятий")
    @Test
    public void upcomingEventsDateValidation() {

        new MainPage()
                .getEventsPage()
                .getUpcomingEvents()
                .checkVisabilityOfEventsCards()
                .validateAllEventsDates(EventTimeType.FUTURE);

    }

    @Description("Просмотр прошедших мероприятий в Канаде")
    @DisplayName("Просмотр прошедших мероприятий в Канаде")
    @Test
    public void pastEventsInCanadaCheck() {

        new MainPage()
                .getEventsPage()
                .getPastEvents()
                .filterEventLocation("Canada")
                .checkVisabilityOfEventsCards()
                .isEventsNumberEqualsCounter()
                .validateAllEventsDates(EventTimeType.PAST);

    }

    @Description("Фильтрация докладов по категориям")
    @DisplayName("Фильтрация докладов по категориям")
    @Test
    public void filteringLecturesByCategory() {

        new MainPage()
                .getVideoPage()
                .getMoreFilters()
                .filterBy("Category", "Testing")
                .filterBy("Location", "Belarus")
                .filterBy("Language", "ENGLISH")
                .cardsClickedValidation("Testing", "Belarus", "ENGLISH");

    }

    @Description("Поиск докладов по ключевому слову")
    @DisplayName("Поиск докладов по ключевому слову")
    @Test
    public void searchingLecturesByKeyWord() throws InterruptedException {

        new MainPage()
                .getVideoPage()
                .search("QA")
                .cardsNonClickedValidation("QA");

    }











}
