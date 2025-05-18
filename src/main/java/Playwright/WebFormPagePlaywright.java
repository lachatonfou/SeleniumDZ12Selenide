package Playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class WebFormPagePlaywright {
    //private final Page page;

    private static final String WEB_FORM_URL = "web-form.html";

    static Locator textInput;
    static Locator textInputLabel;
    static Locator password;
    static Locator passwordLabel;
    static Locator textArea;
    static Locator textAreaLabel;
    static Locator disabledInput;
    static Locator disabledInputLabel;
    static Locator readonlyInput;
    static Locator readonlyInputLabel;
    static Locator dropdownSelect;
    static Locator checkedCheckbox;
    static Locator checkedCheckboxLabel;
    static Locator defaultCheckbox;
    static Locator defaultCheckboxLabel;

    public WebFormPagePlaywright(Page page) {
        //this.page = page;
        this.textInput = page.locator("#my-text-id");
        this.textInputLabel = page.locator("//label[normalize-space(.)='Text input']");
        this.password = page.locator("[name = \"my-password\"]");
        this.passwordLabel = page.locator("//label[normalize-space(.)='Password']");
        this.textArea = page.locator("[name = \"my-textarea\"]");
        this.textAreaLabel = page.locator("//label[normalize-space(.)='Textarea']");
        this.disabledInput = page.locator("[name = \"my-disabled\"]");
        this.disabledInputLabel = page.locator("//label[normalize-space(.)='Disabled input']");
        this.readonlyInput = page.locator("[name = \"my-readonly\"]");
        this.readonlyInputLabel = page.locator("//label[normalize-space(.)='Readonly input']");
        this.dropdownSelect = page.locator("[name = \"my-select\"]");
        this.checkedCheckbox = page.locator("#my-check-1");
        this.checkedCheckboxLabel = page.locator("//label[normalize-space(.)='Checked checkbox']");
        this.defaultCheckbox = page.locator("#my-check-2");
        this.defaultCheckboxLabel = page.locator("//label[normalize-space(.)='Default checkbox']");
    }

    @Step("Get subpage Url")
    public static String getWebFormUrl() {
        return WEB_FORM_URL;
    }

    @Step("Get textInput field")
    public static Locator getTextInput() {
        return textInput;
    }

    @Step("Get textInput label")
    public static Locator getTextInputLabel() {
        //SelenideElement textInputLabel = $(By.xpath("//label[normalize-space(.)='Text input']"));
        return textInputLabel;
    }

    @Step("Get password field")
    public static Locator getPassword() {
        //SelenideElement password = $(By.name("my-password"));
        return password;
    }

    @Step("Get password label")
    public static Locator getPasswordLabel() {
        //SelenideElement passwordLabel = $(By.xpath("//label[normalize-space(.)='Password']"));
        return passwordLabel;
    }

    @Step("Get text area field")
    public static Locator getTextArea() {
        //SelenideElement textArea = $(By.name("my-textarea"));
        return textArea;
    }

    @Step("Get text area label")
    public static Locator getTextAreaLabel() {
        //SelenideElement textAreaLabel = $(By.xpath("//label[normalize-space(.)='Textarea']"));
        return textAreaLabel;
    }

    @Step("Get disabled input field")
    public static Locator getDisabledInput() {
        //SelenideElement disabledInput = $(By.name("my-disabled"));
        return disabledInput;
    }

    @Step("Get disabled input label")
    public static Locator getDisabledInputLabel() {
        //SelenideElement disabledInputLabel = $(By.xpath("//label[normalize-space(.)='Disabled input']"));
        return disabledInputLabel;
    }

    @Step("Get readonly input field")
    public static Locator getReadonlyInput() {
        //SelenideElement readonlyInput = $(By.name("my-readonly"));
        return readonlyInput;
    }

    @Step("Get readonly input label")
    public static Locator getReadonlyInputLabel() {
        //SelenideElement readonlyInputLabel = $(By.xpath("//label[normalize-space(.)='Readonly input']"));
        return readonlyInputLabel;
    }

    @Step("Get dropdown select field")
    public static Locator getdropdownSelect() {
        //SelenideElement dropdownSelect = $(By.name("my-select"));
        return dropdownSelect;
    }

    @Step("Get checked checkbox field")
    public static Locator getcheckedCheckbox() {
        //SelenideElement checkedCheckbox = $(By.id("my-check-1"));
        return checkedCheckbox;
    }

    @Step("Get checked checkbox label")
    public static Locator getcheckedCheckboxLabel() {
        //SelenideElement checkedCheckboxLabel = $(By.xpath("//label[normalize-space(.)='Checked checkbox']"));
        return checkedCheckboxLabel;
    }

    @Step("Get default checkbox field")
    public static Locator getdefaultCheckbox() {
        //SelenideElement defaultCheckbox = $(By.id("my-check-2"));
        return defaultCheckbox;
    }

    @Step("Get default checkbox label")
    public static Locator getdefaultCheckboxLabel() {
        //SelenideElement defaultCheckboxLabel = $(By.xpath("//label[normalize-space(.)='Default checkbox']"));
        return defaultCheckboxLabel;
    }
}
