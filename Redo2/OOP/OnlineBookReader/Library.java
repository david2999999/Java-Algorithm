package OOP.OnlineBookReader;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details) {
        if (books.containsKey(id)) {
            return null;
        }

        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean remove(Book book) {
        return remove(book.getBookId());
    }

    private boolean remove(int bookId) {
        if (!books.containsKey(bookId)) {
            return false;
        }

        books.remove(bookId);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }
}
