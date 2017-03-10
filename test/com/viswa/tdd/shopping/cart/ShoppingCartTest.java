/*
 * This class is the ShoppingCart test class
 * 
 */
package com.viswa.tdd.shopping.cart;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Viswa_workshop
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
    }
    
    private ShoppingCartImpl checkoutSystem;

    @Before
    public void setUp() throws Exception {
        checkoutSystem = new ShoppingCartImpl();
    }
    
    @Test
    public void shouldPrintReceiptForShoppingCartContainingApplesAfterBuyOneGetOneOffer() throws Exception {
       
        assertEquals("1 Apple", checkoutSystem.printReceipt(asList("Apple")),"£0.60");
        assertEquals("2 Apple", checkoutSystem.printReceipt(asList("Apple","Apple")),"£0.60");
        assertEquals("3 Apple", checkoutSystem.printReceipt(asList("Apple", "Apple", "Apple")),"£1.20");
        
    }
    
    @Test
    public void shouldPrintReceiptForShoppingCartContainingOrangesAfter3For2Offer() throws Exception {
        assertEquals("1 Orange", checkoutSystem.printReceipt(asList("Orange")), "£0.25");
        assertEquals("2 Orange", checkoutSystem.printReceipt(asList("Orange", "Orange")),"£0.50");
        assertEquals("3 Orange", checkoutSystem.printReceipt(asList("Orange", "Orange","Orange")), "£0.50");
        assertEquals("4 Orange", checkoutSystem.printReceipt(asList("Orange", "Orange","Orange","Orange")),"£0.75");
    }

    @Test
    public void shouldPrintReceiptForShoppingCartContainingApplesAndOrangesAfterOffers() throws Exception {
        assertEquals("2 Apple, 1 Orange", checkoutSystem.printReceipt(asList("Apple", "Apple", "Orange")), "£0.85");
        assertEquals("2 Apple, 3 Oranges", checkoutSystem.printReceipt(asList("Apple", "Apple", "Orange", "Orange", "Orange")), "£1.10");
    }

    
}