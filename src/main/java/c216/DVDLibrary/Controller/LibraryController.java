package com.m3.c216.DVDLibrary.Controller;
import com.m3.c216.DVDLibrary.dao.LibraryDao;
import com.m3.c216.DVDLibrary.dao.LibraryDaoFileImpl;
import com.m3.c216.DVDLibrary.dto.DVD;
import com.m3.c216.DVDLibrary.ui.LibraryView;
import com.m3.c216.DVDLibrary.ui.UserIO;
import com.m3.c216.DVDLibrary.ui.UserIOConsoleImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class LibraryController {
    private Boolean running;
    private UserIO myIo = new UserIOConsoleImpl();
    private LibraryView view = new LibraryView();
    private LibraryDao dao = new LibraryDaoFileImpl();

    public void run() throws FileNotFoundException {
        running = true;
        int menuSelection = 0;
        while(running){
            menuSelection = getMenuSelection();
            Load();
            switch(menuSelection){
                case 1:
                    listDVD();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    updateDVD();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
        Save();
    }

    private void Save() throws FileNotFoundException {dao.SaveAndQuit();}

    private void Load() throws FileNotFoundException {dao.LoadScript();}


    private void updateDVD() {
        String DVDId = view.getDVDIdChoice();
        int updateDecision = view.printUpdateSelection();
        dao.updateDVD(updateDecision, DVDId);
    }


    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVD() {
        view.displayCreateDVDBanner();
        List<DVD> DVDList = dao.getAllDVD();
        if(DVDList.size()>0){
            view.displayDVDList(DVDList);
        } else {
            System.out.println("Empty library \n");
        }
    }

    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String DVDId = view.getDVDIdChoice();
        DVD DVD = dao.getDVD(DVDId);
        view.displayDVD(DVD);
    }

    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String DVDId = view.getDVDIdChoice();
        DVD removedDVD = dao.removeDVD(DVDId);
        view.displayRemoveResult(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
