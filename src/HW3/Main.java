/*  1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    2. Задача:
    - Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    - Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    - Для хранения фруктов внутри коробки можно использовать ArrayList;
    - Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
      вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    - Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
      которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
      Можно сравнивать коробки с яблоками и апельсинами;
    - Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
      Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
      Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    - Не забываем про метод добавления фрукта в коробку.
*/
package HW3;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Create box of apples.
        var apples = new Box<Apple>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        System.out.println("Apple box wieght: " + apples.getWeight());

        // 2. Create box of oranges.
        var oranges = new Box<Orange>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        System.out.println("Orange box weight: " + oranges.getWeight());

        // 3. Create yet-another-apple box.
        var ya_apples = new Box<Apple>();
        ya_apples.add(new Apple());
        ya_apples.add(new Apple());
        ya_apples.add(new Apple());
        System.out.println("Yet-another-apple box size: " + ya_apples.size());

        // 4. Compare equal boxes.
        System.out.println("Compare equal boxes: " + apples.compare(ya_apples));

        // 5. Compare oranges and apples.
        System.out.println("Compare inequal boxes: " + apples.compare(oranges));

        // 6. Move apples to oranges (compile error).
        // apples.moveTo(oranges);

        // 7. Move apples to another apple box.
        apples.moveTo(ya_apples);
        System.out.println("Apple box size after movement: " + apples.size() + ". Yet-another-apple box size: " + ya_apples.size());
    }
}


