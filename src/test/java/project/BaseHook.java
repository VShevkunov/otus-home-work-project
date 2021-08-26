package project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseHook {

    @BeforeAll
    public static void setUp() {

        //Создаём объект класса DesiredCapabilities, используется как настройка  вашей конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "92.0");
        //Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC", true);
        //Включение записи видео в процессе выполнения тестов
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLogs", true);
        Configuration.baseUrl = "https://events.epam.com/";

        //Url удалённого веб драйвера
        Configuration.remote = "http://localhost:4444/wd/hub";
        //Определяем какой браузер будем использовать
        //Configuration.browser = "Chrome";
        //Размер окна браузера
        Configuration.browserSize = "1920x1080";

        Configuration.browserCapabilities = capabilities;

        //Configuration.startMaximized = true;
        Configuration.timeout = 5000; //ms

    }
}
