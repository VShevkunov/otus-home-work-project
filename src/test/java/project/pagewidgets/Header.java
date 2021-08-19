package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Header {

    SelenideElement area = $x("//div[@class='evnt-platform-header']");

    SelenideElement eventsButton = area.$x(".//a[contains(text(), 'Events')]");
    SelenideElement calendarButton = area.$x(".//a[contains(text(), 'Calendar')]");
    SelenideElement videoButton = area.$x(".//a[contains(text(), 'Video')]");
    SelenideElement logoButton = area.$x(".//a[@class='evnt-brand-logo']");
    SelenideElement loginButton = area.$x(".//a[contains(text(), 'Login')]");

    public EventsPage getEventsPage() {
        eventsButton.click();
        return new EventsPage();
    }





}
