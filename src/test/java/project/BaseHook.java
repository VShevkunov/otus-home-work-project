package project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseHook {

    @BeforeAll
    public static void setUp() {

        //Configuration.remote = "http://localhost:4444/wd/hub/";

        //Создаём объект класса DesiredCapabilities, используется как настройка конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC", true);
        //Включение записи видео в процессе выполнения тестов
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLogs", true);

        //Configuration.browser = "chrome";
        //Configuration.browserVersion = "90.0";
        Configuration.baseUrl = "https://events.epam.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 5000; //ms

    }
}
