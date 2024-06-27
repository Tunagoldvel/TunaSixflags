package com.SixFlagsEvents;

import com.Utills.Element;
import com.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

@Listeners(com.Utills.Listener.class)
public class CartItems  extends BasePage {

    public CartItems() {
        super(driver);
    }

    public static void MOFilter() throws Throwable {
        Thread.sleep(500);
        WebElement mobOrder = Element.Ele("XPATH",
                "//android.widget.TextView[@text='Offers Mobile Ordering']/following-sibling::android.view.View[1]");

         tapEle(mobOrder);
        Thread.sleep(500);
        WebElement dinningPass = Element.Ele("XPATH",
                "//android.widget.TextView[@text='Dining Pass']/following-sibling::android.view.View[1]");
         tapEle(dinningPass);
        Thread.sleep(500);
    }


    public static void AllAmericanCafe() throws Throwable {
        Thread.sleep(5000);
        DiningTest.selectDining();
        Thread.sleep(5000);
        MOFilter();
        Thread.sleep(5000);

    }
}
