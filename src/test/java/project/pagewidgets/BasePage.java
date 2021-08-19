package project.pagewidgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {

    protected Logger logger = LogManager.getLogger(this.getClass());  //универсальный предок всех логеров

    //TestConfig cfg = ConfigFactory.create(TestConfig.class);

    NavigationPanel navigationPanel;

    public BasePage() {

    }


}
