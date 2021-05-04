package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RgistrationHelper {
    private final AppManager app;
    private WebDriver wd;

    public RgistrationHelper(AppManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
    }
}
