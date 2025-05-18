package Selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageSelenide {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

//    public HomePage(WebDriver driver) {
//        //super(driver);
//        //PageFactory.initElements(driver, this);
//        openHome();

//    }

    @Step("Open homepage")
    public void openHome() {
        open(BASE_URL);
    }

    @Step("Open Web form page")
    public WebFormPageSelenide openWebForm() {
        SelenideElement webFormButton = $(By.xpath("//a[@href = 'web-form.html']"));
        webFormButton.click();
        return new WebFormPageSelenide();
    }

//    @Step("Open Navigation page")
//    public NavigationPage openNavigationPage() {
//        WebElement navigationButton = $(By.xpath("//a[@href = 'navigation1.html']"));
//        navigationButton.click();
//        return new NavigationPage();
//    }

    @Step("Open DropDown menu page")
    public DropDownMenuPageSelenide openDropDownMenu() {
        SelenideElement dropdownMenuButton = $(By.xpath("//a[@href = 'dropdown-menu.html']"));
        dropdownMenuButton.click();
        return new DropDownMenuPageSelenide();
    }

//    @Step("Open DialogBoxes page")
//    public DialogBoxesPage openDialogBoxesPage() {
//        WebElement dialogBoxesButton = $(By.xpath("//a[@href = 'dialog-boxes.html']"));
//        dialogBoxesButton.click();
//        return new DialogBoxesPage(driver);
//    }

    @Step("Get web title")
    public String getWebTitle() {
        SelenideElement title = $(By.className("display-6"));
        return title.getText();
    }
}
