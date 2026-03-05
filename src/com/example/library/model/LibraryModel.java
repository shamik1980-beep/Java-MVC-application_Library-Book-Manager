package com.example.library.model;
import java.util.ArrayList;
import java.util.List;

public class LibraryModel {
    private final List<Book> books = new ArrayList<>();
    private int nextId = 1;
    public Book addBook(String title, String author) {
        Book b = new Book(nextId++, title, author);
        books.add(b);
        return b;
    }
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // return copy (safer)
    }
    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }
    public boolean deleteById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty() {
        return books.isEmpty();
    }
}
