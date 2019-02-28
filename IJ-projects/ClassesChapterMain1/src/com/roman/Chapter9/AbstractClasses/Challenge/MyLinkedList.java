package com.roman.Chapter9.AbstractClasses.Challenge;

public class MyLinkedList {
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

    public ListItem getFirst() {
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

        if (this.first == null) {
            this.first = newItem;
            this.last = newItem;
            System.out.println("Adding the first item to the list: " + newItem.getValue().toString());
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
                    System.out.println("Adding item: " + newItem.getValue().toString() + " as next to " + currentNode.getValue().toString());
                    if (atEnd) {
                        this.last = newItem;
                    }
                    break;
                } else {
                    currentNode = currentNode.next();
                }
            } else if (currentNode.compareTo(newItem.getValue()) > 0) { //so the added item should go before
                if (atStart || (currentNode.getPrevious().compareTo(newItem.getValue()) < 0)) {
                    currentNode.setItemAsPrevious(newItem);
                    System.out.println("Adding item: " + newItem.getValue().toString() + " as previous to " + currentNode.getValue().toString());                } else {
                    currentNode = currentNode.previous();
                    if (atStart) {
                        this.first = newItem;
                    }
                    break;
                }
            }
        }
        this.size++;
        System.out.println("Added " + newItem.getValue().toString());
        return newItem;
    }

    public ListItem remove(Object toRemove) {
        if (this.size == 0) {
            System.out.println("List is empty, cannot remove item.");
        }
        ListItem currentNode = this.getFirst();
        boolean atEnd = false;

        while(!atEnd) {
            if (!currentNode.hasNext()) {
                atEnd = true;
            }
            if (currentNode.compareTo(toRemove) == 0) {
                if (this.first == currentNode) {
                    if (currentNode.hasNext()) {
                        currentNode.getNext().setPrevious(null);
                    }
                }

            }
        }
        return null;
    }


}
