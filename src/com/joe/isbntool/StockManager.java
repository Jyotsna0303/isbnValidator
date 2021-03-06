package com.joe.isbntool;


public class StockManager {
    private ExternalIsbnDataService webService;
    private ExternalIsbnDataService dataBaseService;

    public void setService(ExternalIsbnDataService service) {
        this.webService = service;
    }
    public void setDataBaseService(ExternalIsbnDataService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }
    public String getLocatorCode(String isbn) {

        Book book =dataBaseService.lookup(isbn);
        if (book==null) {
            book=webService.lookup(isbn);}
        StringBuilder locator= new StringBuilder();
        locator.append(isbn.substring(isbn.length()-4));
        locator.append(book.getAuthor().substring(0,1));
        locator.append(book.getTitle().split(" ").length);
        return locator.toString();
    }
}
