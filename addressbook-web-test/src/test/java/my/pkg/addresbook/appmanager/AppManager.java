package my.pkg.addresbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {
    private final Properties properties;
    public WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;
    private DbHelper dbHelper;

    public AppManager(String browser) {
        this.browser = browser;
        properties = new Properties();
       }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper();

        if("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IEXPLORE)) {
                wd = new InternetExplorerDriver();
            } else {
                System.out.println("Unknown browser, use FireFox");
                wd = new FirefoxDriver();
            }
        } else {
            System.setProperty("webdriver.chrome.driver", "C://Windows/System32/chromedriver.exe");
            DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
            //capabilities.setBrowserName("chrome");
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);

        }

        wd.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"), properties.getProperty("web.baseURL"));

    }


    public void stop() {
        sessionHelper.clickElem(By.linkText("Logout"));
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }




    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public DbHelper db(){
        return dbHelper;
    }
}
