package tools;

/**
 * Created by xmy on 2017/8/1.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import  static tools.ParseYamUntil.locators;
import  static tools.ParseYamUntil.settings;
public class WebDriverUntil {

        private  static  String browser_type;
        private  static  String  site_url;
    /**
     *  初始化获取配置文件
     *  @param  settingFileName;
     */
        public  static  void init(String settingFileName){
            settings=ParseYamUntil.parseLocatorFile(settingFileName);
            browser_type=settings.get("browser_type").get("value");
            site_url=settings.get("site_url").get("value");
        }
    /**
     *  获取driver
     * @return
     */
    public  static WebDriver getWebDriver(){
        WebDriver driver=null;
        if ("chrome".equals(browser_type)){
            driver= new ChromeDriver();
        }else if("IE".equals(browser_type)){
            driver=new InternetExplorerDriver();
        }else  if("fireFox".equals(browser_type)){
            driver= new FirefoxDriver();
        }else{
            System.out.println("not found browsertype please check browsertype");
        }
         return  driver;
    }
    /**
     *  停止driver
     * @param  driver
     */
        public  static void stop(WebDriver driver){
            if (driver==null){
                System.out.println("the driver is not exist");
            }
            System.out.println("driver start");
            driver.quit();
        }
    /**
     *  开始driver
     * @param  driver
     */
        public  static  void start(WebDriver driver){
            if (driver==null){
                System.out.println("the driver is null");
            }
            System.out.println("driver start");
            driver.get(site_url);
        }
    /**
     *  获取element
     * @param  key
     * @param  locatorFileName
     * @return
     */
    public static WebElement getElement(WebDriver driver,String key,String locatorFileName){
        if (driver==null){
            System.out.println("driver is not exist");
            return  null;
        }
        locators= ParseYamUntil.parseLocatorFile((locatorFileName));
        String type=locators.get(key).get("type");
        String value=locators.get(key).get("value");
        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(type,value)));
        WebElement webElement=driver.findElement(getBy(type,value));
        return  webElement;
    }
    /**
     *定位方法
     * @param type
     * @param value
     * @return
     */
    public static By getBy(String type,String value) {
        By by = null;
        if ("xpath".equalsIgnoreCase(type)) {
            by = new By.ByXPath(value);
        } else if ("id".equalsIgnoreCase(type)) {
            by = new By.ById(value);
        } else if ("className".equalsIgnoreCase(type)) {
            by = new By.ByClassName(value);
        } else if ("cssSelector".equalsIgnoreCase(type)) {
            by = new By.ByCssSelector(value);
        } else if ("linkText".equalsIgnoreCase(type)) {
            by = new By.ByLinkText(value);
        } else if ("name".equalsIgnoreCase(type)) {
            by = new By.ByName(value);
        } else if ("tagName".equalsIgnoreCase(type)) {
            by = new By.ByTagName(value);
        } else if ("partialLinkTex".equalsIgnoreCase(type)) {
            by = new By.ByPartialLinkText(value);
        }
            return by;
        }
    }