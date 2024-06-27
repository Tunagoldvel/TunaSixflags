package com.Utills;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Struct;
import java.time.Duration;
import java.util.List;

public interface Element {

    public static Actions actions = new Actions(DriverSetUp.getDriver());



    static WebElement Ele(String identifierType, String identifierValue) {


        DriverSetUp.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return switch (identifierType) {
            case "CLASS_NAME" -> DriverSetUp.getDriver().findElement(By.className(identifierValue));
            case "XPATH" -> DriverSetUp.getDriver().findElement(By.xpath(identifierValue));
            default -> null;
        };
    }

    static List<WebElement> ListEle(String identifierType, String identifierValue) {


        DriverSetUp.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return switch (identifierType) {
            case "ID" -> DriverSetUp.getDriver().findElements(By.id(identifierValue));
            case "XPATH" -> DriverSetUp.getDriver().findElements(By.xpath(identifierValue));
            default -> null;
        };
    }

    public static WebElement waitEle(String identifierType, String identifierValue) {
        WebDriverWait wait = new WebDriverWait(DriverSetUp.getDriver(), Duration.ofSeconds(10));
        return switch (identifierType) {
            case "CLASS_NAME" ->
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(identifierValue)));
            case "XPATH" -> wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(identifierValue)));
            default -> null;
        };
    }


    //passes

    String addOn = "//android.widget.TextView[@text='Add-Ons']";
    String passes = "//android.view.View[@resource-id='auto_Passes']";
    String uploadPasses = "//android.widget.TextView[@text='Upload Your Pass']";
    String manualEntry = "//android.widget.TextView[@text='Enter number manually']";
    String enterPassNum = "//android.widget.EditText[@class='android.widget.EditText']";
    String enterIntoPass = "//android.view.View[@resource-id='auto_Proceed']";
    String lastname = "(//android.widget.EditText[@class='android.widget.EditText'])[2]";
    String tryAgain = "//android.widget.TextView[@text='Try Again']";
    String continueToPark = "//android.widget.TextView[@text='Continue to Park']";
    String PassCount = " (//android.widget.TextView[@index='0'])[3]";
    String passNumber = "(//android.widget.TextView[@index=\"2\"])";
    String benefits = "//android.widget.TextView[@text=\"Benefits\"]";

    String Delete = "//android.widget.TextView[starts-with(@text, 'Remove')]";
    String confirmDelete = "//android.widget.TextView[@text='OK']";
    String acceptDelete = "//android.widget.Button";
    String lookUp = "//android.widget.TextView[@text='Look Up with Email and Phone']";
    String email = "//android.view.View[@resource-id='auto_Email']/android.widget.EditText";
    String phoneNum = "//android.view.View[@resource-id='auto_PhoneNumber']/android.widget.EditText";
    String lookUpPass = "//android.widget.TextView[@text=\"Look Up Pass\"]";
    String selPass = "(//android.view.View[@resource-id=\"auto_Pass\"])[3]/android.view.View";
    String addPass = "//android.widget.TextView[@text='Added']";
    String continueTo = "//android.widget.TextView[@text='Continue to Park']";
    String confirmPass = "//android.widget.TextView[@text=\"Confirm Your Pass\"]";
    String close = "//android.view.View[@index='1']";
    String errorInfo = "//android.widget.TextView[@index='7']";


    //Dining
String resName ="//android.view.View[@resource-id=\"auto_RestaurantPreview\"]";
    String diningTab = "//android.view.View[@resource-id='auto_Dining']";
    String addToCartBtn = "//android.widget.TextView[starts-with(@text,'Add to cart for')]";
    String doubleBaconCheeseburger = "//android.widget.TextView[@text='Double Bacon Cheeseburger']";
    String itemCheckBox1 = "(//android.widget.CheckBox[@resource-id=\"auto_ItemCheckBox\"])[1]";
    String itemCheckBox2 = "(//android.widget.CheckBox[@resource-id='auto_ItemCheckBox'])[2]";
    String itemCheckBox3 = "(//android.widget.CheckBox[@resource-id='auto_ItemCheckBox'])[3]";
    String itemCheckBox4 = "(//android.widget.CheckBox[@resource-id='auto_ItemCheckBox'])[4]";

    String radioButton1 = "(//android.widget.RadioButton[@resource-id='auto_OptionSelect'])[1]";
    String radioButton2 = "(//android.widget.RadioButton[@resource-id='auto_OptionSelect'])[2]";
    String radioButton3 = "(//android.widget.RadioButton[@resource-id='auto_OptionSelect'])[3]";
    String radioButton4 = "(//android.widget.RadioButton[@resource-id='auto_OptionSelect'])[4]";


    String add = "//android.view.View[@resource-id='auto_Plus']";
    String decrease = "//android.view.View[@resource-id='auto_Minus']";
    String CustomizeItem = "//android.widget.TextView[@text=\"Customize Item\"]";
    String update = "//android.widget.TextView[@text=\"Update\"]";
    String waterBottle = "//android.widget.TextView[@text=\"All Day Drink Bottle\"]";
    String Cheeseburger = "//android.widget.TextView[@text=\"Cheeseburger\"]";
    String blackBeanBurger = "//android.widget.TextView[@resource-id=\"auto_MenuTitle\" and @text=\"Black Bean Burger\"]";
    String mobOrder = "//android.widget.TextView[@text='Offers Mobile Ordering']/following-sibling::android.view.View[1]";
    String dinningPass = "//android.widget.TextView[@text='Dining Pass']/following-sibling::android.view.View[1]";
    String allAmericanCafe = "//android.widget.TextView[@resource-id=\"auto_RestaurantTitle\" and @text=\"All American Cafe\"]";
    String viewMenu = "//android.widget.TextView[@text=\"View Menu\"]";
    String viewCart = "//android.widget.TextView[starts-with(@text,'View Cart')]";
    String reviewOrder = "//android.widget.TextView[@text=\"Review Your Order\"]";
    String selCC = "//android.widget.TextView[@text=\"Credit or Debit Card\"]";
    String continueBtn = "//android.widget.TextView[@text=\"Continue to Payment\"]";
    String grandTotal = "//android.widget.TextView[@resource-id=\"auto_GrandTotal\"]";
    String orderID = "//android.widget.TextView[@resource-id=\"auto_Title\"]";
    String orderTotal = "//android.widget.TextView[@resource-id=\"auto_GrandTotal\"]";
    String viewMyOrder = "//android.widget.TextView[starts-with(@text,'View')]";
    String getDir = "//android.widget.TextView[starts-with(@text,'Get')]";



    //Map


    //Parks

    //Home


}


