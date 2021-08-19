package project.pagewidgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    public MainPage() {
        super();
        Selenide.open("");
        logger.info("Открыта главная страница");
    }






}
