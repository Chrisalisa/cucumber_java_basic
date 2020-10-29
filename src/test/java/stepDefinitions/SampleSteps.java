package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the github home page$")
        public void iAmOnGitHub() throws Throwable{
            driver.get("https://github.com/");
        }
    @Then("^I should see the home page title$")
    public void iShouldSeeHomePageHeaderGitHub() throws Throwable {
        assertEquals("GitHub: Where the world builds software · GitHub",
                driver.getTitle());
    }
    @And("^I should see the home page description$")
    public void iShouldSeeTheHomePageDescription() {
        WebElement description=driver.findElement(By.cssSelector("p.lead-mktg:nth-child(2)"));
        assertEquals("GitHub is a development platform inspired by the way you work. From open source to business," +
                " you can host and review code, manage projects, and build software alongside " +
                "50 million developers.", description.getText());
    }
    @And("^I should see sign up button$")
    public void iShouldSeeSignUpButton() throws Exception {
        try{
            WebElement button= driver.findElement(By.cssSelector("button.btn-mktg:nth-child(12)"));
        }catch(Exception e){
            fail();
        }

    }
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }
    @Given("^I am on the math page$")
    public void iAmOnMath() throws Throwable{
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^I enter: \"([^\"]*)\"$")
    public void iEnter(String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement inputBox=driver.findElement(By.id("numb"));
        inputBox.sendKeys(value);
    }


    @And("^I click the result button$")
    public void iClickTheResultButton() {
        WebElement submitButton=driver.findElement(By.cssSelector(".w3-btn"));
        submitButton.click();
    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement errorMessage=driver.findElement(By.id("ch1_error"));
        assertEquals(arg0, errorMessage.getText());
    }



    @Then("^I see the math message: \"([^\"]*)\"$")
    public void iSeeTheMathMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Alert info=driver.switchTo().alert();
        assertEquals(arg0, info.getText());
    }
}
