package project.pagewidgets;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EventsPage extends BasePage {

    ElementsCollection eventsList = $x("//div[@class='evnt-cards-container']").$$x(".//div[@class='evnt-card-wrapper']");
    SelenideElement currentEventsTab = $x("//a[@class='evnt-tab-link nav-link active']");

    public EventsPage(){
        super();
    }

    @Step("На странице отображаются карточки предстоящих мероприятий")
    public EventsPage checkVisabilityOfEventsCards() {
        int visible = eventsList.filter(Condition.visible).shouldBe(CollectionCondition.sizeGreaterThan(0)).size();
        logger.info("Отбразились карточки мероприятий {}", visible);
        Allure.addAttachment("Карточек", visible+"");
        return this;
    }


    @Step("Количество карточек равно счетчику на кнопке Upcoming Events")
    public void isEventsNumberEqualsCounter() {
        eventsList
                .shouldHaveSize(
                        Integer.parseInt(currentEventsTab.$x(".//span[3]").getText()));
    }

    @Step("Пользователь нажимает на Past Events")
    public EventsPage getPastEvents() {
        $x("//span[contains(text(), 'Past Events')]").click();
        return this;
    }






}
