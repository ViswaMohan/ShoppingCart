/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viswa.tdd.shopping.cart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import static java.util.Collections.frequency;
import static java.util.Collections.nCopies;
import java.util.List;

/**
 *
 * @author Viswa_workshop
 */
public class ShoppingCartImpl {
    
    private static final int APPLE_PRICE = 60;
    private static final int ORANGE_PRICE = 25;
    private static final String APPLE_CODE = "Apple";
    private static final String ORANGE_CODE = "Orange";   
   
   public int apply1(Integer[] itemsCost) {
        int numberOfItems = itemsCost.length;
        System.out.println("no of items: "+numberOfItems);
        if(numberOfItems==0){
            return 0;
        }
       return (numberOfItems /2)* itemsCost[0] + (numberOfItems %2)* itemsCost[0];
    }
   
     public String printReceipt(List<String> shoppingCart) {

        BigDecimal total = new BigDecimal(scan(shoppingCart) * .01);

        return NumberFormat.getCurrencyInstance().format(total);
    }
   
   private int scan(List<String> shoppingCart) {
        System.out.println("shoppingCart "+shoppingCart);
        int total = 0;

        int apples = frequency(shoppingCart, APPLE_CODE);
        total += this.apply1(nCopies(apples, APPLE_PRICE).toArray(new Integer[apples]));
        
        return total;
    }
}
