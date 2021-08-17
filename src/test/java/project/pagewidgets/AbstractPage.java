package project.pagewidgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(this.getClass());  //универсальный предок всех логеров

    //TestConfig cfg = ConfigFactory.create(TestConfig.class);

    NavigationPanel navigationPanel;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        //navigationPanel = new NavigationPanel(driver);
    }


}
