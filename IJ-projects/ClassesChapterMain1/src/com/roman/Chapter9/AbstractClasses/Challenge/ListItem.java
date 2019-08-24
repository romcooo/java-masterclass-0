package com.roman.Chapter9.AbstractClasses.Challenge;

public abstract class ListItem {
    private ListItem left;
    private ListItem right;
    private Object value;

    public ListItem(final Object value) {
        this(null, null, value);
    }

    public ListItem(final ListItem left, final ListItem right, final Object value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public ListItem getLeft() {
        return left;
    }

    public ListItem getRight() {
        return right;
    }

    public Object getValue() {
        return value;
    }

    public void setLeft(final ListItem left) {
        this.left = left;
    }

    public void setRight(final ListItem right) {
        this.right = right;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public boolean hasRight() {
        return (this.right != null);
    }

    public boolean hasLeft() {
        return (this.left != null);
    }

    public abstract ListItem right();
    public abstract ListItem left();
    public abstract int compareTo(Object object);
//    public abstract ListItem add(Object toAdd);
//    public abstract boolean remove(Object toRemove);
    public abstract void setItemAsLeft(ListItem itemToSetAsLeft);
    public abstract void setItemAsRight(ListItem itemToSetAsRight);
    public abstract boolean remove();

}
