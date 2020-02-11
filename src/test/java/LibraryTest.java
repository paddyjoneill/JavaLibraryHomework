import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library(5);
        book = new Book("Harry Potter", "JK Rowling", "fantasy");
        borrower = new Borrower();
    }

    @Test
    public void library_starts_empty(){
        assertEquals(0, library.bookCount());
    }

    @Test
    public void can_add_books_to_library(){
        library.addBook(book);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void cant_add_book_if_library_full(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(5, library.bookCount());
    }

    @Test
    public void borrower_can_loan_book(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.loanBook(borrower, book);
        assertEquals(4, library.bookCount());
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void hash_map_works(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        int count = library.getHashMap().get(book.getGenre());
        assertEquals(3, count );
    }

}
