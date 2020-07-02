package cc.autotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class AppTest3 {
  
  private String testHost = "https://gae2-weichou99.an.r.appspot.com/";

  private WebDriver webDriver;

  @Before
  public void setUp() throws MalformedURLException {
//    OperaOptions chromeOptions = new OperaOptions();
//    FirefoxOptions chromeOptions = new FirefoxOptions();
    ChromeOptions chromeOptions = new ChromeOptions();
    webDriver = new RemoteWebDriver(new URL("http://192.168.43.195:4444/wd/hub"), chromeOptions);
  }

  @After
  public void tearDown() {
    if (webDriver != null) {
      webDriver.quit();
    }
  }

  @Test
  public void iii10() throws InterruptedException {
    webDriver.get(testHost);
    Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
    webDriver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定"));
  }

  @Test
  public void iii11() throws MalformedURLException {
    webDriver.get(testHost);
    webDriver.findElement(By.cssSelector(".btn:nth-child(11)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("商品查詢預覽"));
  }

  @Test
  public void iii12() throws MalformedURLException {
    webDriver.get(testHost);
    webDriver.findElement(By.cssSelector(".btn:nth-child(12)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("預覽保單"));
  }

  @Test
  public void iii13() throws MalformedURLException {
    webDriver.get(testHost);
    webDriver.findElement(By.cssSelector(".btn:nth-child(13)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("預覽頁面"));
  }

  @Test
  public void iii14() throws MalformedURLException {
    webDriver.get(testHost);
    webDriver.findElement(By.cssSelector(".btn:nth-child(14)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("預覽頁面"));
  }

}
