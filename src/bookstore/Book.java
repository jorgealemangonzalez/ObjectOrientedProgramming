/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.Date;

/**
 *
 * @author jorge aleman
 */
public class Book {
    private String title;
    private String author;
    private Date publicationDate;
    private String publicationPlace;
    private long ISBN;

    public Book(String tlinit , String auinit , Date dtinit , String plinit , long isbn)
    {
        title = tlinit;
        author = auinit;
        publicationDate = dtinit;
        publicationPlace = plinit;
        ISBN = isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public Date getPublicationDate(){
        return publicationDate;
    }
    public String getPublicationPlace(){
        return publicationPlace;
    }
    public long getISBN(){
        return ISBN;
    }
}
