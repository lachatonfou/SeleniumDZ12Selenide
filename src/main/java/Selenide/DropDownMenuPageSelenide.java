package Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDownMenuPageSelenide {
    private static final String DROP_DOWN_URL = "dropdown-menu.html";

//    public DropDownMenuPage(WebDriver driver) {
//        super(driver);
//        //PageFactory.initElements(driver, this);
//    }

    @Step("Get subpage Url")
    public String getUrl() {
        return DROP_DOWN_URL;
    }

    @Step("Get left click menu")
    public SelenideElement getLeftClickMenu() {
        SelenideElement leftclick = $(By.id("my-dropdown-1"));
        return leftclick;
    }

    @Step("Get right click menu")
    public SelenideElement getRightClickMenu() {
        SelenideElement rightclick = $(By.id("my-dropdown-2"));
        return rightclick;
    }

    @Step("Get double click menu")
    public SelenideElement getDoubleClickMenu() {
        SelenideElement doubleclick = $(By.id("my-dropdown-3"));
        return doubleclick;
    }
}
