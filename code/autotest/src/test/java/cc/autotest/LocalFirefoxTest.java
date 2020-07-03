package cc.autotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//在本機用Firefox測試。
public class LocalFirefoxTest {
  private WebDriver webDriver;

  @Before
  public void setUp() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();

    // 指定Firefox driver在檔案系統的位置。不同瀏覽器的property key不一樣。
    System.setProperty("webdriver.gecko.driver", "/home/carter/geckodriver/geckodriver");
    // System.setProperty("webdriver.gecko.driver", "D:\\tmp\\geckodriver-v0.26.0-win64\\geckodriver.exe");

    // 指定Firefox瀏覽器在檔案系統的位置。
    firefoxOptions.setBinary("/usr/lib/firefox/firefox.sh");
    // firefoxOptions.setBinary("D:\\tmp\\FirefoxPortable\\App\\Firefox64\\firefox.exe");

    webDriver = new FirefoxDriver(firefoxOptions);
  }

  @After
  public void tearDown() {
    webDriver.quit();
  }

  @Test
  public void titleTest() {
    webDriver.get("https://gae2-weichou99.an.r.appspot.com/");
    webDriver.findElement(By.cssSelector(".btn:nth-child(10)")).click();
    assertThat(webDriver.findElement(By.cssSelector(".fade")).getText(), is("商品面頁設定"));
  }
}
