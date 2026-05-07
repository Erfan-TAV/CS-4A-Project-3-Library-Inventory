import exceptions.InvalidCompartmentException;
import exceptions.InvalidLocationException;
import items.Book;
import items.Item;
import items.Magazine;
import items.Movie;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryStorage library = new LibraryStorage();

        System.out.println("Create shelves");
        for (int i = 0; i < 3; i++) {
            library.addNewShelf();
        }
        System.out.println("done");


        System.out.println("Creating objects");
        Book book1 = new Book(
                "Physical Book",
                "Hardcover first edition",
                101,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                LocalDate.of(1925, 4, 10)
        );
        Book book2 = new Book(
                "Educational Resource",
                "Introduction to Java programming",
                102,
                "Java: A Beginner's Guide",
                "Herbert Schildt",
                LocalDate.of(2018, 11, 9)
        );
        Magazine mag1 = new Magazine(
                "Periodical",
                "Science and technology monthly",
                201,
                542,
                "The Future of AI"
        );
        Magazine mag2 = new Magazine(
                "News Print",
                "Global weekly news coverage",
                202,
                1204,
                "Election Results 2024"
        );
        String[] inceptionCast = {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"};
        Movie movie1 = new Movie(
                "Blu-ray Disc",
                "Sci-fi thriller about dreams",
                301,
                "Inception",
                "Christopher Nolan",
                inceptionCast
        );
        String[] toyStoryCast = {"Tom Hanks", "Tim Allen"};
        Movie movie2 = new Movie(
                "Digital Copy",
                "Animated adventure about toys",
                302,
                "Toy Story",
                "John Lasseter",
                toyStoryCast
        );
        System.out.println("done");

        try {

        }
        catch (InvalidCompartmentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Adding items to shelves/compartments");
        try {
            library.addItem(0, 0, book1);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.addItem(0, 1, book2);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.addItem(1, 0, mag1);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.addItem(1, 1, mag2);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.addItem(2, 0, movie1);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            library.addItem(2, 1, movie2);
        }
        catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("done");

        library.printItemsInStorage();
        library.printCheckedOutItems();

        System.out.println("Swap movie shelf and magazine shelf");
        library.swapItem(1,0, 2, 0);
        library.swapItem(1,1, 2, 1);
        System.out.println("done");
        library.printItemsInStorage();

        System.out.println("testing checking out system");
        library.printCheckedOutItems();
        library.checkoutItem(0,1, "Erfan", 14);
        library.checkoutItem(2,1, "Aiden", 14);
        library.printCheckedOutItems();
        library.returnItem(0,1);
        library.returnItem(2,1);
        library.printCheckedOutItems();
        System.out.println("done\n");

        System.out.println("Testing error handling");
        library.swapItem(1,4, 1, 3);

        library.checkoutItem(0,3, "Erfan", 14);
        library.returnItem(0,3);

        library.deleteItem(0,3);
        library.addItem(0,30,new Book());
        library.deleteShelf(4);
        System.out.println("done");
    }
}