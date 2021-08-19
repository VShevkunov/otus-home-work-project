package project.pagewidgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    SelenideElement eventsButton = $x("//li[@class='nav-item events-icon']");

    public MainPage() {
        Selenide.open("");
        logger.info("Открыта главная страница");
    }

    public EventsPage getEventsPage() {
        eventsButton.click();
        return new EventsPage();
    }




}
