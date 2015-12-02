
package bookstore;

import java.util.Currency;

public interface StockInterface {
	public String getBooktitle();
	public int numberOfCopies();
	public void addCopies( int numberOfCopies );
	public void removeCopies( int numberOfCopies );
	public double totalPrice();
        public Book getBook();
        public Currency getCurrency();
}
