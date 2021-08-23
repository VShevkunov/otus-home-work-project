package project.pagewidgets;

import com.codeborne.selenide.Selenide;

public class MainPage extends BasePage {


    public MainPage() {
        super();
        Selenide.open("");
        logger.info("Открыта главная страница");
    }






}
