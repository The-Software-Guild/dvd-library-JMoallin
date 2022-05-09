package com.m3.c216.DVDLibrary;

import com.m3.c216.DVDLibrary.Controller.LibraryController;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class App implements Serializable {
    public static void main(String[] args) throws FileNotFoundException {
        LibraryController controller = new LibraryController();
        controller.run();
    }
}
