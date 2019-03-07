package com.roman.Chapter9.AbstractClasses.Challenge;

public class BinarySearchTree {
    private ListItem first, left, right;
    private int size;

    public BinarySearchTree() {
        this.first = null;
        this.left = null;
        this.right = null;
        size = 0;
    }

    public ListItem getFirst() {
        return first;
    }

    public ListItem getLeft() {
        return left;
    }

    public ListItem getRight() {
        return right;
    }

    public int getSize() {
        return size;
    }

    public ListItem add(Object toAdd) {
        ListItem newItem = new Node(toAdd);
        boolean atEnd = false;
        boolean atStart = false;

        System.out.println("Entering addItem with: " + toAdd.toString());

        if (this.first == null) {
            this.first = newItem;

            System.out.println("Adding the first item to the list.");
            System.out.println("Added " + newItem.getValue().toString());
            this.size++;
            return newItem;
        }

        ListItem currentNode = this.getFirst();
        while(!atEnd) {
            System.out.println("Entering loop with currentNode = " + currentNode.getValue().toString());
            if (currentNode.compareTo(newItem.getValue()) == 0) {
                System.out.println("Duplicate item, will not add.");
                break;
            }

            if (!currentNode.hasNext()) {
                atEnd = true;
            }

            if (!currentNode.hasPrevious()) {
                atStart = true;
            }

            if (currentNode.compareTo(newItem.getValue()) < 0) { //so the added item should go after
                if (atEnd || (currentNode.getNext().compareTo(newItem.getValue()) > 0)) {
                    currentNode.setItemAsNext(newItem);
                    this.right = currentNode;
                    System.out.println("Adding item: " + newItem.getValue().toString() + " to the right of " + currentNode.getValue().toString());
//                    if (atEnd) {
//                        this.last = newItem;
//                    }
                    break;
                } else {
                    currentNode = currentNode.next();
                }
            } else if (currentNode.compareTo(newItem.getValue()) > 0) { //so the added item should go before
                if (atStart || (currentNode.getPrevious().compareTo(newItem.getValue()) < 0)) {
                    currentNode.setItemAsPrevious(newItem);
                    this.left = currentNode;
                    System.out.println("Adding item: " + newItem.getValue().toString() + " to the left of " + currentNode.getValue().toString());
                    if (atStart) {
                        this.first = newItem;
                    }
                    break;
                } else {
                    currentNode = currentNode.previous();
                }
            }
        }
        this.size++;
        System.out.println("Added " + newItem.getValue().toString());
        return newItem;
    }
}
