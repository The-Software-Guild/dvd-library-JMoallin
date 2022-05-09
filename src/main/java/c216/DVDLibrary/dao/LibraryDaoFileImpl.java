package com.m3.c216.DVDLibrary.dao;

import com.m3.c216.DVDLibrary.dto.DVD;
import com.m3.c216.DVDLibrary.ui.LibraryView;
import com.m3.c216.DVDLibrary.ui.UserIOConsoleImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDaoFileImpl implements LibraryDao {


    private UserIOConsoleImpl io = new UserIOConsoleImpl();
    private LibraryView view = new LibraryView();
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String DVDid, DVD dvd) {
        return dvds.put(DVDid, dvd);
    }

    @Override
    public List<DVD> getAllDVD() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD removeDVD(String DVDid) {
        DVD removedDVD = dvds.remove(DVDid);
        return removedDVD;
    }

    public DVD updateDVD(int choice, String DVDid) {
        DVD dvdChoice = dvds.get(DVDid);
        switch(choice){
            case 0: //change title
                dvdChoice.setTitle(io.readString("Please enter new title:"));
                break;
            case 1: //change Director's first and last name
                dvdChoice.setDirectorFirstName(io.readString("Please enter new Director's first name:"));
                dvdChoice.setDirectorLastName(io.readString("Please enter new Director's last name:"));
                break;
            case 2: //change studio name
                String changedStudioName = io.readString("Please enter new studio name:");
                dvdChoice.setStudio(changedStudioName);
                break;
            case 3: //change MPAA rating
                dvdChoice.setMPAARating(io.readString("Please enter new MPAA rating:"));
                break;
            case 4: //change release date (dd, mm, yyyy)
                dvdChoice.setReleaseDay(io.readInt("Please enter new release day:"));
                dvdChoice.setReleaseMonth(io.readInt("Please enter new release month:"));
                dvdChoice.setReleaseYear(io.readInt("Please enter new release year:"));
                break;
            case 5: //change user rating
                dvdChoice.setUserRating(io.readInt("Please enter new user rating [0-10]:", 0, 10));
                break;
            case 6: //change note/comment
                dvdChoice.setNote(io.readString("Please enter new movie note:"));
                break;
        }
        return dvdChoice;
    }

    @Override
    public DVD getDVD(String DVDid) {
        return dvds.get(DVDid);
    }

    @Override
    public void SaveAndQuit() {
        try {
            File fileName = new File("Library1");
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(dvds);
            out.flush();
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LoadScript() {
            try {
                File file = new File("Library1");
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fis);

                HashMap<String, DVD> tmp = (HashMap<String, DVD>) in.readObject();

                for(HashMap.Entry<String,DVD> m : tmp.entrySet()){
                    dvds.put(m.getKey(),m.getValue());
                }
                List<DVD> basicList = new ArrayList<DVD>(dvds.values());
                System.out.println(basicList);
                fis.close();
                in.close();
            } catch (Exception e){
            System.out.println("\nThe file does not exist.");
        }
    }
}
