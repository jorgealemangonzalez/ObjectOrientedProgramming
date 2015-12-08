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
public class Catalog extends BookCollection { 
    
    Catalog(){
        LinkedList< String[] > list = BookCollection.readCatalog("books.xml");
        for(String[] row: list)
        {
            Date date = new Date();
            try { 
                SimpleDateFormat parserSDF=new SimpleDateFormat("yyyy/mm/dd");
                date = parserSDF.parse(row[2]);
            }
            catch( Exception e ) {System.out.println(e); }
            long isbn = Long.parseLong( row[4] ); // convert to long
            double price = Double.parseDouble( row[5] ); // convert to double
            Currency currency = Currency.getInstance( row[6] ); // Currency instance
            int copies = Integer.parseInt( row[7] ); // convert to int
            //System.out.println("Catalog cop "+copies);
            Book b = new Book(row[0],row[1],date,row[3],isbn);
            StockInterface s = new Stock(b,copies,price,currency);
            //System.out.println("Stock : "+s.numberOfCopies());
            collection.add(s);
        }
    };
}