package project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EpamTest extends BaseHook {

    SelenideElement eventsButton = $x("//li[@class='nav-item events-icon']");

    @BeforeEach
    public void setUp() {
        open("/");
    }

    @Test
    public void test() {

        eventsButton.shouldBe(Condition.visible);

    }
}
