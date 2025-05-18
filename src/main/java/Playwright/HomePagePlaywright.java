package Playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePagePlaywright {
    private final Page page;
    private final Locator webFormButton;
    private final Locator dropdownMenuButton;
    private static Locator title = null;

    public HomePagePlaywright(Page page) {
        this.page = page;
        this.webFormButton = page.getByText("Web form");
        this.dropdownMenuButton = page.getByText("Dropdown menu");
        this.title = page.locator(".display-6");
    }

    @Step("Open homepage")
    public void openHome() {
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @Step("Open Web form page")
    public WebFormPagePlaywright openWebFormPage() {
        webFormButton.click();
        return new WebFormPagePlaywright(page);
    }

    @Step("Open DropDown menu page")
    public DropDownMenuPagePlaywright openDropDownMenuPage() {
        dropdownMenuButton.click();
        return new DropDownMenuPagePlaywright(page);
    }

    @Step("Get web title")
    public static String getWebTitle() {
//        SelenideElement title = $(className("display-6"));
        return title.textContent();
        //getText();
    }
}
