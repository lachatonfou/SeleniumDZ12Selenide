package Selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class WebFormPageSelenide {
    private static final String WEB_FORM_URL = "web-form.html";

//    public WebFormPage(WebDriver driver) {
//        super(driver);
//        // PageFactory.initElements(driver, this);
//    }

    @Step("Get subpage Url")
    public String getWebFormUrl() {
        return WEB_FORM_URL;
    }

    @Step("Get textInput field")
    public SelenideElement getTextInput() {
        SelenideElement textInput = $(By.id("my-text-id"));
        return textInput;
    }

    @Step("Get textInput label")
    public SelenideElement getTextInputLabel() {
        SelenideElement textInputLabel = $(By.xpath("//label[normalize-space(.)='Text input']"));
        return textInputLabel;
    }

    @Step("Get password field")
    public SelenideElement getPassword() {
        SelenideElement password = $(By.name("my-password"));
        return password;
    }

    @Step("Get password label")
    public SelenideElement getPasswordLabel() {
        SelenideElement passwordLabel = $(By.xpath("//label[normalize-space(.)='Password']"));
        return passwordLabel;
    }

    @Step("Get text area field")
    public SelenideElement getTextArea() {
        SelenideElement textArea = $(By.name("my-textarea"));
        return textArea;
    }

    @Step("Get text area label")
    public SelenideElement getTextAreaLabel() {
        SelenideElement textAreaLabel = $(By.xpath("//label[normalize-space(.)='Textarea']"));
        return textAreaLabel;
    }

    @Step("Get disabled input field")
    public SelenideElement getDisabledInput() {
        SelenideElement disabledInput = $(By.name("my-disabled"));
        return disabledInput;
    }

    @Step("Get disabled input label")
    public SelenideElement getDisabledInputLabel() {
        SelenideElement disabledInputLabel = $(By.xpath("//label[normalize-space(.)='Disabled input']"));
        return disabledInputLabel;
    }

    @Step("Get readonly input field")
    public SelenideElement getReadonlyInput() {
        SelenideElement readonlyInput = $(By.name("my-readonly"));
        return readonlyInput;
    }

    @Step("Get readonly input label")
    public SelenideElement getReadonlyInputLabel() {
        SelenideElement readonlyInputLabel = $(By.xpath("//label[normalize-space(.)='Readonly input']"));
        return readonlyInputLabel;
    }

    @Step("Get dropdown select field")
    public SelenideElement getdropdownSelect() {
        SelenideElement dropdownSelect = $(By.name("my-select"));
        return dropdownSelect;
    }

    @Step("Get checked checkbox field")
    public SelenideElement getcheckedCheckbox() {
        SelenideElement checkedCheckbox = $(By.id("my-check-1"));
        return checkedCheckbox;
    }

    @Step("Get checked checkbox label")
    public SelenideElement getcheckedCheckboxLabel() {
        SelenideElement checkedCheckboxLabel = $(By.xpath("//label[normalize-space(.)='Checked checkbox']"));
        return checkedCheckboxLabel;
    }

    @Step("Get default checkbox field")
    public SelenideElement getdefaultCheckbox() {
        SelenideElement defaultCheckbox = $(By.id("my-check-2"));
        return defaultCheckbox;
    }

    @Step("Get default checkbox label")
    public SelenideElement getdefaultCheckboxLabel() {
        SelenideElement defaultCheckboxLabel = $(By.xpath("//label[normalize-space(.)='Default checkbox']"));
        return defaultCheckboxLabel;
    }
}
