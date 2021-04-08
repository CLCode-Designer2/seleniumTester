package stepDefinitions;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class TestingAstronet {
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
    public void astronetPictureSearch() {
        driver.get("http://astronet.se/");
        driver.manage().window().setSize(new Dimension(1300, 800));
        driver.findElement(By.linkText("Bildgalleriet")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1) .spiffyfg")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1) img")).click();



        List<WebElement> elements = driver.findElements(By.cssSelector ("[href]")); //List all webElements with cssSelector 'input'

        int counter = 0;

        for (WebElement e : elements) {
            counter++;
            System.out.println (e.getText ());
        }
        System.out.println ("The links that exist are: " + counter);

        driver.close ();
    }
}





