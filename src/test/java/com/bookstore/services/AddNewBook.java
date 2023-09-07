package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class AddNewBook extends Globals {

    public void addNewBook(){
    String jsonBody="{\n" +
            "  \"userId\": \""+userId+"\",\n" +
            "  \"collectionOfIsbns\": [\n" +
            "    {\n" +
            "      \"isbn\": \""+isbnNumbers.get(0)+"\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(jsonBody)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();
    }
    public void validateToTheBookIsAdded(){
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));
        Assert.assertEquals(201,response.statusCode());
    }
}
