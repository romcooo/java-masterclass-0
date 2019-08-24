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
//            if (this.hasLeft()) {
//                this.getLeft().setRight(newItem);
//                newItem.setLeft(this.getLeft());
//            } else {
//                System.out.println("New item is first in list.");
//            }
//            newItem.setRight(this);
//            this.setLeft(newItem);
//
//        } else {
//            // if the item to add is greater than current item, add after
//            System.out.println("Adding " + toAdd.toString() + " into the list AFTER current item.");
//            if (this.hasRight()) {
//                this.getRight().setLeft(newItem);
//                newItem.setRight(this.getRight());
//            } else {
//                System.out.println("New item is last in list.");
//            }
//            newItem.setLeft(this);
//            this.setRight(newItem);
//        }
//        return newItem;
//    }

//    @Override
//    public boolean remove(Object toRemove) {
//        return false;
//    }

    @Override
    public Node right() {
        return (Node) super.getRight();
    }

    @Override
    public Node left() {
        return (Node) super.getLeft();
    }

    public void setItemAsLeft(ListItem itemToSetAsLeft) {
        if (this.hasLeft()) {
            this.left().setRight(itemToSetAsLeft);
            itemToSetAsLeft.setLeft(this.left());
        }
        this.setLeft(itemToSetAsLeft);
        itemToSetAsLeft.setRight(this);
    }

    public void setItemAsRight(ListItem itemToSetAsRight) {
        if (this.hasRight()) {
            this.right().setLeft(itemToSetAsRight);
            itemToSetAsRight.setRight(this.right());
        }
        this.setRight(itemToSetAsRight);
        itemToSetAsRight.setLeft(this);
    }

    @Override
    public boolean remove() {
        if (this.hasRight()) {
            if (this.hasLeft()) {
                this.right().setLeft(this.left());
                this.left().setRight(this.right());
                return true;
            } else {
                this.right().setLeft(null);
                return true;
            }
        } else if (this.hasLeft()) {
            this.left().setRight(null);
            return true;
        } else return false;
    }
}
