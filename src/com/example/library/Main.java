package com.example.library;
import com.example.library.controller.LibraryController;
import com.example.library.model.LibraryModel;
import com.example.library.view.ConsoleView;
public class Main {
    public static void main(String[] args) {
        LibraryModel model = new LibraryModel();
        ConsoleView view = new ConsoleView();
        LibraryController controller = new LibraryController(model, view);
        controller.start();
    }
}
