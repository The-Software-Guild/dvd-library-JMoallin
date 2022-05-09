package com.m3.c216.DVDLibrary.ui;

import com.m3.c216.DVDLibrary.dto.DVD;

import java.util.List;

public class LibraryView {

    private UserIO io = new UserIOConsoleImpl();

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter title");
        String firstName = io.readString("Please enter director's First Name");
        String lastName = io.readString("Please enter director's Last Name");
        String studio = io.readString("Please enter studio");
        String MPAArating = io.readString("Please enter MPAArating");
        int releaseDay = io.readInt("Please enter release day");
        int releaseMonth = io.readInt("Please enter release month");
        int releaseYear = io.readInt("Please enter release year");
        double userRating = io.readDouble("Please enter userRating", 0, 10);
        String note = io.readString("Please enter note/comment");
        DVD currentDVD = new DVD(title,firstName,lastName,studio,MPAArating,
                releaseDay,releaseMonth,releaseYear,userRating,note);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== All DVDs ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("Title: " + DVD.getTitle());
            io.print("Director: " + DVD.getDirectorFirstName() + " " + DVD.getDirectorLastName());
            io.print("Release Date: " + DVD.getReleaseDay() + "-" +
                    DVD.getReleaseMonth() + "-" + DVD.getReleaseYear());
            io.print("Studio: " + DVD.getStudio());
            io.print("MPAA rating: " + DVD.getMPAArating());
            io.print("Rating: " + DVD.getUserRating());
            io.print("Comment: " + DVD.getNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD DVDRecord) {
        if(DVDRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String DVDInfo = String.format("Title: %s%nDirector: %s %s%nStudio: %s%nMPAA Rating: %s%n" +
                            "Release Date: %s-%s-%s%nUser Rating: %s%nComment: %s%n",
                    currentDVD.getTitle(),
                    currentDVD.getDirectorFirstName(),
                    currentDVD.getDirectorLastName(),
                    currentDVD.getStudio(),
                    currentDVD.getMPAARating(),
                    currentDVD.getReleaseDay(),
                    currentDVD.getReleaseMonth(),
                    currentDVD.getReleaseYear(),
                    currentDVD.getUserRating(),
                    currentDVD.getNote());
            io.print(DVDInfo);
        }
        io.readString("Hit enter to continue.");
    }

    public int printMenuAndGetSelection() {
        System.out.println("\n***MAIN MENU***" +
                "\n***(1) - List all DVDs in library***" +
                "\n***(2) - Add DVD to library***" +
                "\n***(3) - View DVD in library***" +
                "\n***(4) - Remove DVD in library***"+
                "\n***(5) - Update DVD in library" +
                "\n***(6) - Save and quit***");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public int printUpdateSelection() {
        System.out.println("\nChange:" +
                "\n(0) - Title" +
                "\n(1) - Director's name" +
                "\n(2) - Studio" +
                "\n(3) - MPAA rating" +
                "\n(4) - Release Date"+
                "\n(5) - User Rating" +
                "\n(6) - Note");

        return io.readInt("Please select from the above choices.", 0, 6);
    }
}
