package com.StepDefinition;

import com.pages.Passes;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;

public class AddPasses extends Passes {


    public AddPasses(AppiumDriver driver) {
        super(driver);
    }

    @Given("User click on Passes")
    public void userClickOnPasses() throws InterruptedException {
        Reporter.log("User click on Passes");
        clickPasses();

    }

    @When("User clicks on Upload Passes")
    public void userClicksOnUploadPasses() {
        Reporter.log("User click on Passes");
        clickUploadPasses();
    }

    @When("User clicks on Enter Manually")
    public void userClicksOnEnterManually() {
        Reporter.log("User click on Passes");
        clickEnterManually();
    }

    @When("User enter the valid PassNumber {string}")
    public void userEnterTheValidPassNumber(String PassNumber) {



    }

    @And("User enter the invalid  PassNumber {string}")
    public void userEnterTheInvalidPassNumber(String PassNumber) {
        Reporter.log("User click on Passes");
        enterPassNumber(PassNumber);
        clickEnterIntoPass();
    }


    @When("User enter the invalid Lastname {string}")
    public void userEnterTheInvalidLastname(String Lastname) {
        Reporter.log("User click on Passes");
        clickEnterLastName(Lastname);
    }

    @And("User enter the valid Lastname {string}")
    public void userEnterTheValidLastname(String Lastname) {
    }

    @When("User clicks on Confirm your Pass")
    public void userClicksOnConfirmYourPass() {
        Reporter.log("User click on Passes");
        clickConfirmYourPasses();

    }

    @When("Toast message is Display")
    public void toastMessageIsDisplay() {
        Reporter.log("User click on Passes");
        getToastMessage();
    }

    @Then("verify the Toast message")
    public void verifyTheToastMessage() {
        Reporter.log("User click on Passes");
        verifyToastMessage();
    }


}
