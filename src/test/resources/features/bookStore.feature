@wip
Feature: BookStore Circle

  #Get All Books
  @getAllBooks
  Scenario: Scenario-1
    Given Get all books
    Then Validate that the books are listed

   #add new user
  @addNewUser
  @generateToken @authorizeUser
  Scenario: Scenario-2
    Given Add new user
    Then Validate that user is created


    #generate token
  @generateToken @authorizeUser
  Scenario: Scenario-3
    Given Generate token
    Then Validate that the token is generated

    #Authorize User
  @authorizeUser
  Scenario: Scenario-4
    Given Authorize User
    Then Validate that the user is authorized

  #add new book
  @addNewBook
  Scenario: Scenario-5
    Given Add new book to the user
    Then validate that the book is assigned to the user

    #get user info
  @getUserInformation
    Scenario: Scenario-6
      Given Get User Information
      Then Validate that the user information is correct

    #update user book
    @updateBook
    Scenario: Scenario-7
      Given Update User Book
      Then Valide that the user books update