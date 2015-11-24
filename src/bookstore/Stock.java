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
    
    public Stock( Book bk, int cop , double pric, Currency curr ){
        book = bk;
        copies = cop;
        price = pric;
        currency = curr;
    }
    
    public Book getBook(){
        return book;
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
        return price;
    }
}
