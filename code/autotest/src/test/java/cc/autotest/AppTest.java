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
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    //D:\tmp\geckodriver-v0.26.0-win64\geckodriver.exe
    System.setProperty("webdriver.gecko.driver", "D:\\tmp\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setBinary("/usr/lib64/firefox/firefox");
    //firefoxOptions.setBinary("D:\\tmp\\FirefoxPortable\\App\\Firefox64\\firefox.exe");
    driver = new FirefoxDriver(firefoxOptions);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void iii() {
    driver.get("https://gae2-weichou99.an.r.appspot.com/");
    driver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
    assertThat(driver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定x"));
  }
}
