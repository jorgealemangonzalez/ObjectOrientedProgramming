/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author jorge aleman
 */
public class TestStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookCollectionInterface c = new Catalog();
        ShoppingCartInterface s = new ShopingCart(c);
        BookStore store = new BookStore(c,s);
    }
    
}
