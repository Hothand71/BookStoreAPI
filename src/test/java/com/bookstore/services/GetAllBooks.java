package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;

public class GetAllBooks extends Globals {

    public void getAllBooks(){
        response= RestAssured.given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }
    public void validateThatAllBooksAreListed(){
        //assert status code
        Assert.assertEquals(200,response.statusCode());

        //assert that all isbn numbers have value
        JsonPath jsonPath=response.jsonPath();
        List<String> list = jsonPath.getList("books.isbn");
        list.forEach(n -> Assert.assertNotNull(n));
        /*for (String isbn : list) {
            Assert.assertNotNull(isbn);
        }*/
        //put all isbn numbers into the global static isbn list
        isbnNumbers=jsonPath.getList("books.isbn");
    }

}
