package cc.autotest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// 在本機用Chrome測試。
public class LocalChromeTest {
  private WebDriver webDriver;

  @Before
  public void setUp() {
    ChromeOptions chromeOptions = new ChromeOptions();

    // 指定Chrome driver在檔案系統的位置。不同瀏覽器的property key不一樣。
    System.setProperty("webdriver.chrome.driver", "/home/carter/chromedriver/chromedriver");
    // System.setProperty("webdriver.chrome.driver", "D:\\tmp\\chromedriver_win32_79.0.3945.36\\chromedriver.exe");

    // 指定Chrome瀏覽器在檔案系統的位置。
    chromeOptions.setBinary("/opt/google/chrome/chrome");
    // chromeOptions.setBinary("D:\\tmp\\ChromeTest\\App\\Chrome-bin\\chrome.exe");

    webDriver = new ChromeDriver(chromeOptions);
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
