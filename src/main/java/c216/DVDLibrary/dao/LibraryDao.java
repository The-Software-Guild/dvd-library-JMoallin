package com.m3.c216.DVDLibrary.dao;

import com.m3.c216.DVDLibrary.dto.DVD;

import java.io.FileNotFoundException;
import java.util.List;

public interface LibraryDao {

    DVD addDVD(String title, DVD dvd);

    List<DVD> getAllDVD();

    DVD getDVD(String title);

    DVD removeDVD(String title);

    DVD updateDVD(int choice, String DVDid);

    void SaveAndQuit() throws FileNotFoundException;

    void LoadScript() throws FileNotFoundException;
}
