package project;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class BaseHook {

    @BeforeAll
    public static void setUpCapabilities() {

        Configuration.baseUrl = "https://events.epam.com/";
        Configuration.startMaximized = true;
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000; //ms

    }
}
