package com.DigitalProfile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.basePath;


public class DPAPI {
    String randomName = randomMailName();
    String emailID = randomName + "@yopmail.com";
    

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRpcGludHVuYUBnbWFpbC5jb20iLCJuYW1laWQiOiJjNjNmY2QzNC0zNzA0LTQ1NmQtODUyOS1kYmQ1YTQ3YWIzOTgiLCJlbWFpbCI6ImRpcGludHVuYUBnbWFpbC5jb20iLCJFbWFpbFZlcmlmaWVkIjoiZmFsc2UiLCJQaG9uZVZlcmlmaWVkIjoiZmFsc2UiLCJGaXJzdE5hbWUiOiJESVBJTiIsIkxhc3ROYW1lIjoiQ0sxMjMiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9tb2JpbGVwaG9uZSI6IisxMjQ4NzM5MTQxNSIsInJvbGUiOiIiLCJuYmYiOjE3MTY0OTkxMTgsImV4cCI6MTcxNzEwMzkxOCwiaWF0IjoxNzE2NDk5MTE4LCJpc3MiOiJTaXhmbGFncyIsImF1ZCI6IlNpeGZsYWdzLkF1dGgifQ.bDkcvewfGs60leMZ54Z3lezlkHHCaaoUUYfdF_MoM-k";
    String baseUrl = "https://qaapi.sixflags.net/Auth";


    public void setToken(String basePath) {
        //   baseURI = "https://qaapi.sixflags.net/Auth";
        // basePath = "/Api/Test";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .basePath(basePath)
                .get();
        // response.then().statusCode(equalTo(200));
        // System.out.println("Response code =" + response.getStatusCode());
        // randomMailName();
        //  System.out.println("Email = "+emailID);
    }

    public String randomMailName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        String string = randomString + "a";
        // System.out.println("Random String: " + email);
        return string;

    }
@Test
    public void createUser() {
        basePath = "/V1/Api/Guest/Login/Register";
        JSONObject payLoad = new JSONObject();
        payLoad.put("firstName", randomName);
        payLoad.put("lastName", randomName);
        payLoad.put("email", emailID);
        payLoad.put("dialCountryCode", "+1");
        payLoad.put("phoneNumber", "8887779990");
        payLoad.put("password", randomName + "123@");
        payLoad.put("retypePassword", randomName + "123@");
        payLoad.put("isPrimaryUser", "true");
        Response response =
                RestAssured.given().header("Authorization", "Bearer " + token)
                        .contentType(ContentType.JSON)
                        .body(payLoad.toString()).post(baseUrl+basePath);
    System.out.println("Status code =" + response.getStatusCode());


    }

}
