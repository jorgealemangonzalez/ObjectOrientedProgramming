/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.Currency;

/**
 *
 * @author guini
 */
public class ShoppingCart extends BookCollection{
    
    protected Catalog catalog;
    
    public ShoppingCart( Catalog catinit ){
        catalog = catinit;
        String s[] = catalog.booktitles();
        for( int i = 0 ; i < s.length ; ++i){
            StockInterface stock = catalog.getStock(s[i]); //hemos puesto publica el getStock para poder coger todos los Stocks 
            stock.removeCopies(stock.numberOfCopies());
            collection.add(stock);
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
        }
       return suma;
    }
    
    public void checkout () {
     
        Payment user = new Payment ();
        user.doPayment(122541, "Arnau ", totalPrice(), Currency.getInstance("EUR"));
        for( StockInterface stock : collection){
            stock.removeCopies(stock.numberOfCopies());
        }
    }
}
