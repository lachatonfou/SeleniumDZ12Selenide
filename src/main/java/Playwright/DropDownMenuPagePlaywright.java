package Playwright;

import com.codeborne.selenide.SelenideElement;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDownMenuPagePlaywright {

        private static final String DROP_DOWN_URL = "dropdown-menu.html";
        static Locator leftclick;
        static Locator rightclick;
        static Locator doubleclick;

    public DropDownMenuPagePlaywright(Page page) {

//        //this.page = page;
//        this.submitButton = page.getByText("Submit");
        this.leftclick = page.locator("#my-dropdown-1");
        this.rightclick = page.locator("#my-dropdown-2]");
        this.doubleclick = page.locator("#my-dropdown-3");
    }
    @Step("Get subpage Url")
    public String getUrl() {
        return DROP_DOWN_URL;
    }

    @Step("Get left click menu")
    public static Locator getLeftClickMenu() {
        //SelenideElement leftclick = $(By.id("my-dropdown-1"));
        return leftclick;
    }

    @Step("Get right click menu")
    public static Locator getRightClickMenu() {
        //SelenideElement rightclick = $(By.id("my-dropdown-2"));
        return rightclick;
    }

    @Step("Get double click menu")
    public static Locator getDoubleClickMenu() {
        //SelenideElement doubleclick = $(By.id("my-dropdown-3"));
        return doubleclick;
    }
}
