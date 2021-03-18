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
import org.openqa.selenium.interactions.Actions;

public class StepDefinitions {

    private WebDriver driver;


    @Given("I have entered {int} into the calculator")
    public void i_have_entered_70_into_the_calculator(Integer int1) throws InterruptedException {
        System.setProperty ("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver (); //Start Chrome
        driver.manage().window().maximize();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php"); //Navigate web service
        Thread.sleep(3000);  //Hold open for (3) seconds
        WebElement input1 = driver.findElement (By.name ("n01")); //Find web element
        input1.sendKeys (Integer.toString (int1)); //Input first number to element
    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_50_into_the_calculator(Integer int2) throws InterruptedException {
        WebElement input2 = driver.findElement (By.name ("n02")); //Find web element
        input2.sendKeys (Integer.toString (int2)); //Input second number to element
    }

    @When("I press add")
    public void i_press_add() throws InterruptedException {
        WebElement addButton = driver.findElement(By.xpath ("/html/body/table/tbody/tr/td[1]/table[2]/tbody/" +
                           "tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        addButton.click ();
    }

    @Then("the result should be {int} on the screen")
    public void the_result_should_be_120_on_the_screen(Integer result) throws InterruptedException {
        WebElement calcResult = driver.findElement (By.name ("answer"));
        int actual = Integer.parseInt (calcResult.getAttribute ("value")); //Assign result from web service to variable
        int expected = result; //Assign result to a variable
        Assertions.assertEquals (expected, actual); //Compare expected result to actual result
        driver.close (); //Close web service
    }


}

