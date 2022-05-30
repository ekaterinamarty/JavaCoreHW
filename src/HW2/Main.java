/*  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

    3. В методе main() вызвать полученный метод, обработать возможные исключения
    MyArraySizeException и MyArrayDataException и вывести результат расчета
*/


package HW2;

public class Main {
    public static void main(String[] args) throws Exception {
        String[][] a = {
                { "1", "2", "3", "4" },
                { "6", "4", "3", "2" },
                { "3", "2", "1", "6" },
                { "7", "6", "9", "12" },
        };
        try {
            System.out.println(method(a));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int method(String[][] array) throws Exception {
        if (array.length != 4)
            throw new MyArraySizeException("The number of rows doesn't equal to 4.");
        // Ensure each sub-array contains correct number of elements.
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException(String.format("The number of columns in row '%d' doesn't equal to 4.", i));
        }
        // Parsing & summing.
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                var s = array[i][k];
                try {
                    sum += Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Unable to parse string value '%s' in location (%d, %d).", s, i, k), e);
                }
            }
        }
        return sum;
    }
}
