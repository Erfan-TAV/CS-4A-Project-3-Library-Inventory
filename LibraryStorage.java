import items.Item;

import java.util.ArrayList;

public class LibraryStorage {
    private final ArrayList<Item[]> shelves;
    private final int COMPARTMENTS = 15;
//    private ArrayList<Item> checkedoutItems;

    public LibraryStorage() {
        this.shelves = new ArrayList<>();
//        this.checkedoutItems = new ArrayList<>();
    }

    private boolean isValidLocation(int shelf, int compartment) {
        if (shelf < 0 || shelf >= shelves.size()) {
            // TODO: Throw shelf doesn't exist
            return false;
        }
        if (compartment < 0 || compartment >= COMPARTMENTS) {
            // TODO: Throw compartment doesn't exist
            return false;
        }
        return true;
    }

    public void addNewShelf() {
        shelves.add(new Item[COMPARTMENTS]);
        System.out.println("New shelf added. Total shelves: " + shelves.size());
    }
    public void deleteShelf(int shelfIndex) {
        if (shelfIndex >= 0 && shelfIndex < shelves.size()) {
            shelves.remove(shelfIndex);
        } else {
            // TODO: throw exception
        }

    }

    public void addItem(int shelfIndex, int compartment, Item item) {
        if (isValidLocation(shelfIndex, compartment)) {
            if (shelves.get(shelfIndex)[compartment] == null) {
                shelves.get(shelfIndex)[compartment] = item;
            }
            else {
                // TODO: throw compartment not empty
            }
        }
    }
    public void deleteItem(int shelfIndex, int compartment) {
        if (isValidLocation(shelfIndex, compartment)) {
            if (shelves.get(shelfIndex)[compartment] != null) {
                shelves.get(shelfIndex)[compartment] = null;
            }
            else {
                // TODO: throw compartment empty
            }
        }
    }

    public void swapItem(int shelf1, int compartment1,
                         int shelf2, int compartment2) {
        Item temp;
        if(isValidLocation(shelf1, compartment1) && isValidLocation(shelf2, compartment2)) {
            temp = shelves.get(shelf1)[compartment1];
            shelves.get(shelf1)[compartment1] = shelves.get(shelf2)[compartment2];
            shelves.get(shelf2)[compartment2] = temp;
        }
    }

    public void checkoutItem(int shelf, int compartment, String borrowerName) {
        shelves.get(shelf)[compartment].markCheckedOut(borrowerName, 14);
    }
    public void returnItem(int shelf, int compartment) {
        shelves.get(shelf)[compartment].markReturned();
    }

//    public void printItemsStorage() {
//
//    }

    public void printItemsInStorage() {
        System.out.println("=== ITEMS CURRENTLY IN STORAGE ===");
        for (int i = 0; i < shelves.size(); i++) {
            System.out.println("Shelf #" + i);
            Item[] currentShelf = shelves.get(i);

            for (int j = 0; j < COMPARTMENTS; j++) {
                Item item = currentShelf[j];

                // Only print if the compartment has an item and it's NOT checked out
                if (item != null && !item.isCheckedOut()) {
                    System.out.println("  │");
                    System.out.println("  ├─ [Comp " + j + "] ──── " + item.getName() + " (ID: " + item.getId() + ")");
                    System.out.println("  │    └─ " + item.getDescription());
                }
            }
            System.out.println("  ┴───────────────────────────────");
        }
    }

    public void printCheckedOutItems() {
        System.out.println("=== CHECKED OUT ITEMS ===");
        boolean anyFound = false;

        for (int i = 0; i < shelves.size(); i++) {
            Item[] currentShelf = shelves.get(i);

            for (int j = 0; j < COMPARTMENTS; j++) {
                Item item = currentShelf[j];

                if (item != null && item.isCheckedOut()) {
                    anyFound = true;
                    System.out.println("Shelf [" + i + "] ──── Comp [" + j + "]");
                    System.out.println("  │");
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
