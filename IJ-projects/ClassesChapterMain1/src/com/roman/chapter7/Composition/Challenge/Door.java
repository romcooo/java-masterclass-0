package com.roman.chapter7.Composition.Challenge;

public class Door {
    private Area size;
    private String material;
    private boolean isLockable;
    private boolean isOpened;

    public Door(final Area size, final String material, final boolean isLockable, final boolean isOpened) {
        this.size = size;
        this.material = material;
        this.isLockable = isLockable;
        this.isOpened = isOpened;
    }

    public Area getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isLockable() {
        return isLockable;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        if (!isOpened) {
            isOpened = true;
            System.out.println("Door has been opened");
        } else {
            System.out.println("Door was already opened before");
        }
    }

    public void close() {
        if (isOpened) {
            isOpened = false;
            System.out.println("Door has been closed");
        } else {
            System.out.println("Door was already closed");
        }
    }

}
