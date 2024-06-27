package com.DigitalWallet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Random;

public class DWAPI {
    private static final String BASE_URL = "https://qaapi.sixflags.net/Auth/V1/Api/Guest/Login/Register";


    int randomNum = 1000000000 + new Random().nextInt(900000000);
    String phoneNumber = String.valueOf(randomNum);
    String Username = "User" + randomNum;
    String password = "TestUser@123";
    String email = Username + "@yopmail.com";
    String PATH = "/V1/Api/Guest/Login/Register";

    public void register() {

        JSONObject userData = new JSONObject();
        userData.put("firstName", "Test_");
        userData.put("lastName", Username);
        System.out.println(Username);
        userData.put("email", email);
        userData.put("dialCountryCode", "+1");
        userData.put("phoneNumber", phoneNumber);
        System.out.println(randomNum);
        userData.put("password", password);
        userData.put("retypePassword", password);
        userData.put("isPrimaryUser", true);
        Response response = RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(userData)
                .post();
        System.out.println("Response code = " + response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

    public static void main(String[] args) {
        DWAPI digitalWallet = new DWAPI();
        digitalWallet.register();
    }
}
