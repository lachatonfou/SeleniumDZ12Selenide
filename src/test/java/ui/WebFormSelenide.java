package ui;

import Selenide.HomePageSelenide;
import Selenide.WebFormPageSelenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import steps.AllureSteps;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

@Tag("pages/selenide")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebFormSelenide {
    //AllureSteps allureSteps = new AllureSteps();

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
        webFormPageSelenide.getTextInput().setValue("Halo");
                //.sendKeys("Halo");
        assertEquals("Halo", webFormPageSelenide.getTextInput().getValue());
                //.getAttribute("value"));
        assertEquals("Text input", webFormPageSelenide.getTextInputLabel().text());
                //.getText());
    }

    @Test
    void proverkaPassword() {
        webFormPageSelenide.getPassword().setValue("ololo");
        assertEquals("ololo", webFormPageSelenide.getPassword().getValue());
        assertEquals("Password", webFormPageSelenide.getPasswordLabel().text());
    }

    @Test
    void proverkaTextArea() {
        webFormPageSelenide.getTextArea().setValue("uwuwu");
        assertEquals("uwuwu", webFormPageSelenide.getTextArea().getValue());
        assertEquals("Textarea", webFormPageSelenide.getTextAreaLabel().text());
    }

    @Test
    void proverkaDisabledInput() {
        Assertions.assertFalse(webFormPageSelenide.getDisabledInput().isEnabled());
        //Assertions.assertThrows(ElementNotInteractableException.class, () -> webFormPageSelenide.getDisabledInput().sendKeys("test"));
        webFormPageSelenide.getDisabledInput().shouldBe(disabled);
        webFormPageSelenide.getDisabledInput().shouldHave(attribute("disabled"));

        assertEquals("Disabled input", webFormPageSelenide.getDisabledInput().attr("placeholder"));
                //.getAttribute("placeholder"));
        assertEquals("Disabled input", webFormPageSelenide.getDisabledInputLabel().text());
    }

    @Test
    void proverkaReadonlyInput() {
        Assertions.assertTrue(webFormPageSelenide.getReadonlyInput().isEnabled());
        assertEquals("Readonly input", webFormPageSelenide.getReadonlyInput().getValue());
        assertEquals("Readonly input", webFormPageSelenide.getReadonlyInputLabel().text());
    }

    @Test
    void proverkaDropdownSelect() {
        webFormPageSelenide.getdropdownSelect().selectOption("Two");
        assertEquals("Two", webFormPageSelenide.getdropdownSelect().getSelectedOption().text());
        //.getFirstSelectedOption().getText());
        webFormPageSelenide.getdropdownSelect().selectOptionByValue("3");
        assertEquals("3", webFormPageSelenide.getdropdownSelect().getSelectedOptionValue());
    }

    @Test
    void proverkaCheckedCheckbox() {
        webFormPageSelenide.getcheckedCheckbox().setSelected(true);
                //.click();
        assertEquals("Checked checkbox", webFormPageSelenide.getcheckedCheckboxLabel().text());
        assertEquals("on", webFormPageSelenide.getcheckedCheckbox().getValue());
        //assertEquals(true, webFormPageSelenide.getcheckedCheckbox().isSelected());
        webFormPageSelenide.getcheckedCheckbox().shouldBe(selected);
    }

    @Test
    void proverkaDefaultCheckbox() {
        webFormPageSelenide.getdefaultCheckbox().setSelected(true);
                //.click();
        assertEquals("Default checkbox", webFormPageSelenide.getdefaultCheckboxLabel().text());
        assertEquals("on", webFormPageSelenide.getcheckedCheckbox().getValue());
        assertEquals(true, webFormPageSelenide.getdefaultCheckbox().isSelected());
        webFormPageSelenide.getcheckedCheckbox().shouldBe(selected);
    }
}
