package com.bookstore.step_defs;

import com.bookstore.services.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BookStoreFlow_StepDefs {
    GetUserInfo getUserInfo=new GetUserInfo();
    GetAllBooks getAllBooks=new GetAllBooks();
    AddNewUser addNewUser=new AddNewUser();
    GenerateToken generateToken=new GenerateToken();
    AuthorizeUser authorizeUser=new AuthorizeUser();
    AddNewBook addNewBook=new AddNewBook();
    UpdateBook updateBook=new UpdateBook();
    @Given("Get all books")
    public void get_all_books() {
    getAllBooks.getAllBooks();
    }

    @Then("Validate that the books are listed")
    public void validate_that_the_books_are_listed() {
    getAllBooks.validateThatAllBooksAreListed();
    }


    @Given("Add new user")
    public void add_new_user() {
    addNewUser.addNewUser();
    }

    @Then("Validate that user is created")
    public void validate_that_user_is_created() {
    addNewUser.validateThatUserIsAdded();
    }

    @Given("Generate token")
    public void generate_token() {
    generateToken.generateToken();
    }

    @Then("Validate that the token is generated")
    public void validate_that_the_token_is_generated() {
    generateToken.validateThatTheTokenIsGenerated();
    }
    @Given("Authorize User")
    public void Authorize_User() {
    authorizeUser.authorizeUser();
    }

    @Then("Validate that the user is authorized")
    public void validate_that_the_user_is_authorized() {
    authorizeUser.validateTheUserIsAuthorize();
    }
    @Given("Add new book to the user")
    public void add_new_book_to_the_user() {
        addNewBook.addNewBook();
    }

    @Then("validate that the book is assigned to the user")
    public void validate_that_the_book_is_assigned_to_the_user() {
       addNewBook.validateToTheBookIsAdded();
    }

    @Given("Get User Information")
    public void get_User_Information() {
        getUserInfo.getUserInformation();
    }

    @Then("Validate that the user information is correct")
    public void validate_that_the_user_information_is_correct() {
    getUserInfo.validateTheUserInfo();
    }

    @Given("Update User Book")
    public void update_User_Book() {
    updateBook.updateBookNumber();
    }

    @Then("Valide that the user books update")
    public void valide_that_the_user_books_update() {
    updateBook.validateTheBookIsUpdated();
    }





}
