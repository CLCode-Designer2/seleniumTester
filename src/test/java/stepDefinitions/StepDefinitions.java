package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;


    @Given ("I have used {string} as a browser")
    public void i_have_used_chosen_a_browser(String browser) {
        DriveCreator creator = new DriveCreator();
        driver = creator.createBrowser(browser);
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php"); //Navigate web service
        driver.manage().window().maximize();
        driver.manage().timeouts ().pageLoadTimeout (15, TimeUnit.SECONDS); //Max (15) for page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Max (30) seconds for all elements

    }

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_70_into_the_calculator(Integer int1) throws InterruptedException {

        WebElement input1 = driver.findElement (By.cssSelector ("input[name = 'n01']")); //Find web element
        //input1.sendKeys (Integer.toString (int1)); //Input first number to element
        sendKeys (driver, input1, 3, Integer.toString (int1)); //Max time (3) seconds to enter first integer
    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_50_into_the_calculator(Integer int2) throws InterruptedException {

        WebElement input2 = driver.findElement (By.cssSelector ("input[name = 'n02']")); //Find web element
        //input2.sendKeys (Integer.toString (int2)); //Input second number to element
        sendKeys (driver, input2, 3, Integer.toString (int2)); //Max time (3) seconds to enter second integer
    }

    @When("I press add")
    public void i_press_add() throws InterruptedException {
        //WebElement addButton = driver.findElement(By.cssSelector ("input[type = 'button']"));
        //addButton.click ();

        click (driver, By.cssSelector ("input[type = 'button']")); //Max time (10) seconds for button click

        List<WebElement> elements = driver.findElements (By.tagName ("input")); //List all webElements with tagName 'input'

        for (WebElement e : elements) {
            System.out.println (e.getAttribute ("name"));
        }
    }

    @Then("the result should be {int} on the screen")
    public void the_result_should_be_120_on_the_screen(Integer result) throws InterruptedException {
        WebElement calcResult = driver.findElement (By.cssSelector ("input[name = 'answer']"));
        int actual = Integer.parseInt (calcResult.getAttribute ("value")); //Assign result from web service to variable
        int expected = result; //Assign result to a variable
        Assertions.assertEquals (expected, actual); //Compare expected result to actual result
        driver.close (); //Close web service
    }

    public void click (WebDriver driver, By by) {

        new WebDriverWait (driver, 10).until (ExpectedConditions.elementToBeClickable (by));
        driver.findElement (by).click ();
    }

    public void sendKeys (WebDriver driver, WebElement element, int timeout, String value) {

        new WebDriverWait (driver, 10).until (ExpectedConditions.visibilityOf (element));
        element.sendKeys (value);
    }
}

