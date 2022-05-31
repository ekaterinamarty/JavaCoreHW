package HW4;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Задание 4 (тема Коллекции)

1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.

2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
Консоль использовать только для вывода результатов проверки телефонного справочника.
*/

public class App {
    public static void main(String[] args) throws Exception {
        // PhoneNumberTests();
        homeApp4Section1();
        homeApp4Section2();
    }

    private static void homeApp4Section1() {
        // 1. Count unique words in a list.
        var words = Arrays.asList(
                "primary",
                "echo",
                "qualify",
                "hypothesis",
                "runner",
                "seat",
                "treat",
                "runner",
                "describe",
                "goal",
                "runner",
                "pillow",
                "depressed",
                "dine",
                "echo",
                "qualify",
                "constraint",
                "wait",
                "pluck",
                "echo"
        );
        var unique_words = words.stream().distinct().collect(
                Collectors.toMap(
                        k -> k,
                        v -> words.stream().filter(x -> x == v).count())
        );
        System.out.println("Unique words count: " + unique_words.size());
        System.out.println("Word list with numbers of occurrences:");
        for (var e : unique_words.entrySet()) {
            System.out.printf("%10s : %d\n", e.getKey(), e.getValue());
        }
    }

    private static void homeApp4Section2() {
        var book = new PhoneBook();
        // Subscriber #1
        book.add("Ivanov", new PhoneNumber("+79021012345"));
        book.add("Ivanov", new PhoneNumber("+79021012345")); // Duplicated number.
        book.add("Ivanov", new PhoneNumber("+79021112345"));
        // Subscriber #2
        book.add("Petrov", new PhoneNumber("+79021112345")); // The same number as Ivanov's.
        book.add("Petrov", new PhoneNumber("+79022200000"));
        book.add("Petrov", new PhoneNumber(""));
        // Subscriber #3
        book.add("Sidorov", new PhoneNumber("89681023412"));
        book.printAll();

        // Get numbers by name.
        var numbers = book.get("Ivanov");
        System.out.println(numbers);

        // Get numbers by nonexistent name.
        numbers = book.get("Korolev");
        System.out.println(numbers);
    }

    private static void PhoneNumberTests() {
        var n1 = new PhoneNumber("+79021012345");
        var n2 = new PhoneNumber("+79021012345");
        System.out.println(n1.equals(n2)); // Should be true.

        var n3 = new PhoneNumber("+79021112345");
        System.out.println(n1.equals(n3)); // Should be false.

        var n4 = new PhoneNumber("");
        System.out.println(n4.equals(n4)); // Should be true.
        System.out.println(n1.equals(n4)); // Should be false.

        var n5 = new PhoneNumber(null);
        var n6 = new PhoneNumber(null);
        System.out.println(n5.equals(n5)); // Should be true.
        System.out.println(n5.equals(n6)); // Should be true.
        System.out.println(n1.equals(n6)); // Should be false.
    }
}