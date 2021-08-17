package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NavigationPanel {

    // Elements
    public static SelenideElement eventsButton = $x("//li[@class='nav-item events-icon']");


//    public NavigationPanel(WebDriver driver) {
//        super(driver);
//    }

//    public EventsPage getEventsPage() {
//        eventsButton.click();
//        return new EventsPage(driver);
//    }


}
