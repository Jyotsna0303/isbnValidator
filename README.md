# isbnValidator
This is a simple java project for validating the ISBN code. I have followed TDD while developing this application.

ISBN Validator:
Check the logic here : https://en.wikipedia.org/wiki/International_Standard_Book_Number

Stock locator method returns:
A unique internal locator code for the book made up of:
last 4 digit of ISBN number,
first initial of Surname,
number of words in title

A 3rd party webservice can supply the name and author
Cache all found names and authors in a local database for performance and reliability


