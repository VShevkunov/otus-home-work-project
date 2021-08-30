package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class VideoPage extends BasePage {

    SelenideElement filtersHeading = $x("//div[@class='evnt-filters-heading']");
    SelenideElement moreFilters = $x("//span[contains(text(), 'More Filters')]");
    SelenideElement search = $x("//input[@placeholder='Search by Talk Name']");

    SelenideElement eventWrapper = $x("//div[@class='evnt-talks-wrapper']");
    ElementsCollection eventCards = $$x("//div[@class='evnt-talks-wrapper']//div[@class='evnt-card-table']");
    By eventTalkName = By.xpath(".//div[@class='evnt-talk-name']//span");

    @Step("На странице отображаются карточки соответствующие правилам выбранных фильтров")
    public VideoPage cardsClickedValidation(String ...rules) {

        SelenideElement openedCardInfo = $x("//div[@class='evnt-card-cell details-cell']");
        SelenideElement opendCardBackButton = $x("//a[contains(text(), 'Back')]");

        for (int i = 0; i < eventCards.size() ; i++) {
            eventCards.get(i).click();
            waitLoader();

            for (String rule : rules) {
                openedCardInfo.should(matchText(rule));
                logger.info("{} проверен", rule);
            }

            opendCardBackButton.click();
            waitLoader();
        }
        return this;
    }

    @Step("Пользователь выбирает фильтр")
    public VideoPage filterBy (String filterType, String filterName) {
        filtersHeading.$x(".//span[contains(text(), '" + filterType + "')]").click();
        filtersHeading.$x(".//label[@data-value='" + filterName + "']").click();
        waitLoader();
        logger.info("Отфильтровано по {} - {}", filterType, filterName);
        //filtersHeading.$x(".//label[@data-value='" + filterName + "']").pressEscape();
        return this;
    }

    @Step("Пользователь нажимает на More Filters")
    public VideoPage getMoreFilters() {
        moreFilters.click();
        logger.info("Пользователь нажимает на More Filters");
        return this;
    }

    @Step("Пользователь вводит ключевое слово в поле поиска")
    public VideoPage search(String request) {
        search.clear();
        search.setValue(request);
        waitLoader();
        logger.info("Пользователь ввел ключевое слово {} в поле поиска", request);
        return this;
    }

    @Step("На странице отображаются доклады, содержащие в названии ключевое слово поиска")
    public VideoPage cardsNonClickedValidation(String ...rules) {

        for (int i = 0; i < eventCards.size(); i++) {

            for (String rule : rules) {
                eventCards.get(i).$(eventTalkName).should(matchText(rule));
                logger.info("Проверен {} в {}", rule, eventCards.get(i).$(eventTalkName).getText());
            }

        }

        return this;
    }

}
