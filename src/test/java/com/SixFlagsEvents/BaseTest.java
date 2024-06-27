package com.SixFlagsEvents;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.Utills.Listener.class)
public class BaseTest {

   // @Test
    //Regression
    public static void invalidMediaNumberAndLastName() throws Throwable {

        Reporter.log("Launch the app and Select passes");
        AddPassTest.addpasses();

        Reporter.log("User select the upload passes");
        AddPassTest.uploadPasses();

        Reporter.log("User Select the manual Entry");
        AddPassTest.manualEntry();

        Reporter.log("User enter invalid Media Number and LastName and Confirm");
        AddPassTest.invalidPassDetails();

        Reporter.log("ser see the Error message");
        AddPassTest.errorInfo();
        Reporter.log("Launch the app and Select passes");
        AddPassTest.status();
        Reporter.log("Launch the app and Select passes");

    }
  // @Test(dependsOnMethods = {"invalidMediaNumberAndLastName"})
    public static void deletePasses() throws Throwable {
        // Go to passes
        AddPassTest.addpasses();
        // Get pass count
        AddPassTest.passCount();

        //get Pass Number
        AddPassTest.verifyPassNumber();

        //verify passes number
        AddPassTest.benefits();
        //select Remove
        AddPassTest.deletePassDetails();

    }

  //  @Test(dependsOnMethods = {"deletePasses"})
    public static void validMediaNumberAndLastName() throws Throwable {
        // Launch the app and Select passes
     //   AddPassTest.addPasses();
        //User select the upload passes
        AddPassTest.uploadPasses();
        //User Select the manual Entry
        AddPassTest.manualEntry();
        //User enter invalid Media Number and LastName and Confirm
        AddPassTest.validPassDetails();
        // user see the Error message
        AddPassTest.status();
        // Close the application
     //   DriverSetUp.tearDown();
    }

}
