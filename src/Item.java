class Item {

    public Item(String name, boolean isWeapon) {
        this.name = name;
        this.isWeapon = isWeapon;
    }

    public String getItemName() {
        return this.name;
    }

    public Room getLocation() {
        return this.location;
    }
    public void setLocation(Room location) {
        this.location = location;
    }

    private String name;
    private boolean isWeapon;

    private Room location;
}
