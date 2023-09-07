package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AddNewUser extends Globals {

    Faker faker=new Faker();

    public void addNewUser(){
        username=faker.name().username();
        password="Abc.!1"+faker.internet().password();

        Map<String,String> map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);


        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .and()
                .when().log().all()
                .post("/Account/v1/User").prettyPeek();

    }
    public void validateThatUserIsAdded(){
        Assert.assertEquals(201,response.statusCode());

        String actualUserName=response.path("username");
        Assert.assertEquals(username,actualUserName);

        Assert.assertNotNull(response.path("userID"));

        userId=response.path("userID");
    }


}
