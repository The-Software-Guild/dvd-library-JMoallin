package com.m3.c216.DVDLibrary.dto;

import java.io.Serializable;

public class DVD implements Serializable {

    private static String title, directorFirstName, directorLastName, studio, note, MPAArating;
    private static int releaseDay, releaseMonth, releaseYear;
    private static double userRating;

    public DVD(String title){
        this.title = title;
    }

    public DVD(String title, String directorFirstName, String directorLastName,
               String studio, String MPAArating, int releaseDay, int releaseMonth,
               int releaseYear, double userRating, String note) {
        this.title = title;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.studio = studio;
        this.note = note;
        this.MPAArating = MPAArating;
        this.releaseDay = releaseDay;
        this.releaseMonth = releaseMonth;
        this.releaseYear = releaseYear;
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", directorFirstName='" + directorFirstName + '\'' +
                ", directorLastName='" + directorLastName + '\'' +
                ", studio='" + studio + '\'' +
                ", note='" + note + '\'' +
                ", MPAArating='" + MPAArating + '\'' +
                ", releaseDay=" + releaseDay +
                ", releaseMonth=" + releaseMonth +
                ", releaseYear=" + releaseYear +
                ", userRating=" + userRating +
                '}';
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getDirectorFirstName() {
        return directorFirstName;
    }

    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }

    public static String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    public static String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public static String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static String getMPAArating() {
        return MPAArating;
    }

    public static int getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(int releaseDay) {
        this.releaseDay = releaseDay;
    }

    public static int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public static int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public static double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public String getMPAARating() {
        return MPAArating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAArating = MPAARating;
    }

}
