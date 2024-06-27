Before review cart
Apply dining pass
//android.widget.TextView[@text="Apply Dining Pass"]
back
//android.view.View[@resource-id="auto_Back"]
Clear bag Badge
//android.widget.TextView[@text="Clear Bag"]
Continue
//android.widget.TextView[@text="Continue"]
Cancel
//android.widget.TextView[@text="Cancel"]

ScreenShot
File src1 =((Take sScreenshot)diver).getScreenshotAs(OutputType.FILE);
FileUti1s.copyFiLe(src1,new FIle("target//Screenshots//"+ methodname +".png"));
Reporter.