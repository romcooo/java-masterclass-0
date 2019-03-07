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

        System.out.println("Entering addItem with: " + toAdd.toString());

        if (this.first == null) {
            this.first = newItem;
            this.last = newItem;
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
                    System.out.println("Adding item: " + newItem.getValue().toString() + " as previous to " + currentNode.getValue().toString());
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

    public ListItem remove(Object toRemove) {
        System.out.println("Entering remove with toRemove: " + toRemove.toString() + " and size: " + this.size);

        if (this.size == 0 && this.first == null && this.last == null) {
            System.out.println("List is empty, cannot remove item.");
            return null;
        }

        ListItem currentNode = this.getFirst();
        boolean atEnd = false;

        while(!atEnd) {
            if (!currentNode.hasNext()) {
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
                    this.first = currentNode.getNext();
                    nodeToReturn = currentNode.getNext();
                    currentNode.remove();
                } else if (this.last.compareTo(toRemove) == 0) {
                this.last = currentNode.getPrevious();
                nodeToReturn = currentNode.getPrevious();
                currentNode.remove();
                } else {
                    nodeToReturn = currentNode.getNext();
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
                System.out.println("Current node not equal, proceeding to next. Current/toRemove: " + currentNode.getValue().toString() + "/" + toRemove.toString());
                currentNode = currentNode.next();
            }
        }
        System.out.println("No item removed from the list due to no match, input: " + toRemove.toString());
        return null;
    }


}
