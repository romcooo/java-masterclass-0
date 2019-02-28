package com.roman.Chapter9.AbstractClasses.Challenge;

public class Node extends ListItem {
    public Node(final Object value) {
        super(value);
    }

    /*
    Returns
        - 0 if equal
        - more than 0 if this is greater than the argument
        - less than 0 this is lesser than the argument
     */
    @Override
    public int compareTo(Object object) {
        if (super.getValue().getClass() == object.getClass()) {
            if (object.getClass().getSimpleName().equals("String")) {
                return (super.getValue()
                            .toString()
                            .toLowerCase()
                            .compareTo(object
                                .toString()
                                .toLowerCase()
                            ));
                }
            if (object.getClass().getSimpleName().equals("Integer")) {
                System.out.println("Comparing integers.");
                return ((int) super.getValue() - (int) object);
            }
        }
        //practically else
        return 0;
    }

//    @Override
//    public ListItem add(Object toAdd) {
//        Node newItem = new Node(toAdd);
//        if (this.compareTo(toAdd) == 0) {
//            // if duplicate, will not add
//            System.out.println("Will not add duplicate item.");
//            return this;
//        } else if (this.compareTo(toAdd) > 0) {
//            // if the item to add is lesser than current item, add before
//            System.out.println("Adding " + toAdd.toString() + " into the list BEFORE current item.");
//            if (this.hasPrevious()) {
//                this.getPrevious().setNext(newItem);
//                newItem.setPrevious(this.getPrevious());
//            } else {
//                System.out.println("New item is first in list.");
//            }
//            newItem.setNext(this);
//            this.setPrevious(newItem);
//
//        } else {
//            // if the item to add is greater than current item, add after
//            System.out.println("Adding " + toAdd.toString() + " into the list AFTER current item.");
//            if (this.hasNext()) {
//                this.getNext().setPrevious(newItem);
//                newItem.setNext(this.getNext());
//            } else {
//                System.out.println("New item is last in list.");
//            }
//            newItem.setPrevious(this);
//            this.setNext(newItem);
//        }
//        return newItem;
//    }

//    @Override
//    public boolean remove(Object toRemove) {
//        return false;
//    }

    @Override
    public Node next() {
        return (Node) super.getNext();
    }

    @Override
    public Node previous() {
        return (Node) super.getPrevious();
    }

    public void setItemAsPrevious(ListItem itemToSetAsPrevious) {
        if (this.hasPrevious()) {
            this.previous().setNext(itemToSetAsPrevious);
            itemToSetAsPrevious.setPrevious(this.previous());
        }
        this.setPrevious(itemToSetAsPrevious);
        itemToSetAsPrevious.setNext(this);
    }

    public void setItemAsNext(ListItem itemToSetAsNext) {
        if (this.hasNext()) {
            this.next().setPrevious(itemToSetAsNext);
            itemToSetAsNext.setNext(this.next());
        }
        this.setNext(itemToSetAsNext);
        itemToSetAsNext.setPrevious(this);
    }

    @Override
    public boolean remove() {
        if (this.hasNext()) {
            if (this.hasPrevious()) {
                this.next().setPrevious(this.previous());
                this.previous().setNext(this.next());
                return true;
            } else {
                this.next().setPrevious(null);
                return true;
            }
        } else if (this.hasPrevious()) {
            this.previous().setNext(null);
            return true;
        } else return false;
    }
}
