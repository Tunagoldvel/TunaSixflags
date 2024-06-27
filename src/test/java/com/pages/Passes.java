package com.pages;

import com.Utills.DriverSetUp;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Passes extends BasePage {



    @AndroidFindBy(xpath = "//android.view.View[@resource-id='auto_Passes']")
    public WebElement passes;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload Your Pass']")
    // @iOSFindBy(xpath = )
    public WebElement uploadPasses;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter number manually']")
    // @iOSFindBy(xpath = )
    public WebElement manualEntry;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Something went wrong']/android.widget.TextView")
    // @iOSFindBy(xpath = )
    public WebElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@class='android.widget.EditText']")
    // @iOSFindBy(xpath = )
    public WebElement enterPassNum;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='auto_Proceed']")
    // @iOSFindBy(xpath = )
    public WebElement enterIntoPass;
    @AndroidFindBy(xpath = "(//android.widget.EditText[@class='android.widget.EditText'])[2]")
    // @iOSFindBy(xpath = )
    public WebElement lastname;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Confirm Your Pass\"]")
    // @iOSFindBy(xpath = )
    public WebElement confirmPass;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Try Again']")
    // @iOSFindBy(xpath = )
    public WebElement tryAgain;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue to Park']")
    // @iOSFindBy(xpath = )
    public WebElement continueToPark;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    // @iOSFindBy(xpath = )
    public WebElement close;



    public WebElement getPasses() {
        return getPasses();
    }

    @Test
    public void clickPasses() throws InterruptedException {
        Thread.sleep(5000);
        scrollRatio(ScrollDirection.DOWN, 0.5);
        click(getPasses());


    }


    public void clickUploadPasses() {
        click(uploadPasses);
    }


    public void clickEnterManually() {
        click(manualEntry);

    }

    public void enterPassNumber(String passNumber) {
        sentKeys(enterPassNum, passNumber);

    }

    public void clickEnterIntoPass() {
        click(enterIntoPass);

    }

    public void clickEnterLastName(String lastName) {
        sentKeys(lastname, lastName);

    }

    public void clickConfirmYourPasses() {
        hideKeyBoard();
        click(confirmPass);
    }

    public void getToastMessage() {
        String txt = getAttribute(errorMessage, "text");
        System.out.println(txt);
    }

    public void verifyToastMessage() {
        String errorInfo = DriverSetUp.getProp().getProperty("InvalidMediaNumberAndLastNameErrorText");

        String txt = getAttribute(errorMessage, "text");

        if (errorMessage.isDisplayed()) {
            Assert.assertEquals(errorInfo, txt, "Invalid Pass Media number and Last Name");
            click(tryAgain);
        }
        Assert.assertEquals(errorInfo, txt, "Invalid Pass Media number and Last Name");
    }


}
