package com.roman.Chapters6and7OOP.Composition.Challenge;

public class Main {
    public static void main(String[] args) {
        Area roomArea = new Area(1000, 500);
        Table roomTable = new Table(4, new Area(100, 200), 100, new Area(0, 500));
        Door roomDoor = new Door(new Area(80, 220), "wood", true, false);
        Chair roomChair1 = new Chair(new Area(50, 50), 4, 60, "kitchen", new Area(0, 300));
        Room room = new Room(roomArea, roomTable, roomDoor, roomChair1);

        room.locateFurniture();
        room.assembleTableAndChairs(new Area(10000, 400));
        room.assembleTableAndChairs(new Area(1000, 300));

        room.openDoor();

        room.getTable().moveTableToPlace(new Area(200, 200));
        room.getChair().moveChairToPlace(new Area(100, 200));

        room.locateFurniture();
        room.openDoor();

        room.closeDoor();
    }
}
