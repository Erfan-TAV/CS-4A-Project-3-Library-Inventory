import exceptions.InvalidCompartmentException;
import exceptions.InvalidLocationException;
import exceptions.ItemNotFoundException;
import items.Item;
import java.util.ArrayList;

public class LibraryStorage {
    private final ArrayList<Item[]> shelves;
    private final int COMPARTMENTS = 15;

    public LibraryStorage() {
        this.shelves = new ArrayList<>();
    }

    private boolean isValidLocation(int shelf, int compartment) throws  InvalidLocationException {
        if (shelf < 0 || shelf >= shelves.size()) {
            throw new InvalidLocationException("Invalid Shelf Location");
        }
        if (compartment < 0 || compartment >= COMPARTMENTS) {
            throw new InvalidLocationException("Invalid Compartment Location, index must be less than 15");
        }
        return true;
    }
    private boolean itemExists(int shelf, int compartment) throws ItemNotFoundException {
        if(shelves.get(shelf)[compartment] == null) {
            throw new ItemNotFoundException("There is no item in this location [" + shelf + "][" + compartment + "]");
        }
        if(shelves.get(shelf)[compartment].isCheckedOut()) {
            throw new ItemNotFoundException("The item is checked out in this location [" + shelf + "][" + compartment + "]");
        }
        return true;
    }

    public void addNewShelf() {
        shelves.add(new Item[COMPARTMENTS]);
        System.out.println("New shelf added. Total shelves: " + shelves.size());
    }
    public void deleteShelf(int shelfIndex) {
        try {
            if (shelfIndex >= 0 && shelfIndex < shelves.size()) {
                shelves.remove(shelfIndex);
            } else {
                throw new InvalidLocationException("Shelf doesnt exist");
            }
        } catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addItem(int shelfIndex, int compartment, Item item) {
        try {
            if (isValidLocation(shelfIndex, compartment)) {
                if (shelves.get(shelfIndex)[compartment] == null) {
                    shelves.get(shelfIndex)[compartment] = item;
                }
                else {
                    throw new InvalidLocationException("Compartment already filled");
                }
            }
        }
        catch (InvalidCompartmentException | InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void deleteItem(int shelfIndex, int compartment) {
        try {
            if (isValidLocation(shelfIndex, compartment)) {
                if (shelves.get(shelfIndex)[compartment] != null) {
                    shelves.get(shelfIndex)[compartment] = null;
                }
                else {
                    throw new InvalidCompartmentException("Compartment already empty");
                }
            }
        }  catch (InvalidLocationException | InvalidCompartmentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void swapItem(int shelf1, int compartment1,
                         int shelf2, int compartment2) {
        Item temp;
        try {
            if(isValidLocation(shelf1, compartment1) && isValidLocation(shelf2, compartment2)) {
                if (itemExists(shelf1, compartment1) && itemExists(shelf2, compartment2)) {
                    temp = shelves.get(shelf1)[compartment1];
                    shelves.get(shelf1)[compartment1] = shelves.get(shelf2)[compartment2];
                    shelves.get(shelf2)[compartment2] = temp;
                }
            }
        } catch (InvalidLocationException | ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void checkoutItem(int shelf, int compartment, String borrowerName, int borrowPeriod) {
        try {
            if (isValidLocation(shelf, compartment)) {
                if (itemExists(shelf, compartment)) {
                    shelves.get(shelf)[compartment].markCheckedOut(borrowerName, borrowPeriod);
                }
            }
        } catch (InvalidLocationException | ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: " + "There is no item in the compartment");
        }
    }
    public void returnItem(int shelf, int compartment) {
        try {
            if (isValidLocation(shelf, compartment) && itemExists(shelf, compartment)) {
                shelves.get(shelf)[compartment].markReturned();
            }
        } catch (InvalidLocationException | ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printItemsInStorage() {
        System.out.println("ITEMS CURRENTLY IN STORAGE");
        System.out.println("--------------------------");
        for (int i = 0; i < shelves.size(); i++) {
            System.out.println("Shelf #" + i);
            Item[] currentShelf = shelves.get(i);

            for (int j = 0; j < COMPARTMENTS; j++) {
                Item item = currentShelf[j];

                // Only print if the compartment has an item and it's NOT checked out
                if (item != null && !item.isCheckedOut()) {
                    System.out.println("  ├─ [Comp " + j + "] " + item.getName() + " (ID: " + item.getId() + ")");
                    System.out.println("  │    └─ " + item.getDescription());
                }
            }
            System.out.println("  └───────────────────────────────");
        }
    }
    public void printCheckedOutItems() {
        System.out.println("CHECKED OUT ITEMS");
        System.out.println("--------------------------");
        boolean anyFound = false;

        for (int i = 0; i < shelves.size(); i++) {
            Item[] currentShelf = shelves.get(i);

            for (int j = 0; j < COMPARTMENTS; j++) {
                Item item = currentShelf[j];

                if (item != null && item.isCheckedOut()) {
                    anyFound = true;
                    System.out.println("Shelf " + i + ", Compartment " + j);
                    System.out.println("  ├─ Item: " + item.getName());
                    System.out.println("  ├─ Borrower: " + item.getBorrowerName());
                    System.out.println("  └─ Due Date: " + item.getDueDate());
                    System.out.println();
                }
            }
        }

        if (!anyFound) {
            System.out.println("No items are currently checked out.");
        }
    }
}
