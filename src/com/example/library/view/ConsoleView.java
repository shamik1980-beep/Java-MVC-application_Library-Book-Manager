package com.example.library.view;
import com.example.library.model.Book;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n=== Library Book Manager (MVC) ===");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Delete Book by ID");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }
    public int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        System.out.println("\n--- Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
