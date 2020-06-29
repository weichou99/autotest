package cc.autotest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AppTest {
  private WebDriver firefoxDriver;
  private WebDriver chromeDriver;
  @Before
  public void setUp() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    ChromeOptions chromeOptions = new ChromeOptions();

//    System.setProperty("webdriver.gecko.driver", "D:\\tmp\\geckodriver-v0.26.0-win64\\geckodriver.exe");
//    System.setProperty("webdriver.chrome.driver", "D:\\tmp\\chromedriver_win32_79.0.3945.36\\chromedriver.exe");
//    chromeOptions.setBinary("D:\\tmp\\ChromeTest\\App\\Chrome-bin\\chrome.exe");
//    firefoxOptions.setBinary("D:\\tmp\\FirefoxPortable\\App\\Firefox64\\firefox.exe");

    System.setProperty("webdriver.gecko.driver", "/home/carter/geckodriver/geckodriver");
    System.setProperty("webdriver.chrome.driver", "/home/carter/chromedriver/chromedriver");
    chromeOptions.setBinary("/opt/google/chrome/chrome");
    firefoxOptions.setBinary("/usr/lib/firefox/firefox.sh");
    
    //firefoxOptions.setBinary("/usr/lib64/firefox/firefox");
    firefoxDriver = new FirefoxDriver(firefoxOptions);
    chromeDriver = new ChromeDriver(chromeOptions);
  }
  @After
  public void tearDown() {
    firefoxDriver.quit();
    chromeDriver.quit();
  }
  @Test
  public void iii() {
    firefoxDriver.get("https://gae2-weichou99.an.r.appspot.com/");
    firefoxDriver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
    assertThat(firefoxDriver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定x"));
  }
  @Test
  public void iii2() {
    chromeDriver.get("https://gae2-weichou99.an.r.appspot.com/");
    chromeDriver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
    assertThat(chromeDriver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定"));
  }
}
