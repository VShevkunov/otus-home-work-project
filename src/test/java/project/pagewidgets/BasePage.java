package project.pagewidgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {

    public Header header;

    protected Logger logger = LogManager.getLogger(this);  //универсальный предок всех логеров

    //TestConfig cfg = ConfigFactory.create(TestConfig.class);

    public BasePage() {
        header = new Header();
    }




}
