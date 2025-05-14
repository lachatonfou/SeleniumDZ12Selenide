package ui;

//import configs.TestPropertiesConfig;
//import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import static patterns.factory.WebDriverFactory.createWebDriver;

public class BaseTest {
    protected WebDriver driver;
    //TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        //driver = createWebDriver(configProperties.browser());
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
