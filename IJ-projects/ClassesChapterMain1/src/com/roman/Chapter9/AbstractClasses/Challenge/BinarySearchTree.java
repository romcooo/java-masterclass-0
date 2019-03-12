package com.roman.Chapter9.AbstractClasses.Challenge;

public class BinarySearchTree implements MyListInterface {
    private ListItem root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public BinarySearchTree(Object root) {
        ListItem rootListItem = new Node(root);
        this.root = rootListItem;
        this.size = 1;
    }

    public ListItem getRoot() {
        return this.root;
    }

    public int size() {
        return this.size;
    }

    public ListItem add(Object toAdd) {
        ListItem newItem = new Node(toAdd);
        boolean atRightEnd;
        boolean atLeftEnd;
        boolean keepSearching = true;

        System.out.println("Trying to add item to tree: " + toAdd.toString());

        if (this.root == null) {
            this.root = newItem;

            System.out.println("Adding root.");
            System.out.println("Added " + newItem.getValue().toString());
            this.size++;
            return newItem;
        }

        ListItem currentNode = this.getRoot();

        while(keepSearching) {
            System.out.println("Entering loop with currentNode = " + currentNode.getValue().toString());
            System.out.println("CurrentNode.compareTo(newItem): " + currentNode.compareTo(newItem.getValue()));
            if (currentNode.compareTo(newItem.getValue()) == 0) {
                System.out.println("Duplicate item, will not add.");
                break;
            }

            if (!currentNode.hasRight()) {
                atRightEnd = true;
                System.out.println("At right end with current node: "+currentNode.getValue());
            } else {
                atRightEnd = false;
            }

            if (!currentNode.hasLeft()) {
                atLeftEnd = true;
                System.out.println("At left end with current node: "+currentNode.getValue());
            } else {
                atLeftEnd = false;
            }

            if (currentNode.compareTo(newItem.getValue()) < 0) { //so the added item should go to the right
                if (atRightEnd) {
                    currentNode.setRight(newItem);
                    System.out.println("Adding item: " + newItem.getValue().toString() + " to the right of " + currentNode.getValue().toString());
                    keepSearching = false;
                } else {
                    currentNode = currentNode.right();
                }
            } else if (currentNode.compareTo(newItem.getValue()) > 0) { //so the added item should go to the left
                if (atLeftEnd) {
                    currentNode.setLeft(newItem);
                    System.out.println("Adding item: " + newItem.getValue().toString() + " to the left of " + currentNode.getValue().toString());
                    keepSearching = false;
                } else {
                    currentNode = currentNode.left();
                }
            } else {
                System.out.println("Duplicate item, will not add.");
                break;
            }
        }
        this.size++;
        System.out.println("Added " + newItem.getValue().toString());
        System.out.println();
        return newItem;
    }

    public ListItem remove(Object toRemove) {
        ListItem currentItem = this.root;
        while (currentItem != null) {
            if (currentItem.compareTo(toRemove) > 0) { //if item to remove is less than current
                if (currentItem.hasLeft()) { //if there is a item less than current in tree
                    if (currentItem.getLeft().compareTo(toRemove) == 0) { //if the next left item is the one to be removed
                        leftItemRemoval(currentItem);

                    }
                    currentItem = currentItem.getLeft();
                } else {
                    System.out.println("Value to be removed is not present");
                    return null;
                }
            } else if (currentItem.compareTo(toRemove) < 0) {
                if (currentItem.hasRight()) {
                    if (currentItem.getRight().compareTo(toRemove) == 0) {
                        rightItemRemoval(currentItem);
                    }
                    currentItem = currentItem.getRight();
                } else {
                    System.out.println("Value to be removed is not present");
                    return null;
                }
            } else if (currentItem.compareTo(toRemove) == 0) {
                System.out.println("Root should be removed.");
            }
        }
        return null;
    }

    private void leftItemRemoval(ListItem currentItem) {
        ListItem leftItem = currentItem.getLeft();

        if (leftItem.hasRight()) {
            ListItem itemToPointToRight = leftItem;
            while (itemToPointToRight.hasRight()) {
                itemToPointToRight = itemToPointToRight.getRight();
            }
            itemToPointToRight.setRight(leftItem.getRight());
        }

        if (leftItem.hasLeft()) {
            currentItem.setLeft(leftItem.getLeft());
        } else if (leftItem.hasRight()) {
            currentItem.setLeft(leftItem.getRight());
        } else {
            currentItem.setLeft(null);
        }
    }

    private void rightItemRemoval(ListItem currentItem) {
        ListItem rightItem = currentItem.getRight();

        if (rightItem.hasLeft()) {
            ListItem itemToPointToLeft = rightItem;
            while (itemToPointToLeft.hasLeft()) {
                itemToPointToLeft = itemToPointToLeft.getLeft();
            }
            itemToPointToLeft.setLeft(rightItem.getLeft());
        }

        if (rightItem.hasRight()) {
            currentItem.setRight(rightItem.getRight());
        } else if (rightItem.hasLeft()) {
            currentItem.setRight(rightItem.getLeft());
        } else {
            currentItem.setRight(null);
        }
    }

    private void printOrdered(ListItem base) {
        if (base != null) {
            printOrdered(base.getLeft());
            System.out.println(base.getValue());
            printOrdered(base.getRight());
        }
        /*
        if (base.hasLeft()) {
            printOrdered(base.getLeft());
            System.out.println(base.getValue());
        } else {
            System.out.println(base.getValue());
        }
        if (base.hasRight()) {
            printOrdered(base.getRight());
        }
        */
    }

    public void printOrdered() {
        if (this.root == null) {
            System.out.println("List is empty.");
        } else {
            printOrdered(this.root);
        }
    }

    public void printPathToItem(Object objectToFind) {
        boolean searching = true;
        boolean atLeftEnd, atRightEnd;
        ListItem currentNode = this.getRoot();
        int count = 0;

        while (searching) {
            if (!currentNode.hasLeft()) {
                atLeftEnd = true;
            } else {
                atLeftEnd = false;
            }

            if (!currentNode.hasRight()) {
                atRightEnd = true;
            } else {
                atRightEnd = false;
            }

            System.out.println("At branch #" + count + " (0 = root); Current value: " + currentNode.getValue());
            if (currentNode.compareTo(objectToFind) == 0) {
                System.out.println("Value found: " + objectToFind.toString());
                searching = false;
            } else if (currentNode.compareTo(objectToFind) > 0) { //new is less than current
                if (atLeftEnd) {
                    System.out.println("Value not in list");
                    searching = false;
                } else {
                    System.out.println("Moving to the left of " + currentNode.getValue());
                    currentNode = currentNode.getLeft();
                }
            } else if (currentNode.compareTo(objectToFind) < 0) { //new is less than current
                if (atRightEnd) {
                    System.out.println("Value not in list");
                    searching = false;
                } else {
                    System.out.println("Moving to the right of " + currentNode.getValue());
                    currentNode = currentNode.getRight();
                }
            } else {
                System.out.println("Wtf shouldn't be here");
            }
            count++;
        }
    }

}
