package com.SixFlagsEvents;

import com.Utills.DriverSetUp;
import com.Utills.Element;
import com.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddPassTest extends BasePage {


    public AddPassTest() {

    }
    @AndroidBy(xpath = "//android.view.View[@resource-id='auto_Passes']")
    public static WebElement passes;


    public static void addpasses() throws InterruptedException {
        //  scrollRatio( ScrollDirection.DOWN, 0.5);
        Thread.sleep(5000);
        scrollRatio(ScrollDirection.DOWN, 0.5);
        Thread.sleep(1000);
        // WebElement passes = Element.Ele("XPATH", Element.passes);
        //  tapEle(passes1);
        passes.click();
        DriverSetUp.closeApp();
    }

    public static void uploadPasses() {
        WebElement uploadPasses = Element.Ele("XPATH", Element.uploadPasses);
        tapEle(uploadPasses);
    }

    public static void manualEntry() {
        WebElement manualEntry = Element.Ele("XPATH", Element.manualEntry);
        tapEle(manualEntry);
    }

    public static void validPassDetails() throws InterruptedException {
        String mediaNumber = DriverSetUp.getProp().getProperty("vPass");
        String lastName = DriverSetUp.getProp().getProperty("vLastName");
        System.out.println(mediaNumber);
        System.out.println(lastName);
        WebElement enterPassNum = Element.Ele("XPATH", Element.enterPassNum);
        tapEle(enterPassNum);
        Thread.sleep(500);
        enterPassNum.sendKeys(mediaNumber);
        Thread.sleep(500);

        WebElement enterIntoPass = Element.Ele("XPATH", Element.enterIntoPass);
        tapEle(enterIntoPass);
        WebElement lastname = Element.Ele("XPATH", Element.lastname);
        tapEle(lastname);
        Thread.sleep(1000);
        Element.actions.sendKeys(lastName).build().perform();
        hideKeyBoard();
        WebElement confirmPass = Element.Ele("XPATH", Element.confirmPass);
        tapEle(confirmPass);
        Thread.sleep(5000);

    }

    public static void invalidPassDetails() throws InterruptedException {
        String mediaNumber = DriverSetUp.getProp().getProperty("ivPass");
        String lastName = DriverSetUp.getProp().getProperty("ivLastName");
        System.out.println(mediaNumber);
        System.out.println(lastName);
        WebElement enterPassNum = Element.Ele("XPATH", Element.enterPassNum);
        tapEle(enterPassNum);
        Thread.sleep(500);
        enterPassNum.sendKeys(mediaNumber);
        Thread.sleep(500);

        WebElement enterIntoPass = Element.Ele("XPATH", Element.enterIntoPass);
        tapEle(enterIntoPass);
        WebElement lastname = Element.Ele("XPATH", Element.lastname);
        tapEle(lastname);
        Thread.sleep(1000);
        Element.actions.sendKeys(lastName).build().perform();
        hideKeyBoard();
        WebElement confirmPass = Element.Ele("XPATH", Element.confirmPass);
        tapEle(confirmPass);
        Thread.sleep(5000);

    }

    public static void tryAgain() {
        WebElement tryAgain = Element.Ele("XPATH", Element.tryAgain);

    }

    public static void errorInfo() {
        WebElement errorInfo = Element.Ele("XPATH", Element.errorInfo);
        String errorMessage = errorInfo.getAttribute("text");
        System.out.println(errorMessage);
    }

    public static void continueToPark() throws Throwable {
        Thread.sleep(5000);
        WebElement continueToPark = Element.Ele("XPATH", Element.continueToPark);
        tapEle(continueToPark);
    }

    public static void status() throws Throwable {
        WebElement tryAgain = DriverSetUp.getDriver().findElement(By.xpath(Element.tryAgain));
        WebElement close = DriverSetUp.getDriver().findElement(By.xpath(Element.close));
        while (!tryAgain.isDisplayed()) {
            continueToPark();
        }
        tryAgain.click();
        ;
        close.click();
    /*    WebElement tryAgain = Element.Ele("XPATH", Element.tryAgain);
        WebElement close = Element.Ele("XPATH", Element.close);
        if (!tryAgain.isDisplayed()) {
            continueToPark();
        } else {
            tryAgain.click();
            close.click();

        }

     */
    }


    private static void AddPassesManualEntry() throws Throwable {
        WebElement addOn = Element.Ele("XPATH", Element.addOn);
        addOn.isDisplayed();
        Thread.sleep(500);
        scrollRatio(ScrollDirection.DOWN, 0.5);
        Thread.sleep(500);
        scrollRatio(ScrollDirection.UP, 0.5);
        Thread.sleep(500);
        addpasses();
        uploadPasses();
        manualEntry();
        //passDetails();

        Thread.sleep(5000);
        WebElement tryAgain = Element.Ele("XPATH", Element.tryAgain);
        WebElement close = Element.Ele("XPATH", Element.close);
        if (tryAgain.isDisplayed()) {
            tryAgain.click();
            close.click();
        } else {
            continueToPark();
        }
    }

    public static void passNumber() {
        WebElement PassNumber = Element.Ele("XPATH", Element.passNumber);

        System.out.println("Pass Count -" + PassNumber.getAttribute("text"));

    }

    public static void benefits() {
        WebElement benefits = Element.Ele("XPATH", Element.benefits);
        tapEle(benefits);
    }

    public static void passCount() {
        WebElement PassCount = Element.Ele("XPATH", Element.PassCount);

        System.out.println("Pass Count -" + PassCount.getAttribute("text"));
    }

    public static void verifyPassNumber() {
        WebElement PassNumber = Element.Ele("XPATH", Element.passNumber);

        System.out.println("Pass Number -" + PassNumber.getAttribute("text"));

    }

    public static void deletePassDetails() throws Throwable {
        Thread.sleep(2000);
        scrollRatio(ScrollDirection.DOWN, 0.5);
        Thread.sleep(2000);
        scrollRatio( ScrollDirection.DOWN, 0.5);
        WebElement Delete = Element.Ele("XPATH", Element.Delete);
        tapEle(Delete);
        WebElement confirmDelete = Element.Ele("XPATH", Element.confirmDelete);
        tapEle(confirmDelete);
        Thread.sleep(2000);
        WebElement acceptDelete = Element.Ele("XPATH", Element.acceptDelete);
        tapEle(acceptDelete);
    }

    public static void deletePasses() throws Throwable {

        WebElement PassCount = Element.Ele("XPATH", Element.PassCount);

        tapEle(PassCount);
        WebElement Benefits = Element.Ele("XPATH", Element.benefits);
        tapEle(Benefits);
        Thread.sleep(5000);
        scroll();
        Thread.sleep(5000);
        scroll();
        WebElement Delete = Element.Ele("XPATH", Element.Delete);
        tapEle(Delete);
        WebElement confirmDelete = Element.Ele("XPATH", Element.confirmDelete);
        tapEle(confirmDelete);
        Thread.sleep(2000);
        WebElement acceptDelete = Element.Ele("XPATH", Element.acceptDelete);
        tapEle(acceptDelete);
    }


    public static void addPassesLookUp() throws Throwable {
        WebElement passes = Element.Ele("XPATH", Element.passes);
        tapEle(passes);
        WebElement uploadPasses = Element.Ele("XPATH", Element.uploadPasses);
        tapEle(uploadPasses);
        String emailID = DriverSetUp.getProp().getProperty("vEmail");
        String phone = DriverSetUp.getProp().getProperty("vPhoneNumber");
        WebElement lookUp = Element.Ele("XPATH", Element.lookUp);
        tapEle(lookUp);
        Thread.sleep(500);
        WebElement email = Element.Ele("XPATH", Element.email);
        Thread.sleep(500);
        email.sendKeys(emailID);
        WebElement phoneNum = Element.Ele("XPATH", Element.phoneNum);
        Thread.sleep(500);
        phoneNum.sendKeys(phone);
        Thread.sleep(500);
        // Element.actions.sendKeys(Keys.TAB).build().perform();
        Thread.sleep(500);
        WebElement lookUpPass = Element.Ele("XPATH", Element.lookUpPass);
        lookUpPass.click();
        WebElement tryAgain = Element.Ele("XPATH", Element.tryAgain);
        WebElement close = Element.Ele("XPATH", Element.close);
        if (tryAgain.isDisplayed()) {
            tryAgain.click();
            close.click();
        } else {
            Thread.sleep(500);
            WebElement selPass = Element.Ele("XPATH", Element.selPass);
            tapEle(selPass);
            Thread.sleep(500);
            WebElement addPass = Element.Ele("XPATH", Element.addPass);
            System.out.println(addPass);
            WebElement continueTo = Element.Ele("XPATH", Element.continueTo);
            tapEle(continueTo);
        }
    }

}
