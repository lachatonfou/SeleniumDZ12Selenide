package ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.*;
import steps.AllureSteps;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObjects.HomePage.BASE_URL;

import Playwright.HomePagePlaywright;
import Playwright.WebFormPagePlaywright;

@Tag("playwright")
public class WebFormTestPlaywright {

    AllureSteps allureSteps = new AllureSteps();

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        HomePagePlaywright homePagePlaywright = new HomePagePlaywright(page);
        homePagePlaywright.openHome();
        homePagePlaywright.openWebFormPage();
    }

    @AfterEach
    void closeContext() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        context.close();
    }

    @Test
    void openWebFormTest() {
        String currentUrl = page.url();
        String webFormUrl = WebFormPagePlaywright.getWebFormUrl();
        assertEquals(BASE_URL + webFormUrl, currentUrl);

        assertEquals("Web form", HomePagePlaywright.getWebTitle());
    }

    @Test
    void proverkaTextInput() {
        WebFormPagePlaywright.getTextInput().fill("Halo");
        //.sendKeys("Halo");
        assertEquals("Halo", WebFormPagePlaywright.getTextInput().inputValue());
        //.getAttribute("value"));
        assertEquals("Text input", WebFormPagePlaywright.getTextInputLabel().innerText());
        //.getText());
    }

    @Test
    void proverkaPassword() {
        WebFormPagePlaywright.getPassword().fill("ololo");
        assertEquals("ololo", WebFormPagePlaywright.getPassword().inputValue());
        assertEquals("Password", WebFormPagePlaywright.getPasswordLabel().innerText());
    }

    @Test
    void proverkaTextArea() {
        WebFormPagePlaywright.getTextArea().fill("uwuwu");
        assertEquals("uwuwu", WebFormPagePlaywright.getTextArea().inputValue());
        assertEquals("Textarea", WebFormPagePlaywright.getTextAreaLabel().innerText());
    }

    @Test
    void proverkaDisabledInput() {
        //Assertions.assertFalse(webFormPagePlaywright.getDisabledInput().isEnabled());
        //Assertions.assertThrows(ElementNotInteractableException.class, () -> webFormPageSelenide.getDisabledInput().sendKeys("test"));
        WebFormPagePlaywright.getDisabledInput().isDisabled();
        WebFormPagePlaywright.getDisabledInput().getAttribute("disabled");

        assertEquals("Disabled input", WebFormPagePlaywright.getDisabledInput().getAttribute("placeholder"));
        assertEquals("Disabled input", WebFormPagePlaywright.getDisabledInputLabel().innerText());
    }

    @Test
    void proverkaReadonlyInput() {
        //Assertions.assertTrue(webFormPagePlaywright.getReadonlyInput().isEnabled());
        WebFormPagePlaywright.getReadonlyInput().isEnabled();

        assertEquals("Readonly input", WebFormPagePlaywright.getReadonlyInput().inputValue());
        assertEquals("Readonly input", WebFormPagePlaywright.getReadonlyInputLabel().innerText());
    }

    @Test
    void proverkaDropdownSelect() {
        WebFormPagePlaywright.getdropdownSelect().selectOption("Two");
        assertEquals("Two", WebFormPagePlaywright.getdropdownSelect().locator("option:checked").innerText());
        //.getFirstSelectedOption().getText());
        WebFormPagePlaywright.getdropdownSelect().selectOption(String.valueOf(3));
        assertEquals("3", WebFormPagePlaywright.getdropdownSelect().inputValue());
    }

    @Test
    void proverkaCheckedCheckbox() {
        WebFormPagePlaywright.getcheckedCheckbox().check();
        //.click();
        assertEquals("Checked checkbox", WebFormPagePlaywright.getcheckedCheckboxLabel().innerText());
        assertEquals(true, WebFormPagePlaywright.getcheckedCheckbox().isChecked());
        //assertEquals(true, webFormPageSelenide.getcheckedCheckbox().isSelected());
    }

    @Test
    void proverkaDefaultCheckbox() {
        WebFormPagePlaywright.getdefaultCheckbox().check();
        //.click();
        assertEquals("Default checkbox", WebFormPagePlaywright.getdefaultCheckboxLabel().innerText());
        assertEquals(true, WebFormPagePlaywright.getcheckedCheckbox().isChecked());
    }
}
