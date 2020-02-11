import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCount;

    public Library(int capacity){
        books = new ArrayList<Book>();
        this.capacity = capacity;
        genreCount = new HashMap<String, Integer>();
    }

    public HashMap<String, Integer> getHashMap(){
        return this.genreCount;
    }

    public int bookCount() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.books.size() < this.capacity) {
            this.books.add(book);
            // HashMap stuff
            String genre = book.getGenre();
            Integer count = genreCount.get(genre);
            if (count != null) {
                count += 1;
            } else {
                count = 1;
            }
            genreCount.put(genre, count);
        }
    }

    public Book removeBook(Book book){
        int index;
        index = this.books.indexOf(book);
        return this.books.remove(index);
    }

    public void loanBook(Borrower borrower, Book book){
        Book bookToLend = removeBook(book);
        borrower.loanBookToBorrower(bookToLend);

    }
}
