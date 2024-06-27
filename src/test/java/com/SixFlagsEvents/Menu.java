package com.SixFlagsEvents;


import com.Utills.Element;
import com.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class Menu extends BasePage {



    public static void increase(int count) {
        for (int i = 0; i < count; i++) {
            WebElement increaseQty = Element.Ele("XPATH", Element.add);
            increaseQty.click();
        }
    }

    public static void decrease(int count) {
        for (int i = 0; i < count; i++) {
            WebElement decrease = Element.Ele("XPATH", Element.decrease);
            decrease.click();
        }
    }

    public static void addToCart() {
         scrollRatio( ScrollDirection.DOWN, 0.1);
        WebElement addToCartBtn = Element.Ele("XPATH", Element.addToCartBtn);
         tapEle(addToCartBtn);
    }

    public static void DoubleBaconCheeseBurger() throws Throwable {

        WebElement doubleBaconCheeseburger = Element.Ele("XPATH", Element.doubleBaconCheeseburger);
        doubleBaconCheeseburger.isDisplayed();
         tapEle(doubleBaconCheeseburger);

        WebElement extra1 = Element.Ele("XPATH", Element.itemCheckBox1);
         tapEle(extra1);
        Thread.sleep(500);
         scrollRatio( ScrollDirection.DOWN, 0.5);
        Thread.sleep(500);
        WebElement radioButton1 = Element.Ele("XPATH", Element.radioButton1);
         tapEle(radioButton1);
        Thread.sleep(500);
         scrollRatio( ScrollDirection.DOWN, 0.5);
        Thread.sleep(500);
        Menu.increase(3);
        Menu.decrease(1);
        Thread.sleep(500);
        WebElement CustomizeItem = Element.Ele("XPATH", Element.CustomizeItem);
        CustomizeItem.isDisplayed();
        Thread.sleep(500);
         tapEle(CustomizeItem);
        WebElement mealCheckBok = Element.Ele("XPATH", Element.itemCheckBox1);
        Thread.sleep(2000);
         tapEle(mealCheckBok);

        Thread.sleep(500);
        WebElement update = Element.Ele("XPATH", Element.update);
        Thread.sleep(500);
         tapEle(update);


    }

    public static void allDayDrinkBottle() throws Throwable {

        Thread.sleep(1000);

        WebElement waterBottle = Element.Ele("XPATH", Element.waterBottle);

        for (int i = 0; i < 20; i++) {
            if (waterBottle.isDisplayed()) {
                waterBottle.click();
                Thread.sleep(1000);

            } else if (!waterBottle.isEnabled()) {
                 scrollRatio( ScrollDirection.DOWN, 0.5);
            }
        }
        Thread.sleep(1000);
        Menu.increase(3);
        Menu.decrease(1);
        Thread.sleep(1000);
        addToCart();
    }

    public static void cheeseBurger() throws Throwable {
        Thread.sleep(2000);
        WebElement Cheeseburger = Element.Ele("XPATH", Element.Cheeseburger);
        if (!Cheeseburger.isDisplayed()) {
             scrollRatio( ScrollDirection.UP, 0.5);
        }
         tapEle(Cheeseburger);
        Menu.increase(3);
        Menu.decrease(1);
        Thread.sleep(2000);
        addToCart();
    }

    public static void blackBeanBurger() throws InterruptedException {
        Thread.sleep(2000);
         scrollRatio( ScrollDirection.DOWN, 0.5);
        Thread.sleep(2000);
        WebElement blackBeanBurger = Element.Ele("XPATH", Element.blackBeanBurger);
         tapEle(blackBeanBurger);
        Thread.sleep(1000);
         scrollRatio( ScrollDirection.DOWN, 0.5);
        WebElement checkBox1 = Element.Ele("XPATH", Element.itemCheckBox1);
         tapEle(checkBox1);
        Thread.sleep(500);
        WebElement checkBox2 = Element.Ele("XPATH", Element.itemCheckBox2);
         tapEle(checkBox2);
        Thread.sleep(500);
        WebElement checkBox4 = Element.Ele("XPATH", Element.itemCheckBox4);
         tapEle(checkBox4);
        Thread.sleep(500);
        Menu.increase(3);
        Menu.decrease(1);
        Thread.sleep(500);
        addToCart();
    }


}
