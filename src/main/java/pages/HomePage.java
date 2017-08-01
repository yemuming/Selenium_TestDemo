package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.WebDriverUntil;

/**
 * Created by xmy on 2017/8/1.
 */
public class HomePage {
    public static WebElement SearchInput(WebDriver driver, String name) {
        return WebDriverUntil.getElement(driver, name, "CouldMusicHomePage");
    }

    //每次需要填写driver无法只写一个
    public static void cleanSearchInput(WebDriver driver) {
        HomePage.SearchInput(driver, "搜索输入框").clear();
    }

    public static void inputSearchContent(WebDriver driver, String content) {
        HomePage.SearchInput(driver, "搜索输入框").sendKeys(content);
    }
    public  static  void doSearchAction(WebDriver driver){
        HomePage.SearchInput(driver, "搜索输入框").sendKeys(Keys.ENTER);
    }
}