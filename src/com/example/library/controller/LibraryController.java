package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.LibraryModel;
import com.example.library.view.ConsoleView;
import java.util.List;
public class LibraryController {
    private final LibraryModel model;
    private final ConsoleView view;

    public LibraryController(LibraryModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }
    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.readInt();
            switch (choice) {
                case 1 -> addBookFlow();
                case 2 -> listBooksFlow();
                case 3 -> searchBooksFlow();
                case 4 -> deleteBookFlow();
                case 5 -> {
                    view.showMessage("Exiting... Goodbye!");
                    running = false;
                }
                default -> view.showMessage("Invalid choice. Try again.");
            }
        }
    }
    private void addBookFlow() {
        String title = view.readLine("Enter title: ");
        String author = view.readLine("Enter author: ");
        Book b = model.addBook(title, author);
        view.showMessage("Added: " + b);
    }

    private void listBooksFlow() {
        List<Book> books = model.getAllBooks();
        view.showBooks(books);
    }
    private void searchBooksFlow() {
        String keyword = view.readLine("Enter title keyword: ");
        List<Book> results = model.searchByTitle(keyword);
        view.showBooks(results);
    }
    private void deleteBookFlow() {
        if (model.isEmpty()) {
            view.showMessage("Library is empty. Nothing to delete.");
            return;
        }
        int id = view.readInt();
        boolean deleted = model.deleteById(id);
        if (deleted) {
            view.showMessage("Book deleted successfully.");
        } else {
            view.showMessage("No book found with ID " + id);
        }
    }
}
