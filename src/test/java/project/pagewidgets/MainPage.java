package project.pagewidgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    SelenideElement cookieOk = $x("//button[@id='onetrust-accept-btn-handler']");


    public MainPage() {
        Selenide.open("");
        logger.info("Открыта главная страница");
        if (cookieOk.isDisplayed()){
            cookieOk.click();
            logger.info("Приняты куки");
        }

    }








}
