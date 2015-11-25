/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author guini
 */
public class ShoppingCart extends BookCollection{
    
    private Catalog catalog;
    
    public ShoppingCart( Catalog catinit ){
        catalog = catinit;
    }
    
    public void addCopies( int num , String booktitl){
        for(int i = 0 ; i <  catalog.size() ; ++i){
            
        }
    }
}
