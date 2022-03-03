//Written by Dave Dominique

public class main {
	public static void main(String[] args) {

		Book b1 = new LibraryBook("Emily jones", "The Origin of Species", 23654585, 1965, "bio");

		Book b2 = new BookstoreBook("Emily Jones", "The Origin of Species", 23654585, 89.99, 1965);
		
		System.out.println (b1);System.out.print("\n");
		//the above line should print: the origin of species by emily jones published in 1965, biology
		System.out.println (b2);System.out.print("\n");
		//the above line prints: 23654585: the origin of species by emily jones published in 1965, $89.99
		
		
		//System.out.println (((LibraryBook) b1).createCode()); 
		System.out.println (b1.createCode()); //prints [bio-emily jones-the origin of species-1965] to the screen		 
	
		System.out.print("\n");
		
		//system.out.println (((BookstoreBook) b2).createCode());
		System.out.println (b2.createCode()); // prints [23654585-emily jones-89.99]  to the screen 
		
		
	}
}


interface Codable{
	
	 public String createCode(); 
}


class Book implements Codable {
	protected String author;
	protected String title;
	protected int isbn;
	protected int year;
	
	protected String subject = " ";
	protected double price;
	
	public String createCode() {
		 
		 return "[" + isbn + "-" + author + "-" + price +"]";
//			System.out.println (b2.createCode()); // prints [23654585-emily jones-89.99] to the screen
	 }

}

class BookstoreBook extends Book implements Codable{
	
	public BookstoreBook(String author, String title, int isbn, double price, int year) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
	}
	
	public String toString() {
		
		return isbn +": " + title + " by " + author + " published in " + year + ", $" + price ;
	}
	
	 @Override
	 public String createCode() {
		 
		 return "[" + isbn + "-" + author + "-" + price +"]";
//			System.out.println (b2.createCode()); // prints [23654585-emily jones-89.99] to the screen
	 }
}



class LibraryBook extends Book implements Codable{
	
	public LibraryBook(String author, String title, int isbn, int year, String subject) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		
		if(subject == "bio")
		{
			this.subject = "biology";
		}
		
		if(subject == "acc")
		{
			this.subject = "accounting";
		}
		
		if(subject == "psy")
		{
			this.subject = "psychology";
		}
		
		if(subject == "rel")
		{
			this.subject = "religion";
		}
	}
	
	public String toString() {
	
		return title + " by " + author + " published in " + year + ", " + subject;
	}
	
	@Override
	public String createCode() {
		return "[" + subject + "-" + author + "-" + title + "-"  + year + "]";
		//System.out.println (b1.createCode()); //prints [bio-emily jones-the origin of species-1965] to the screen
	}

}
