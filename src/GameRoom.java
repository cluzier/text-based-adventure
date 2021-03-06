import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

class Room
{
    private String description;
    //private Item itemInRoom;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        //this.itemInRoom = itemInRoom;
        exits = new HashMap<String, Room>();
    }

    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
        if(up != null)
            exits.put("up", up);
        if(down != null)
            exits.put("down", down);
    }

    public String longDescription()
    {
        return description + ".\n" + exitString();
    }

    public String exitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(Iterator<String> iter = keys.iterator(); iter.hasNext(); )
            returnString += " " + iter.next();
        return returnString;
    }

    public Room nextRoom(String direction)
    {
        return (Room)exits.get(direction);
    }

    public void displayItemsInRoom() {
        for (Item item: Items.gameItems) {
            if (item.getLocation() == this) {
                System.out.println("Take what? In this room, there is ...");
                System.out.println(item.getItemName() + "\n");
                return;
            }
            System.out.println("Nothing to take.\n");
        }
    }
}
