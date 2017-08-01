package paly;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import tools.WebDriverUntil;

/**
 * Created by xmy on 2017/8/1.
 */
public class TestPlayMusic {
    @Test(description = "搜索wild wild web歌曲并播放")
    @Parameters("test")
    public void testSearchAndPlayMusic(String test) throws InterruptedException{
        WebDriverUntil.init("Setting");
        WebDriver webDriver= WebDriverUntil.getWebDriver();
        webDriver.manage().window().maximize();

        WebDriverUntil.start(webDriver);

        HomePage.cleanSearchInput(webDriver);

        HomePage.inputSearchContent(webDriver,test);

        HomePage.doSearchAction(webDriver);

//        SearchResultPage.handleIFrame();
//
//        SearchResultPage.doPlayAction();

        Thread.sleep(2000);

        WebDriverUntil.stop(webDriver);
    }
}
