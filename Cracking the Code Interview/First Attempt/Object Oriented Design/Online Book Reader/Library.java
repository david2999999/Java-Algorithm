package ObjectOrientedDesign.OnlineBookReader;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details) {
        if (books.containsKey(id)){
            return null;
        }

        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean remove(Book book) {
        return remove(book.getBookId());
    }

    public boolean remove(int id) {
        if (!books.containsKey(id)) return false;

        books.remove(id);
        return true;
    }

    public Book findBook(int id) { return books.get(id); }
}
