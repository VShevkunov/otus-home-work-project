package project;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.pagewidgets.EventsPage;
import project.pagewidgets.MainPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EpamTest extends BaseHook {


    @BeforeEach
    public void setUp() {
        //open("/");
    }

    @Test
    public void featureEventsTest() {

        new MainPage()
                .getEventsPage()
                .getEventsList()
                .shouldHaveSize(Integer.parseInt(EventsPage.getEventsCount().getText()));

    }
}
