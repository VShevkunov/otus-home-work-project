package project;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.pagewidgets.EventTimeType;
import project.pagewidgets.MainPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


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
                .validateAllUpcomingEventsDates();

    }

    @Description("Просмотр прошедших мероприятий в Канаде")
    @DisplayName("Просмотр прошедших мероприятий в Канаде")
    @Test
    public void pastEventsInCanadaCheck() {



    }





}
