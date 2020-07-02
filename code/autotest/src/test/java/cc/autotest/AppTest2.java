package cc.autotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppTest2 {
  private WebDriver WebDriver;

  @Before
  public void setUp() throws MalformedURLException {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

  }

  @After
  public void tearDown() {
    if (WebDriver != null) {
      WebDriver.quit();
    }
  }

  @Test
  public void iii() {
    if (WebDriver != null) {
      WebDriver.get("https://gae2-weichou99.an.r.appspot.com/");
      WebDriver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
      assertThat(WebDriver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定"));
    }
  }

}
