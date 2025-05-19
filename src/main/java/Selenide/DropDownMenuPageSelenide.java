package Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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

    @Step("Get left click menu button")
    public SelenideElement getLeftClickMenuButton() {
        SelenideElement leftclickButton = $(By.id("my-dropdown-1"));
        return leftclickButton;
    }

    @Step("Get left click menu")
    public SelenideElement getLeftClickMenu() {
        SelenideElement leftclickMenu = $$(By.xpath("//ul[@class='dropdown-menu show']/li")).first();
        return leftclickMenu;
    }

    @Step("Get right click menu button")
    public SelenideElement getRightClickMenuButton() {
        SelenideElement rightclickButton = $(By.id("my-dropdown-2"));
        return rightclickButton;
    }

    @Step("Get right click menu")
    public SelenideElement getRightClickMenu() {
        SelenideElement rightclickMenu = $$(By.xpath("//ul[@id='context-menu-2']/li[1]")).first();
        return rightclickMenu;
    }

    @Step("Get double click menu button")
    public SelenideElement getDoubleClickMenuButton() {
        SelenideElement doubleclickButton = $(By.id("my-dropdown-3"));
        return doubleclickButton;
    }

    @Step("Get double click menu")
    public SelenideElement getDoubleClickMenu() {
        SelenideElement doubleclickMenu = $$(By.xpath("//ul[@id='context-menu-3']/li[1]")).first();
        return doubleclickMenu;
    }
}
