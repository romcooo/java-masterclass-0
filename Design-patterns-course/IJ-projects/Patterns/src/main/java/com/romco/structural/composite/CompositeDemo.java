package com.romco.structural.composite;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {
    default int sum() {
        int sum = 0;
        for (int i : this) {
            sum += i;
        }
        return sum;
    }
}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {

}


class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int sum = 0;
        for (ValueContainer vc : this) {
            sum += vc.sum();
        }
        return sum;
    }
}


public class CompositeDemo {
    public static void main(String[] args) {
        ManyValues manyValues1 = new ManyValues();
        manyValues1.add(4);
        manyValues1.add(5);
        manyValues1.add(6);

        Collection<ValueContainer> valueContainers = new ArrayList<>();
        valueContainers.add(new SingleValue(1));
        valueContainers.add(new SingleValue(2));
        valueContainers.add(new SingleValue(3));
        valueContainers.add(manyValues1);

        MyList list = new MyList(valueContainers);

        System.out.println(list.sum());
    }
}
