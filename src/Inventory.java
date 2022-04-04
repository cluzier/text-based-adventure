import java.util.ArrayList;

class Inventory {

    // Checks if player has item.
    public static boolean playerHasItem(Item itemToCheck) {
        for (Item item: currentInventory) {
            if (item.getItemName().equals(itemToCheck.getItemName()))
                return true;
        }
        return false;
    }

    // Adds an item to the inventory.
    public static void addToInventory(Item itemToAdd) {
        currentInventory.add(itemToAdd);
        System.out.println("Taken.\n");
    }

    // Displays the current inventory in output.
    public static void displayInventory() {
        if (currentInventory.size() == 0)
            System.out.println("Hm... you don't have anything.\n");
        else {
            for (Item item : currentInventory) {
                System.out.println("Your inventory consists of ...");
                System.out.println(item.getItemName());
                System.out.println();
            }
        }
    }

    private static ArrayList<Item> currentInventory = new ArrayList<Item>();
}
