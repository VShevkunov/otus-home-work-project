package project;

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
