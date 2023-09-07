package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AuthorizeUser extends Globals {

    public void authorizeUser(){
        Map<String,String> map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .when().log().all()
                .post("/Account/v1/Authorized").prettyPeek();

    }
    public void validateTheUserIsAuthorize(){
        Assert.assertTrue(response.body().asString().contains("true"));
    }
}
