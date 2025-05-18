package ui;

import Selenide.DropDownMenuPageSelenide;
import Selenide.HomePageSelenide;
import Selenide.WebFormPageSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.DropDownMenuPage;
import pageObjects.HomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropDownMenuSelenide {
    HomePageSelenide homePageSelenide = new HomePageSelenide();
    DropDownMenuPageSelenide dropDownMenuPageSelenide = new DropDownMenuPageSelenide();

    @BeforeEach
    void setupWebForm() {
        homePageSelenide.openHome();
        homePageSelenide.openDropDownMenu();
    }

    @Test
    void proverkaDropdownMenu(){
//        Actions actions = new Actions(driver);
//        actions.click(dropDownMenuPageSelenide.getLeftClickMenu()).perform();

        dropDownMenuPageSelenide.getLeftClickMenu().click();
        String firstItemText1 = $$(By.xpath("//ul[@class='dropdown-menu show']/li")).first().text();

//        List<WebElement> menuItems1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']"));
//        WebElement firstItem1 = menuItems1.get(0);
//        String[] firstItemText1 = firstItem1.getText().split("\n");

        assertEquals("Action", firstItemText1);
        assertThat(firstItemText1).isEqualTo("Action");
    }

    @Test
    void rightClick() {
//        Actions actions = new Actions(driver);
//        actions.contextClick(dropDownMenuPageSelenide.getRightClickMenu()).perform();

          dropDownMenuPageSelenide.getRightClickMenu().contextClick();
          String firstItemText2 = $$(By.xpath("//ul[@id='context-menu-2']/li[1]")).first().text();

//        List<WebElement> menuItems2 = driver.findElements(By.id("context-menu-2"));
//        WebElement firstItem2 = menuItems2.get(0);
//        String[] firstItemText2 = firstItem2.getText().split("\n");
          assertEquals("Action", firstItemText2);
          assertThat(firstItemText2).isEqualTo("Action");
    }

    @Test
    void doubleClick() {
//        Actions actions = new Actions(driver);
//        actions.doubleClick(dropDownMenuPageSelenide.getDoubleClickMenu()).perform();
//        List<WebElement> menuItems3 = driver.findElements(By.id("context-menu-3"));

          dropDownMenuPageSelenide.getDoubleClickMenu().doubleClick();
          String firstItemText3 = $$(By.xpath("//ul[@id='context-menu-3']/li[1]")).first().text();

//        WebElement firstItem3 = menuItems3.get(0);
//        String[] firstItemText3 = firstItem3.getText().split("\n");
//        assertEquals("Action", firstItemText3[0]);

          assertEquals("Action", firstItemText3);
          assertThat(firstItemText3).isEqualTo("Action");
    }
}
