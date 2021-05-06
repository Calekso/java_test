package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RgistrationHelper extends HelperBase {

    public RgistrationHelper(AppManager app)  {
        super(app);
    }

    public void start(String username, String email) {
            wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
            type(By.name("username"),(username));
            type(By.name("email"), email);
            click(By.xpath("//input[@type='submit']"));

    }

    public void finish(String confirmationLink, String password)  {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//button[@type='submit']"));

    }
}
