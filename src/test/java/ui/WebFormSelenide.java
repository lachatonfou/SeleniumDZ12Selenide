package ui;

import Selenide.HomePageSelenide;
import Selenide.WebFormPageSelenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import steps.AllureSteps;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.value;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Tag("pages/selenide")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebFormSelenide {
    AllureSteps allureSteps = new AllureSteps();

    //HomePageSelenide homePageSelenide;
    HomePageSelenide homePageSelenide = new HomePageSelenide();
    WebFormPageSelenide webFormPageSelenide = new WebFormPageSelenide();

    @BeforeEach
    void setupWebForm() {
        homePageSelenide.openHome();
        homePageSelenide.openWebForm();
    }

    @Test
    void openWebFormTest() {
        String currentUrl = WebDriverRunner.url();
        String webFormUrl = webFormPageSelenide.getWebFormUrl();
        assertEquals(BASE_URL + webFormUrl, currentUrl);

        assertEquals("Web form", homePageSelenide.getWebTitle());
    }

    @Test
    void proverkaTextInput() {
        webFormPageSelenide.getTextInput().sendKeys("Halo");
        assertEquals("Halo", webFormPageSelenide.getTextInput().getAttribute("value"));
        assertEquals("Text input", webFormPageSelenide.getTextInputLabel().getText());
    }

    @Test
    void proverkaPassword() {
        webFormPageSelenide.getPassword().sendKeys("ololo");
        assertEquals("ololo", webFormPageSelenide.getPassword().getAttribute("value"));
        assertEquals("Password", webFormPageSelenide.getPasswordLabel().getText());
    }

    @Test
    void proverkaTextArea() {
        webFormPageSelenide.getTextArea().sendKeys("uwuwu");
        assertEquals("uwuwu", webFormPageSelenide.getTextArea().getAttribute("value"));
        assertEquals("Textarea", webFormPageSelenide.getTextAreaLabel().getText());
    }

    @Test
    void proverkaDisabledInput() {
        Assertions.assertFalse(webFormPageSelenide.getDisabledInput().isEnabled());
        //Assertions.assertThrows(ElementNotInteractableException.class, () -> webFormPageSelenide.getDisabledInput().sendKeys("test"));
        webFormPageSelenide.getDisabledInput().shouldNotBe(enabled);
        webFormPageSelenide.getDisabledInput()
                .setValue("test")
                .shouldHave(value(""));
        assertEquals("Disabled input", webFormPageSelenide.getDisabledInput().getAttribute("placeholder"));
        assertEquals("Disabled input", webFormPageSelenide.getDisabledInputLabel().getText());
    }

    @Test
    void proverkaReadonlyInput() {
        Assertions.assertTrue(webFormPageSelenide.getReadonlyInput().isEnabled());
        assertEquals("Readonly input", webFormPageSelenide.getReadonlyInput().getAttribute("value"));
        assertEquals("Readonly input", webFormPageSelenide.getReadonlyInputLabel().getText());
    }

    @Test
    void proverkaDropdownSelect() {
        Select dropdown = new Select(webFormPageSelenide.getdropdownSelect());
        dropdown.selectByVisibleText("Two");
        assertEquals("Two", dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("3");
        assertEquals("Three", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    void proverkaCheckedCheckbox() {
        webFormPageSelenide.getcheckedCheckbox().click();
        assertEquals("Checked checkbox", webFormPageSelenide.getcheckedCheckboxLabel().getText());
        assertEquals(false, webFormPageSelenide.getcheckedCheckbox().isSelected());
    }

    @Test
    void proverkaDefaultCheckbox() {
        webFormPageSelenide.getdefaultCheckbox().click();
        assertEquals("Default checkbox", webFormPageSelenide.getdefaultCheckboxLabel().getText());
        assertEquals(true, webFormPageSelenide.getdefaultCheckbox().isSelected());
    }
}
