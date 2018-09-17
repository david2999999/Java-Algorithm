package Redo.OOD.OnlineBookReader;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public Book addBook(int id, String detail) {
        if (books.containsKey(id)) return null;

        Book book = new Book(id, detail);
        books.put(id, book);
        return book;
    }

    public boolean removeBook(Book book) {
        return this.removeBook(book.getId());
    }

    public boolean removeBook(int id) {
        if (!books.containsKey(id)) return false;

        books.remove(id);
        return true;
    }

    public Book findBook(int id) {
        if (!books.containsKey(id)) return null;

        return books.get(id);
    }
}
