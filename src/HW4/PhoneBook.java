package HW4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook extends HashMap<String, HashSet<PhoneNumber>> {
    public void add(String name, PhoneNumber number) {
        var numbers = get(name);
        if (numbers == null) {
            numbers = new HashSet<>();
            put(name, numbers);
        }
        numbers.add(number);
    }

    public void print(String name) {
        if (containsKey(name)) {
            var numbers = get(name);
            System.out.println(name + ": " + (numbers == null ? "" : Arrays.toString(numbers.toArray())));
        }
        else {
            System.out.println("Subscriber with the name '" + name + "' not found.");
        }
    }

    public void printAll() {
        System.out.println("Printing the book:");
        for (var e : this.entrySet()) {
            var name = e.getKey();
            var numbers = e.getValue();
            System.out.println("\t" + name + ": " + (numbers == null ? "" : Arrays.toString(numbers.toArray())));
        }
    }
}
