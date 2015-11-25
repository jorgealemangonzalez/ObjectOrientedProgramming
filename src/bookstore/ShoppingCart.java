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
public class ShoppingCart extends BookCollection implements ShoppingCartInterface{
    
    protected Catalog catalog;
    
    public ShoppingCart( Catalog catinit ){
        catalog = catinit;
        String s[] = catalog.booktitles();
        for( int i = 0 ; i < s.length ; ++i){
            Stock st = (Stock)catalog.getStock(s[i]); //hemos puesto publica el getStock para poder coger todos los Stocks 
            Stock stock = new Stock( st.getBook(), 0 , st.totalPrice()/st.numberOfCopies(),Currency.getInstance("EUR") );
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
