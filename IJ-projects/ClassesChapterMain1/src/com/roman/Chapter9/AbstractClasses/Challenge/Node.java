package com.roman.Chapter9.AbstractClasses.Challenge;

public class Node extends ListItem {
    public Node(final Object value) {
        super(value);
    }

    @Override
    public int compareTo(Object object) {
        if (getValue().getClass() == object.getClass()) {
            if (object.getClass().getSimpleName().equals("String")) {
                return (getValue()
                            .toString()
                            .toLowerCase()
                            .compareTo(object
                                .toString()
                                .toLowerCase()
                            ));
                }
            if (object.getClass().getSimpleName().equals("Integer")) {
                System.out.println("Comparing integers.");
                return ((int) getValue() - (int) object);
            }
        }
        //practically else
        return 0;
    }

    @Override
    public ListItem add(Object toAdd) {
        Node newItem = new Node(toAdd);
        if (this.compareTo(toAdd) == 0) {
            // if duplicate, will not add
            System.out.println("Will not add duplicate item.");
            return this;
        } else if (this.compareTo(toAdd) > 0) {
            // if the item to add is lesser than current item, add before
            System.out.println("Adding " + toAdd.toString() + " into the list BEFORE current item.");
            if (this.hasPrevious()) {
                this.getPrevious().setNext(newItem);
                newItem.setPrevious(this.getPrevious());
            } else {
                System.out.println("New item is first in list.");
            }
            newItem.setNext(this);
            this.setPrevious(newItem);

        } else {
            // if the item to add is greater than current item, add after
            System.out.println("Adding " + toAdd.toString() + " into the list AFTER current item.");
            if (this.hasNext()) {
                this.getNext().setPrevious(newItem);
                newItem.setNext(this.getNext());
            } else {
                System.out.println("New item is last in list.");
            }
            newItem.setPrevious(this);
            this.setNext(newItem);
        }
        return newItem;
    }

    @Override
    public boolean remove(Object toRemove) {
        return false;
    }

    @Override
    public Node next() {
        return this.next();
    }

    @Override
    public Node previous() {
        return this.previous();
    }
}
