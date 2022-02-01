public class Game {
    private Parser parser;
    private Room currentRoom;

    // Placed these outside of createRooms() method, so I could give items a location (bottom of this file).
    // Is there a better way? - Joshua
    private Room start, nt, et, st, wt, ut, dt;

    public Game() {
        createRooms();
        createItems();
        parser = new Parser();
    }

    private void createRooms() {
        //Room start, nt, et, st, wt, ut, dt;

        start = new Room("There are four doors around you. You can also go up and down.");
        nt = new Room("You went north from the starting area.");
        et = new Room("You went east from the starting area.");
        st = new Room("You went south from the starting area.");
        wt = new Room("You went west from the starting area.");
        ut = new Room("You went up from the starting area.");
        dt = new Room("You went down from the starting area. This room is infested with zombies!");

        start.setExits(nt, et, st, wt, ut, dt);
        nt.setExits(null, null, start, null, null, null);
        et.setExits(null, null, null, start, null, null);
        st.setExits(start, null, null, null, null, null);
        wt.setExits(null, start, null, null, null, null);
        ut.setExits(null, null, null, null, null, start);
        dt.setExits(null, null, null, null, start, null);
        currentRoom = start;
    }


    public void play() {
        printWelcome();
        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to our Mansion Escape Game!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.longDescription());
    }

    private boolean processCommand(Command command)
    {
        //if the command is invalid return:
        if (command.isUnknown()) {
            System.out.println("Unknown command, try again.");
            return false;
        }

        String commandWord = command.getFirstWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("inventory"))
            Inventory.displayInventory();
        else if (commandWord.equals("take"))
            takeItem(command);
//        else if (commandWord.equals("health"))
//            getHealth();
//        else if (commandWord.equals("damage"))
//            getDamagedHealth();
//        else if (commandWord.equals("suicide"))
//            killPlayer();
        else if (commandWord.equals("quit")) {
            if (command.hasSecondWord())
                return true;
            else
                return true;
        }
        return false;
    }

    private void printHelp() {
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println(currentRoom.longDescription());
    }

    private void goRoom(Command command) {
        //if user enters "go" as firstWord without second word, print secondWord options
        if (!command.hasSecondWord())
        {
            System.out.println("Go where? " + currentRoom.exitString());
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.nextRoom(direction);

        //if there is a door, print to console
        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.longDescription());

            // Check if any item locations are in the current room.
            for (Item item: Items.gameItems) {
                if (item.getLocation() == currentRoom) {
                    System.out.println("There is a " + item.getItemName() + " here.\n");
                    return;
                }
            }
        }
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord())
        {
            currentRoom.displayItemsInRoom();
            return;
        }

        String itemName = command.getSecondWord();
        for (Item item: Items.gameItems) {
            if (itemName.equals(item.getItemName())) {
                Inventory.addToInventory(item);
                return;
            }

            // Item not found.
            System.out.println("That's not here!");
        }
    }

    private void createItems() {
        Items.shovel.setLocation(nt);
        Items.candle.setLocation(null);
    }
}
