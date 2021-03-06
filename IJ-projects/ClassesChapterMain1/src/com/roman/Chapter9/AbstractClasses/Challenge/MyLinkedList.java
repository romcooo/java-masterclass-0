package com.roman.Chapter9.AbstractClasses.Challenge;

public class MyLinkedList implements MyListInterface {
    private ListItem first, last;
    private int size;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public MyLinkedList(final ListItem first) {
        this.first = first;
    }

    public ListItem getRoot() {
        return first;
    }

    public ListItem getLast() {
        return last;
    }

    public int size() {
        return size;
    }

    public ListItem add(Object toAdd) {
        ListItem newItem = new Node(toAdd);
        boolean atEnd = false;
        boolean atStart = false;

        System.out.println("Entering addItem with: " + toAdd.toString());

        if (this.first == null) {
            this.first = newItem;
            this.last = newItem;
            System.out.println("Adding the first item to the list.");
            System.out.println("Added " + newItem.getValue().toString());
            this.size++;
            return newItem;
        }

        ListItem currentNode = this.getRoot();
        while(!atEnd) {
            System.out.println("Entering loop with currentNode = " + currentNode.getValue().toString());
            if (currentNode.compareTo(newItem.getValue()) == 0) {
                System.out.println("Duplicate item, will not add.");
                break;
            }

            if (!currentNode.hasRight()) {
                atEnd = true;
            }

            if (!currentNode.hasLeft()) {
                atStart = true;
            }

            if (currentNode.compareTo(newItem.getValue()) < 0) { //so the added item should go after
                if (atEnd || (currentNode.getRight().compareTo(newItem.getValue()) > 0)) {
                    currentNode.setItemAsRight(newItem);
                    System.out.println("Adding item: " + newItem.getValue().toString() + " as right to " + currentNode.getValue().toString());
                    if (atEnd) {
                        this.last = newItem;
                    }
                    break;
                } else {
                    currentNode = currentNode.right();
                }
            } else if (currentNode.compareTo(newItem.getValue()) > 0) { //so the added item should go before
                if (atStart || (currentNode.getLeft().compareTo(newItem.getValue()) < 0)) {
                    currentNode.setItemAsLeft(newItem);
                    System.out.println("Adding item: " + newItem.getValue().toString() + " as left to " + currentNode.getValue().toString());
                    if (atStart) {
                        this.first = newItem;
                    }
                    break;
                } else {
                    currentNode = currentNode.left();
                }
            }
        }
        this.size++;
        System.out.println("Added " + newItem.getValue().toString());
        return newItem;
    }

    public ListItem remove(Object toRemove) {
        System.out.println("Entering remove with toRemove: " + toRemove.toString() + " and size: " + this.size);

        if (this.size == 0 && this.first == null && this.last == null) {
            System.out.println("List is empty, cannot remove item.");
            return null;
        }

        ListItem currentNode = this.getRoot();
        boolean atEnd = false;

        while(!atEnd) {
            if (!currentNode.hasRight()) {
                System.out.println("Now at end of list with value: " + currentNode.getValue().toString());
                atEnd = true;
            }

            if (currentNode.compareTo(toRemove) == 0) {
                ListItem nodeToReturn;

                if (this.size == 1) { //is the last item
                    this.first = null;
                    this.last = null;
                    System.out.println("List is now empty.");
                    nodeToReturn = null;
                } else if (this.first.compareTo(toRemove) == 0) { //is first but not last
                    this.first = currentNode.getRight();
                    nodeToReturn = currentNode.getRight();
                    currentNode.remove();
                } else if (this.last.compareTo(toRemove) == 0) {
                this.last = currentNode.getLeft();
                nodeToReturn = currentNode.getLeft();
                currentNode.remove();
                } else {
                    nodeToReturn = currentNode.getRight();
                    currentNode.remove();
                }
                this.size -= 1;
                System.out.println("Removing "+toRemove.toString()+", list now has size: " + this.size);

                if (nodeToReturn != null) {
                    System.out.println("Returning node: "+nodeToReturn.getValue().toString());
                } else {
                    System.out.println("Not returning any node, last item was just removed.");
                }

                return nodeToReturn;
            } else {
                System.out.println("Current node not equal, proceeding to right. Current/toRemove: " + currentNode.getValue().toString() + "/" + toRemove.toString());
                currentNode = currentNode.right();
            }
        }
        System.out.println("No item removed from the list due to no match, input: " + toRemove.toString());
        return null;
    }


}
