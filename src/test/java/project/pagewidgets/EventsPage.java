package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class EventsPage extends BasePage {

    ElementsCollection eventsList = $x("//div[@class='evnt-cards-container']").$$x(".//div[@class='evnt-card-wrapper']");
    static SelenideElement eventsCount = $x("//span[contains(text(),'Upcoming events')]/following-sibling::span[2]");

    public EventsPage(){
        super();
    }


    public ElementsCollection getEventsList() {
        return eventsList;
    }

    public static Integer getEventsCount() {
        return Integer.parseInt(eventsCount.getText());
    }






}
