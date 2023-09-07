package com.bookstore.services;


import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class UpdateBook extends Globals {

    public void updateBookNumber(){
        Map<String,String> map=new HashMap<>();
        map.put("userId",userId);
        map.put("isbn", String.valueOf(isbnNumbers.get(1)));

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .pathParam("isbn",isbnNumbers.get(0))
                .body(map)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}");
    }
    public void validateTheBookIsUpdated(){
        Assert.assertEquals(isbnNumbers.get(1),response.path("books.isbn[0]"));
        Assert.assertEquals(userId,response.path("userId"));
        Assert.assertEquals(username,response.path("username"));
    }
}
