package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends Globals {

    public void generateToken(){

        Map<String,String> map =new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .when().log().all()
                .post("/Account/v1/GenerateToken").prettyPeek();
    }

    public void validateThatTheTokenIsGenerated(){
        Assert.assertEquals(200,response.statusCode());
        Assert.assertNotNull(response.path("token"));
        Assert.assertEquals("Success",response.path("status"));
        Assert.assertEquals("User authorized successfully.",response.path("result"));
        token=response.path("token");
    }
}
