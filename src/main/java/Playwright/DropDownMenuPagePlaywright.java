package Playwright;

import com.codeborne.selenide.SelenideElement;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropDownMenuPagePlaywright {

        private static final String DROP_DOWN_URL = "dropdown-menu.html";
        static Locator leftclickButton;
        static Locator leftclickMenu;
        static Locator rightclickButton;
        static Locator rightclickMenu;
        static Locator doubleclickButton;
        static Locator doubleclickMenu;

    public DropDownMenuPagePlaywright(Page page) {

//        //this.page = page;
//        this.submitButton = page.getByText("Submit");
        this.leftclickButton = page.locator("#my-dropdown-1");
        this.leftclickMenu = page.locator("//ul[@class='dropdown-menu show']/li[1]");
        this.rightclickButton = page.locator("#my-dropdown-2");
        this.rightclickMenu = page.locator("//ul[@id='context-menu-2']/li").first();
        this.doubleclickButton = page.locator("#my-dropdown-3");
        this.doubleclickMenu = page.locator("//ul[@id='context-menu-3']/li").first();
    }
    @Step("Get subpage Url")
    public String getUrl() {
        return DROP_DOWN_URL;
    }

    @Step("Get left click menu button")
    public static Locator getLeftClickMenuButton() {
        //SelenideElement leftclick = $(By.id("my-dropdown-1"));
        return leftclickButton;
    }

    @Step("Get left click menu")
    public static Locator getLeftClickMenu() {
        return leftclickMenu;
    }

    @Step("Get right click menu button")
    public static Locator getRightClickMenuButton() {
        //SelenideElement rightclick = $(By.id("my-dropdown-2"));
        return rightclickButton;
    }

    @Step("Get right click menu")
    public static Locator getRightClickMenu() {
        return rightclickMenu;
    }

    @Step("Get double click menu button")
    public static Locator getDoubleClickMenuButton() {
        //SelenideElement doubleclick = $(By.id("my-dropdown-3"));
        return doubleclickButton;
    }

    @Step("Get double click menu")
    public static Locator getDoubleClickMenu() {
        return doubleclickMenu;
    }
}
