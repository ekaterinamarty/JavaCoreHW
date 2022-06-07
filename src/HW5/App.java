package HW5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/*
Задание 5 (тема Средства ввода - вывода)

1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
| Строка заголовок с набором столбцов |
| Набор строк с целочисленными значениями |
| * Разделитель между столбцами - символ точка с запятой (;) |

Пример:
Value 1;Value 2;Value 3
100;200;123
300,400,500
Для хранения данных использовать класс вида:
public class AppData {
  private String[] header;
  private int[][] data;

 // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
*/

public class App {
    public static void main(String[] args) throws Exception {
        var csv_path = ".\\applicationData.csv";
        var data_size = 1000000;
        // 1. Save data to file.
        var da = saveData(csv_path, 1000000);
        // 2. Read data from file.
        var db = readData(csv_path);

        // Test random entries for equality.
        var rnd = new Random();
        for (int k = 0 ; k < 10; k++) {
            var index = rnd.nextInt(data_size);
            System.out.printf("Compare row %d entries: %b\n", index, Arrays.equals(da.get(index), db.get(index)));
        }
    }

    private static AppData saveData(String path, int num) throws FileNotFoundException {
        // Init application data.
        var headers = new String[] {
                "Value 1",
                "Value 2",
                "Value 3",
                "Value 4",
                "Value 5",
        };
        var rand = new Random();
        var data = new AppData(headers);
        for (int i = 0; i < num; i++) {
            var entry = new int[] {
                    rand.nextInt(10),
                    rand.nextInt(50) + 100,
                    rand.nextInt(1000),
                    rand.nextInt(1000),
                    rand.nextInt(1000) + 90,
            };
            data.add(entry);
        }
        // Save to file.
        data.saveCsv(path);
        return data;
    }

    private static AppData readData(String path) throws IOException, MyArrayDataException {
        return new AppData(path);
    }
}
