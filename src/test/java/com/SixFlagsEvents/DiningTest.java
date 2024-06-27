package com.SixFlagsEvents;

import com.Utills.DriverSetUp;

import com.Utills.Element;
import com.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DiningTest extends BasePage {


    public DiningTest() {
        super(driver);
    }

    public static void selectDining() throws Throwable {
        scrollRatio(ScrollDirection.DOWN, 0.5);
        WebElement diningTab = Element.waitEle("XPATH", Element.diningTab);
        tapEle(diningTab);

    }

    public static void MOFilter() throws Throwable {
        Thread.sleep(500);
        WebElement mobOrder = Element.waitEle("XPATH", Element.mobOrder);
        tapEle(mobOrder);
        Thread.sleep(500);
        WebElement dinningPass = Element.Ele("XPATH", Element.dinningPass);
        tapEle(dinningPass);
        Thread.sleep(500);
    }
    public static void addAndViewCart() throws Exception {


        WebElement viewCart = Element.Ele("XPATH", Element.viewCart);
        tapEle(viewCart);
        Thread.sleep(5000);
        if( Element.Ele("XPATH", Element.tryAgain).isDisplayed()){
            Element.Ele("XPATH", Element.tryAgain).click();
            Thread.sleep(25000);
        }

        Thread.sleep(10000);
        WebElement reviewOrder = Element.Ele("XPATH", Element.reviewOrder);
        tapEle(reviewOrder);
        WebElement continueBtn = Element.Ele("XPATH", Element.continueBtn);
        tapEle(continueBtn);
        Thread.sleep(10000);
    }
    public static void ccPayment() throws Exception {
        Actions action = new Actions(DriverSetUp.getDriver());
        String cc = DriverSetUp.getProp().getProperty("ccNumber");
        String exp =  DriverSetUp.getProp().getProperty("ccExp");
        String zip =  DriverSetUp.getProp().getProperty("ccPin");
        Thread.sleep(7000);
        WebElement selCC = Element.Ele("XPATH", Element.selCC);
        selCC.isDisplayed();
        tapEle(selCC);
        action.sendKeys(Keys.ENTER).sendKeys(cc).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(exp)
                .sendKeys(zip).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
        action.sendKeys(Keys.HOME).build().perform();
        Thread.sleep(500);
    }
    public static void verifyPrize() {
        WebElement grandTotal = Element.Ele("XPATH", Element.grandTotal);
        String total = grandTotal.getAttribute("text");
        System.out.println(total);
        WebElement orderID = Element.Ele("XPATH", Element.orderID);
        String OrderID = orderID.getAttribute("text");
        System.out.println(OrderID);
        WebElement orderTotal = Element.Ele("XPATH", Element.orderTotal);
        String total1 = orderTotal.getAttribute("text");
        System.out.println(total1);
        if (total.equalsIgnoreCase(total1)) {
            System.out.println("Total Confirmed and Test Pass");
        } else {
            System.out.println("Total Miss Match and Test Fail");
        }

    }
    public static void afterOrder() throws Throwable {
        Thread.sleep(5000);

        WebElement grandTotal = Element.Ele("XPATH", Element.grandTotal);
        String total = grandTotal.getAttribute("text");
        System.out.println(total);
        WebElement viewMyOrder = Element.Ele("XPATH", Element.viewMyOrder);
        viewMyOrder.isDisplayed();
        tapEle(viewMyOrder);
        WebElement orderID = Element.Ele("XPATH", Element.orderID);
        String OrderID = orderID.getAttribute("text");
        System.out.println(OrderID);
        WebElement orderTotal = Element.Ele("XPATH", Element.orderTotal);
        String total1 = orderTotal.getAttribute("text");
        System.out.println(total1);
        if (total.equalsIgnoreCase(total1)) {
            System.out.println("Total Confirmed and Test Pass");
        } else {
            System.out.println("Total Miss Match and Test Fail");
        }

        Thread.sleep(5000);
        WebElement getDir = Element.Ele("XPATH", Element.getDir);
        getDir.isDisplayed();
        tapEle(getDir);

    }



    public static void AllAmericanCafe() throws Throwable {
        DiningTest.selectDining();
        Thread.sleep(5000);
        MOFilter();
        Thread.sleep(2000);
        scrollRatio(ScrollDirection.DOWN, 0.5);
        Thread.sleep(2000);
        WebElement allAmericanCafe=Element.Ele("XPATH", Element.allAmericanCafe);
        allAmericanCafe.isDisplayed();
        WebElement viewMenu = Element.waitEle("XPATH", Element.viewMenu);
        tapEle(viewMenu);
        Thread.sleep(7000);

        Menu.DoubleBaconCheeseBurger();
        Menu.addToCart();
        addAndViewCart();
        ccPayment();
        verifyPrize();
        afterOrder();



    }

}
