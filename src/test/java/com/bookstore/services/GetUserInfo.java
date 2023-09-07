package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class GetUserInfo extends Globals {
    public void getUserInformation(){
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .pathParam("id",userId)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }

    public void validateTheUserInfo(){
        Assert.assertEquals(userId,response.path("userId"));
        Assert.assertEquals(username,response.path("username"));
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));
    }

}
