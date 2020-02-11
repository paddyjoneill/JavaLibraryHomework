import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> books;

    public Borrower(){
        books = new ArrayList<Book>();
    }

    public void loanBookToBorrower(Book bookToLend) {
        this.books.add(bookToLend);
    }

    public int bookCount(){
        return this.books.size();
    }
}
