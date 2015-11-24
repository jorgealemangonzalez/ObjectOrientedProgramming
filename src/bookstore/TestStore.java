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
        LinkedList< Book > books;
        books = new LinkedList < > ();
        LinkedList< Stock > allStock;
        allStock = new LinkedList < > ();
        LinkedList< String[] > list = BookCollection.readCatalog("books.xml");
        for(String[] row: list)
        {
            Date date = new Date();
            try { date = new SimpleDateFormat().parse( row[2] ); } // Date instance
            catch( Exception e ) {}
            long isbn = Long.parseLong( row[4] ); // convert to long
            double price = Double.parseDouble( row[5] ); // convert to double
            Currency currency = Currency.getInstance( row[6] ); // Currency instance
            int copies = Integer.parseInt( row[7] ); // convert to int
            Book b = new Book(row[0],row[1],date,row[3],isbn);
            books.add(b);
            Stock s = new Stock(b,copies,price,currency);
            allStock.add(s);
        }
        //Ya hemos creado la lista de libros y la lista de Stocks
    }
    
}
