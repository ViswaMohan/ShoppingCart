/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    
}