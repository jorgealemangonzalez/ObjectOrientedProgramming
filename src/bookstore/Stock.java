/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.Currency;

/**
 *
 * @author jorge aleman
 */
public class Stock implements StockInterface{
    private Book book;
    private int copies;
    private double price;
    private Currency currency;
    
    
    Stock( Book bk, int cop , double pric, Currency curr ){
        book = bk;
        copies = cop;
        price = pric;
        currency = curr;
    }
    
    public Book getBook(){ //Con este getter ya podemos obtener toda la info del libro
        return book;
    }
    
    public Currency getCurrency(){
        return currency;
    }
    
    public String getBooktitle(){
        return book.getTitle();
    }
    
    public int numberOfCopies(){
        return copies;
    }
    
    public void addCopies( int num ){
        copies += num;
    }
    
    public void removeCopies( int num ){
        copies -= num;
    }
    
    public double totalPrice(){
        return price*(double)copies;
    }
}
