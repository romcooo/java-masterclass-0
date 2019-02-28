package com.roman.Chapter9.AbstractClasses.Challenge;

public abstract class ListItem {
    private ListItem previous;
    private ListItem next;
    private Object value;

    public ListItem(final Object value) {
        this(null, null, value);
    }

    public ListItem(final ListItem previous, final ListItem next, final Object value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public ListItem getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }

    public void setPrevious(final ListItem previous) {
        this.previous = previous;
    }

    public void setNext(final ListItem next) {
        this.next = next;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public boolean hasNext() {
        return (this.next != null);
    }

    public boolean hasPrevious() {
        return (this.previous != null);
    }

    public abstract ListItem next();
    public abstract ListItem previous();
    public abstract int compareTo(Object object);
//    public abstract ListItem add(Object toAdd);
//    public abstract boolean remove(Object toRemove);
    public abstract void setItemAsPrevious(ListItem itemToAddAsPrevious);
    public abstract void setItemAsNext(ListItem itemToAddAsNext);
    public abstract boolean remove();

}
