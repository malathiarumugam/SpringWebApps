package com.mycompany.dto;


import com.mycompany.Operations.DVDLibrary;
import com.mycompany.dao.FileIO;
import com.mycompany.UI.ConsoleIO;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    
    

    ConsoleIO io = new ConsoleIO();
    FileIO fio = new FileIO();
    DvdLibraryDao lib;
    
    public Controller(DvdLibraryDao libr){
        lib = libr;
    }
    
    public void runProgram() {
        int userChoice = 0;
        
        for (DVD d : fio.readDVDs("mylibrary.dlb")) {
            lib.getAllDVD().add(d);
        }
        while (userChoice != 9) {
            userChoice = io.readInteger("1. Add a DVD to your collection\n"
                    + "2. Remove a DVD from your collection\n"
                    + "3. List all DVDs in your collection\n"
                    + "4. Count copies of a given DVD in your collection\n"
                    + "5. Display detailed info for a DVD\n"
                    + "6. Change info for a DVD in your collection\n"
                    + "=============================================\n"
                    + "7. Find all movies with a MPAA rating\n"
                    + "8. Find all movies by a given studio\n"
                    + "=============================================\n"
                    + "9. Quit",
                    1, 9);

            switch (userChoice) {
                case 1:
                    menuAddDVD();
                    break;
                case 2:
                    menuRemoveDVD();
                    break;
                case 3:
                    menuListAllDVD();
                    break;
                case 4:
                    menuFindDVDCount();
                    break;
                case 5:
                    menuDisplayInfo();
                    break;
                case 6:
                    menuChangeDVDInfo();
                    break;
                case 7:
                    menuFindDVDsWithRating();
                    break;
                case 8:
                    menuFindDVDsByStudio();
                    break;
            }

        }
        fio.writeDVDs("mylibrary.dlb", lib.getAllDVD());
        io.write("Files saved to \"mylibrary.dlb\"\n");
        io.write("Happy viewing! Goodbye.\n");
    }

    public void menuAddDVD() {
        DVD newDVD = new DVD();
        io.write("Please enter the info for the DVD you want to add.\n");
        newDVD.setTitle(io.readString("Title: "));
        newDVD.setReleaseDate(LocalDate.parse(io.readString("Release Date: ")));
        newDVD.setMpaaRating(io.readString("MPAA Rating: "));
        newDVD.setDirector(io.readString("Director: "));
        newDVD.setStudio(io.readString("Studio: "));
        newDVD.setNote(io.readString("Comments: "));
        lib.add(newDVD);
        io.write("\n" + newDVD.getTitle() + " ADDED!\n\n");
    }

    public void menuRemoveDVD() {
        String title;
        int choice;
        DVD dvd;
        List <DVD> removeLibrary;
        title = io.readString("Enter the title of the DVD you want to remove: ");
        removeLibrary = lib.getByTitle(title);
        if (lib.getByTitle(title) == null) {
            io.write("Unfortunately that title was not found.\n\n");
        } else {
            io.write2(removeLibrary);
            choice = io.readInteger("Really delete this title? (1: Delete 2: Return to menu)\n", 1, 2);
            if (choice == 1) {
                dvd = lib.findDVD(title);
                lib.remove(dvd.getId());
                io.write("\n" + title + " DELETED!\n\n");
            }
        }
    }

    public void menuListAllDVD() {
        ArrayList<DVD> alldvd = lib.getAllDVD();
        for (DVD d : alldvd) {
            io.write(d.toString() + "\n");
        }
    }

    public void menuFindDVDCount() {
        String title;
        title = io.readString("Enter the title of the DVD you want to find: ");
        io.write("Found " + lib.findDVDCount(title) + " entries matching that title.\n\n");
    }

    public void menuDisplayInfo() {
        String title;
        List<DVD> displayLibrary;
        title = io.readString("Enter the title of the DVD you want to display: ");
        displayLibrary = lib.getByTitle(title);
        if (lib.getByTitle(title) == null) {
            io.write("Unfortunately that title was not found.\n\n");
        } else {
            io.write2(displayLibrary);
        }
    }

    public void menuChangeDVDInfo() {
        int userChoice = 0;
        String title;
        DVD dvd;
        List <DVD> changeLibrary;
        title = io.readString("Enter the title of the DVD you want to edit: ");
        changeLibrary = lib.getByTitle(title);
        if (lib.getByTitle(title) == null) {
            io.write("Unfortunately that title was not found.\n\n");
        } else {
            io.write2(changeLibrary);
            dvd = lib.findDVD(title);
            while (userChoice != 7) {
                userChoice = io.readInteger("1. Change title\n"
                        + "2. Change release date\n"
                        + "3. Change rating\n"
                        + "4. Change director\n"
                        + "5. Change studio\n"
                        + "6. Change comment\n"
                        + "7. Return to main menu\n", 1, 7);
                switch (userChoice) {
                    case 1:
                        dvd.setTitle(io.readString("New title: "));
                        break;
                    case 2:
                        dvd.setReleaseDate(LocalDate.parse(io.readString("New release date: ")));
                        break;
                    case 3:
                        dvd.setMpaaRating(io.readString("New rating: "));
                        break;
                    case 4:
                        dvd.setDirector(io.readString("New director: "));
                        break;
                    case 5:
                        dvd.setStudio(io.readString("New studio: "));
                        break;
                    case 6:
                        dvd.setNote(io.readString("New comment: "));
                        break;
                }
            }
        }
    }

