/*
 * This is a Shoppingcart Impl class
 * 
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
   
   /**
    * This method is for calculating the item along with offer
    * buy3 get 2 
    * @param itemsCost
    * @return value
    * 
    */ 
   public int apply2(Integer[] itemsCost) {

        int numberOfItems = itemsCost.length;
            
        if(numberOfItems==0){
            return 0;
        }
        if (numberOfItems >=3)
            return (numberOfItems -(numberOfItems /3)) * itemsCost[0];
        else 
            return (numberOfItems %3)* itemsCost[0];
    }
   
    /**
    * This method is for calculating the item along with offer
    * buy1 get 1 
    * @param itemsCost
    * @return value
    * 
    */ 
   public int apply1(Integer[] itemsCost) {
        int numberOfItems = itemsCost.length;
        System.out.println("no of items: "+numberOfItems);
        if(numberOfItems==0){
            return 0;
        }
       return (numberOfItems /2)* itemsCost[0] + (numberOfItems %2)* itemsCost[0];
    }
   
     /*
      * This method is used for printing the Receipt.
      * 
      */
     public String printReceipt(List<String> shoppingCart) {

        BigDecimal total = new BigDecimal(scan(shoppingCart) * .01);

        return NumberFormat.getCurrencyInstance().format(total);
    }
   
     /*
      * This method is used for adding calculation
      * List shoppingCart contains the Apples and oranges
      * 
      */
   private int scan(List<String> shoppingCart) {
        System.out.println("shoppingCart "+shoppingCart);
        int total = 0;

        int apples = frequency(shoppingCart, APPLE_CODE);
        total += this.apply1(nCopies(apples, APPLE_PRICE).toArray(new Integer[apples]));
        
        int oranges = frequency(shoppingCart, ORANGE_CODE);
        total += this.apply2(nCopies(oranges, ORANGE_PRICE).toArray(new Integer[oranges]));

        return total;
    }
}
