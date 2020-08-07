package com.joe.isbntool;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTest {
    ExternalIsbnDataService testWebService;
    ExternalIsbnDataService testDbService;
    StockManager stockManager;
    @Before
    public void setup(){
        testWebService=mock(ExternalIsbnDataService.class);
        testDbService=mock(ExternalIsbnDataService.class);
         stockManager= new StockManager();
        stockManager.setService(testWebService);
        stockManager.setDataBaseService(testDbService);
    }
    @Test
    public void testGetCorrectLocatorCode(){
       // fail();
       /* *****using stub*****
        ExternalIsbnDataService testWebService= new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"of Mice and Men","J. Steinbeck");
            }
        };
        ExternalIsbnDataService testDataBaseService=new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };*/

        when(testDbService.lookup(anyString())).thenReturn(null);
        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396","of Mice and Men","J. Steinbeck"));
        String isbn= "0140177396";

        String locatorCode=stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);

    }

    @Test
    public void databaseIsUsedIfDataIsPresent(){
        //using mock instead of stub
        //fail();

        when(testDbService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        String isbn= "0140177396";
        String locatorCode=stockManager.getLocatorCode(isbn);
        verify(testDbService,times(1)).lookup("0140177396");
        verify(testWebService,times(0)).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDB(){

       //fail();

        when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        String isbn= "0140177396";
        String locatorCode=stockManager.getLocatorCode(isbn);
        verify(testWebService,times(1)).lookup("0140177396");
        verify(testWebService,times(0)).lookup(anyString());
    }
}
