package com.roman.chapter7.Composition.Challenge;

public class Room {
    private Area area;
    private Table table;
    private Door door;
    private Chair chair;

    public Room(final Area area, final Table table, final Door door, final Chair chair) {
        this.area = area;
        this.table = table;
        this.door = door;
        this.chair = chair;
    }

    public Area getArea() {
        return area;
    }

    public Table getTable() {
        return table;
    }

    public Chair getChair() {
        return chair;
    }

    public void openDoor() {
        door.open();
    }

    public void closeDoor() {
        door.close();
    }

    public void assembleTableAndChairs(Area location) {
        if (location.getX() >= 0 && location.getX() <= area.getX() && location.getY() >= 0 && location.getY() <= area.getY() ) {
            table.moveTableToPlace(location);
            chair.moveChairToPlace(location);
            System.out.println("Table and chairs assembled at location X: " + location.getX() + ", Y: " + location.getY());
        } else {
            System.out.println("Location is outside of this room");
        }
    }

    public void locateFurniture() {
        System.out.println("Table is at location: ");
        table.getLocation().printLocation();
        System.out.println("Chair is at location: ");
        chair.getLocation().printLocation();
    }
}
