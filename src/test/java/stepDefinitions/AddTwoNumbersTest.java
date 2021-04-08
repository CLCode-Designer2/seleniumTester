package stepDefinitions;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class AddTwoNumbersTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    DriveCreator creator = new DriveCreator ();
    driver = creator.createBrowser ("chrome");
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addTwoNumbers() {
    driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
    driver.manage().window().setSize(new Dimension(1271, 770));
    driver.findElement(By.name("n01")).sendKeys("50");
    driver.findElement(By.name("n01")).sendKeys("50");
    driver.findElement(By.name("n02")).sendKeys("70");
    driver.findElement(By.cssSelector("p:nth-child(4) > input")).click();
    driver.findElement(By.cssSelector("form > p:nth-child(6)")).click();
    {
      String value = driver.findElement(By.name("answer")).getAttribute("value");
      assertThat(value, is("5120"));
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 3);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("answer")));
    }
    driver.close();
  }
}
