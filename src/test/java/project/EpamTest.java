package project;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.pagewidgets.MainPage;


@Epic("Тесты проектной работы OTUS")
@Feature("Тестирование сайта EPAM")
public class EpamTest extends BaseHook {

    @BeforeEach
    public void setUp() {

    }

    //@Story("Просмотр предстоящих мероприятий")
    @Description("Сравнение колличества карточек и счётчика мероприятий")
    @DisplayName("Просмотр предстоящих мероприятий")
    @Test
    public void futureEventsTest() {

        new MainPage()
                .getEventsPage()
                .checkVisabilityOfEventsCards()
                .isEventsNumberEqualsCounter();

    }

//    @Description("Проверка информации на карточках прошедших мероприятий мероприятий")
//    @DisplayName("Просмотр карточек мероприятий")
//    @Test
//    public void eventsCardsTest() {
//
//        new MainPage()
//                .getEventsPage()
//                .getPastEvents();
//
//    }


}
