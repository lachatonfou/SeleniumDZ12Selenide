package ui;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.AllureSteps;

import Playwright.HomePagePlaywright;
import Playwright.DropDownMenuPagePlaywright;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("playwright")
public class DropDownMenuTestPlaywright {
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
        homePagePlaywright.openDropDownMenuPage();
    }

    @AfterEach
    void closeContext() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        context.close();
    }
    @Test
    void proverkaDropdownMenu(){
        Actions actions = new Actions(driver);
        actions.click(dropDownMenuPage.getLeftClickMenu()).perform();
        List<WebElement> menuItems1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']"));
        WebElement firstItem1 = menuItems1.get(0);
        String[] firstItemText1 = firstItem1.getText().split("\n");
        assertEquals("Action", firstItemText1[0]);
    }

    @Test
    void rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(dropDownMenuPage.getRightClickMenu()).perform();
        List<WebElement> menuItems2 = driver.findElements(By.id("context-menu-2"));
        WebElement firstItem2 = menuItems2.get(0);
        String[] firstItemText2 = firstItem2.getText().split("\n");
        assertEquals("Action", firstItemText2[0]);
    }

    @Test
    void doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(dropDownMenuPage.getDoubleClickMenu()).perform();
        List<WebElement> menuItems3 = driver.findElements(By.id("context-menu-3"));
        WebElement firstItem3 = menuItems3.get(0);
        String[] firstItemText3 = firstItem3.getText().split("\n");
        assertEquals("Action", firstItemText3[0]);
    }
}
