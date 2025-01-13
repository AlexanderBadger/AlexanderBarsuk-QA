import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static main.constants.LogMessages.OPEN_CATALOG_PAGE_LOG;
import static main.constants.PathConstants.BASE_URL;

@Log4j
abstract public class BaseTest {
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void init(){
        setUp();
        log.info(OPEN_CATALOG_PAGE_LOG);
        Selenide.open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}