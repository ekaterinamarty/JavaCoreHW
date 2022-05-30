package HW3;

import java.util.ArrayList;

public class Box<T extends Fruit> extends ArrayList<T> {
    public double getWeight() {
        var w = .0;
        for (T item : this) {
            w += item.getWeight();
        }
        return w;
    }

    public boolean compare(Box<? extends Fruit> other) {
        return this.getWeight() == other.getWeight();
    }

    public void moveTo(Box<T> other) {
        while (size() > 0) {
            other.add(remove(0));
        }
    }
}
