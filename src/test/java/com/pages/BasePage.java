package com.pages;


import com.Utills.DriverSetUp;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;

public class BasePage extends DriverSetUp {
public BasePage(AppiumDriver driver) {
    PageFactory.initElements(BasePage.driver, this);
}

    static AppiumDriver driver = DriverSetUp.getDriver();

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    static Duration SCROLL_DUR = Duration.ofMillis(500);


    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }


    public void isElementDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }


    public static void waitForVisibilityOfTheElement(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void click(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        tapEle(ele);
    }

    public void sentKeys(WebElement ele, String txt) {
        waitForVisibilityOfTheElement(ele);
        ele.click();
        ele.sendKeys(txt);
    }

    public String getAttribute(WebElement ele, String txt) {
        waitForVisibilityOfTheElement(ele);
        return ele.getAttribute(txt);
    }

    public static void scroll() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = size.getWidth() / 4;
        int endX = size.getHeight() / 4;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(300)))
                .addAction(
                        finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public static void scrollRatio(ScrollDirection dir, double scrollRatio) {

        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        Point midPoint = new Point((int) (size.width * 0.4), (int) (size.height * 0.5));
        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
        Point Start = new Point(midPoint.x, bottom);
        Point End = new Point(midPoint.x, top);
        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
        int right = midPoint.x + (int) (midPoint.x * scrollRatio);

        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else if (dir == ScrollDirection.RIGHT) {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    protected static void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
    }

    public static void tapEle(@NotNull WebElement ele) {
        Point location = ele.getLocation();
        Dimension size = ele.getSize();
        Point centerOfEle = getCenter(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfEle))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(150)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

    }

    private static Point getCenter(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    private static Point getCenter(WebElement el) {
        Point location = el.getLocation();
        Dimension size = el.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }

    public static void scrollToTop() throws InterruptedException {
        String prevPageSource = "";
        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = driver.getPageSource();
            scrollRatio(ScrollDirection.DOWN, 0.4);
            Thread.sleep(100);
        }
    }

    public static boolean isEndOfPage(String pageSource) {
        return pageSource.equals(driver.getPageSource());
    }

    public static void scrollToBottom() throws InterruptedException {
        String prevPageSource = "";
        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = driver.getPageSource();
            scrollRatio(ScrollDirection.DOWN, 0.4);

            Thread.sleep(1000);
        }
    }

    public static void hideKeyBoard() {
        driver.navigate().back();
    }

    public static void ScrollToClick(WebElement element) {
        String prevPageSource = "";
        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = driver.getPageSource();

            if (element.isDisplayed()) {
                break;
            }
            scrollRatio(ScrollDirection.DOWN, 0.4);

        }
    }


    public static void dragNDrop(WebElement source, WebElement target) {
        Point pSource = getCenter(source);
        Point pTarget = getCenter(target);
        swipe(pSource, pTarget, SCROLL_DUR);
    }


}
