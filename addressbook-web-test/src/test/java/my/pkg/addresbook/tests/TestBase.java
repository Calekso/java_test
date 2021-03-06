package my.pkg.addresbook.tests;

import my.pkg.addresbook.appmanager.AppManager;
import my.pkg.addresbook.model.GroupData;
import my.pkg.addresbook.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static final AppManager app
          = new AppManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + "with parametres" + Arrays.asList(p));

  }

  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test " + m.getName());

  }

  public  void verifyGroupListInUI() {
    if (Boolean.getBoolean("verUI")) {
      Groups dbGroups = app.db().groups();
      Groups UIGroups = app.group().all();
      assertThat(UIGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getGroupName()))
              .collect(Collectors.toSet())));
    }
  }

}
