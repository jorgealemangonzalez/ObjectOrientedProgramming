/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.Currency;
import java.util.HashSet;

/**
 *
 * @author guini
 */
public class ShoppingCart extends BookCollection implements ShoppingCartInterface{
    
    protected Catalog catalog;
    
    public ShoppingCart( Catalog catinit ){
        catalog = catinit;
        HashSet< StockInterface > col = catalog.getCollection();
        for ( StockInterface stock : col ) {
            Stock s;
            s = new Stock(stock.getBook(), 0 , stock.totalPrice()/stock.numberOfCopies(), stock.getCurrency() );
            collection.add(s);
        }
    }
    
    public void addCopies( int num , String booktitl){
        super.addCopies(num, booktitl);
        catalog.removeCopies(num, booktitl);
    }
    
    public void removeCopies( int num , String booktitl){
        super.removeCopies(num, booktitl);
        catalog.addCopies(num, booktitl);
    }
    
    public double totalPrice(){
       double suma = 0;
       for ( StockInterface stock : collection ) {
          
          suma += stock.totalPrice();
          //System.out.println("Suma: "+suma+" Price: "+stock.totalPrice() + " Copies: "+stock.numberOfCopies());
        }
       return suma;
    }
    
    public String checkout(){
     
        Payment user = new Payment ();
        double t = totalPrice();
        for( StockInterface stock : collection){
            stock.removeCopies(stock.numberOfCopies());
        }
        //System.out.println(totalPrice());
        return user.doPayment(122541, "Arnau", t, Currency.getInstance("EUR"));
    }
}