//    public void menuFindRecentDVDs() {
//        int years;
//        List<DVD> results;
//        years = io.readInteger("How far back do you want to look? ", 0, 115);
//        results = lib.findRecentDVDs(years);
//        for (DVD d : results) {
//            io.write(d.toString());
//        }
//    }

    public void menuFindDVDsWithRating() {
        int choice;
        String rating = "";
        List<DVD> results;
        choice = io.readInteger("Which rating are you looking for? (1 - G, 2 - PG, 3 - PG13, 4 - R, 5 - NC17", 1, 5);
        switch (choice) {
            case 1:
                rating = "G";
                break;
            case 2:
                rating = "PG";
                break;
            case 3:
                rating = "PG13";
                break;
            case 4:
                rating = "R";
                break;
            case 5:
                rating = "NC17";
                break;
        }
        results = lib.getByRating(rating);
        for (DVD d : results) {
            io.write(d.toString());
        }
    }

    // More crap to do here
//    public void menuFindDVDsByDirector() {
//        String director = "";
//        List<DVD> results;
//        List<List<DVD>> listOfList = new LinkedList();
//        Set<String> ratings = new TreeSet();
//        director = io.readString("Which director are you looking for? ");
//        results = lib.ge(director);
//        if (results.isEmpty()) {
//            io.write("Unfortunately, no results were found.\n\n");
//        } else {
//            for (DVD d : results) {
//                ratings.add(d.getRating());
//            }
//
//            for (String k : ratings) {
//                List<DVD> temp = results
//                        .stream()
//                        .filter(s -> s.getRating().equals(k))
//                        .collect(Collectors.toList());
//                listOfList.add(temp);
//            }
//
//            for (List<DVD> ldvd : listOfList) {
//                for (DVD d : ldvd) {
//                    io.write(d.toString());
//                }
//            }
//        }
//    }

    public void menuFindDVDsByStudio() {
        String studio = "";
        List<DVD> results;
        studio = io.readString("Which studio are you looking for? ");
        results = lib.getByStudio(studio);
        if (results.isEmpty()) {
            io.write("Unfortunately, no results were found.\n\n");
        } else {
            for (DVD d : results) {
                io.write(d.toString());
            }
        }
    }

//    public void menuFindAgeOfCollection() {
//        io.write("\nThe average age of your collection is " + lib.findAgeOfCollection() + " years.\n\n");
//    }
//
//    public void menuFindNewest() {
//        List<DVD> results = lib.findNewest();
//        for (DVD d : results) {
//            io.write(d.toString());
//        }
//    }
//
//    public void menuFindOldest() {
//        List<DVD> results = lib.findOldest();
//        for (DVD d : results) {
//            io.write(d.toString());
//        }
//    }
}
