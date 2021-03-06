package ru.stqa.pft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.AppManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final AppManager app
          = new AppManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"),
            "/config/config_inc.php",
            "/config/config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("/config/config_inc.php.bak", "/config/config_inc.php");
    app.stop();
  }

  public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = app.soap().getMantisConnect();
    IssueData issueData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
    int resolution = issueData.getResolution().getId().intValue();
    if (resolution == 20)
      return false;
    else
      return true;
  }


  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      System.out.println("Test blocked by issue " + issueId);
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
